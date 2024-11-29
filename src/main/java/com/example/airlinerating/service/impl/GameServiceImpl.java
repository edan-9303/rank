package com.example.airlinerating.service.impl;

import com.example.airlinerating.Entity.Game;
import com.example.airlinerating.Entity.User;
import com.example.airlinerating.repository.GameRepository;
import com.example.airlinerating.repository.UserRepository;
import com.example.airlinerating.service.GameService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addGameAndUpdateRatings(List<Game> games) {
        // 게임 데이터를 저장
        gameRepository.saveAll(games);

        int sumRatings = 0;
        // 게임에 참가한 유저들의 랭킹에 따른 레이팅 업데이트
        for (Game game : games) {
            // 유저의 rating을 계산
            sumRatings += updateUserRating(game);
        }

        // 랭킹에 따른 레이팅 보상 처리
        applyRankingRewards(games, sumRatings);
    }

    private int updateUserRating(Game game) {
        int ratingChange = 0;

        // rebuyins에 따라 레이팅 차감
        if (game.getRebuyins() == 1) {
            ratingChange = -10;
        } else if (game.getRebuyins() == 2) {
            ratingChange = -25;
        } else if (game.getRebuyins() == 3) {
            ratingChange = -45;
        }

        User user;
        if (!game.getEmail().equals("게스트")) {
            user = userRepository.findByEmail(game.getEmail())
                    .orElseThrow(() -> new IllegalArgumentException("User not found with email " + game.getEmail()));
            if (user.getRating() == -1) {
                user.setRating(1000 + ratingChange);
            } else {
                user.setRating(user.getRating() + ratingChange);
            }
            userRepository.save(user);
            gameRepository.updateLostRatingByEntryId(ratingChange, game.getEntryId());
        }
        return ratingChange;
        // 언랭 유저일 경우, 시작은 1000점
        // 유저 레이팅 업데이트

    }

    private void applyRankingRewards(List<Game> games, int sumRatings) {
        // 게임에서 모든 유저의 rebuyins 합을 계산
        int totalRebuyins = games.stream().mapToInt(Game::getRebuyins).sum();

        // 랭킹에 따라 보상 적용
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);

            double rewardPercentage = 0.0;

            // 랭킹에 따른 보상 비율 결정
            switch (game.getRanking()) {
                case 1:
                    rewardPercentage = 0.5; // 1등에게 50% 보상
                    break;
                case 2:
                    rewardPercentage = 0.3; // 2등에게 30% 보상
                    break;
                case 3:
                    rewardPercentage = 0.2; // 3등에게 20% 보상
                    break;
            }

            // 총 rebuyins 합을 기준으로 보상
            double reward = -sumRatings;
            double ratingBonus = (reward * 1.3) * rewardPercentage;

            if (!game.getEmail().equals("게스트")) {
                User user = userRepository.findByEmail(game.getEmail())
                        .orElseThrow(() -> new IllegalArgumentException("User not found with email " + game.getEmail()));

                // 유저 레이팅에 보상 추가
                user.setRating(user.getRating() + ratingBonus);
                userRepository.save(user);
                gameRepository.updateEarnedRatingByEntryId(ratingBonus, game.getEntryId());
            }
        }
    }
}
