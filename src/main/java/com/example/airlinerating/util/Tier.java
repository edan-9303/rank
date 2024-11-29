package com.example.airlinerating.util;

import com.example.airlinerating.DTO.TierDTO;

public class Tier {


    public static TierDTO getRank(double rank) {
        TierDTO tierDTO = new TierDTO();

        if (rank >= 2000) {
            tierDTO.setTier("challenger");
            tierDTO.setTierNumber(rank + "");
            return tierDTO;
        } else if (rank >= 1600) {
            return getMasterRank(rank, tierDTO);
        } else if (rank >= 1400) {
            return getDiamondRank(rank, tierDTO);
        } else if (rank >= 1300) {
            return getEmeraldRank(rank, tierDTO);
        } else if (rank >= 1200) {
            return getPlatinumRank(rank, tierDTO);
        } else if (rank >= 1100) {
            return getGoldRank(rank, tierDTO);
        } else if (rank >= 900) {
            return getSilverRank(rank, tierDTO);
        } else if (rank >= 700) {
            return getIronRank(rank, tierDTO);
        } else {
            tierDTO.setTier("unranked");
            tierDTO.setTierNumber("");
            return tierDTO;
        }
    }

    // 아이언 등급
    public static TierDTO getIronRank(double rank, TierDTO tierDTO) {
        if (rank >= 850) {
            tierDTO.setTier("iron");
            tierDTO.setTierNumber("1");
            return tierDTO;
        } else if (rank >= 800) {
            tierDTO.setTier("iron");
            tierDTO.setTierNumber("2");
            return tierDTO;
        } else if (rank >= 650) {
            tierDTO.setTier("iron");
            tierDTO.setTierNumber("3");
            return tierDTO;
        } else {
            tierDTO.setTier("iron");
            tierDTO.setTierNumber("4");
            return tierDTO;
        }
    }

    // 실버 등급
    public static TierDTO getSilverRank(double rank, TierDTO tierDTO) {
        if (rank >= 1050) {
            tierDTO.setTier("silver");
            tierDTO.setTierNumber("1");
            return tierDTO;
        } else if (rank >= 1000) {
            tierDTO.setTier("silver");
            tierDTO.setTierNumber("2");
            return tierDTO;
        } else if (rank >= 950) {
            tierDTO.setTier("silver");
            tierDTO.setTierNumber("3");
            return tierDTO;
        } else {
            tierDTO.setTier("silver");
            tierDTO.setTierNumber("4");
            return tierDTO;
        }
    }

    // 골드 등급
    public static TierDTO getGoldRank(double rank, TierDTO tierDTO) {
        if (rank >= 1175) {
            tierDTO.setTier("gold");
            tierDTO.setTierNumber("1");
            return tierDTO;
        } else if (rank >= 1150) {
            tierDTO.setTier("gold");
            tierDTO.setTierNumber("2");
            return tierDTO;
        } else if (rank >= 1125) {
            tierDTO.setTier("gold");
            tierDTO.setTierNumber("3");
            return tierDTO;
        } else {
            tierDTO.setTier("gold");
            tierDTO.setTierNumber("4");
            return tierDTO;
        }
    }

    // 플래티넘 등급
    public static TierDTO getPlatinumRank(double rank, TierDTO tierDTO) {
        if (rank >= 1275) {
            tierDTO.setTier("platinum");
            tierDTO.setTierNumber("1");
            return tierDTO;
        } else if (rank >= 1250) {
            tierDTO.setTier("platinum");
            tierDTO.setTierNumber("2");
            return tierDTO;
        } else if (rank >= 1225) {
            tierDTO.setTier("platinum");
            tierDTO.setTierNumber("3");
            return tierDTO;
        } else {
            tierDTO.setTier("platinum");
            tierDTO.setTierNumber("4");
            return tierDTO;
        }
    }

    // 에메랄드 등급
    public static TierDTO getEmeraldRank(double rank, TierDTO tierDTO) {
        if (rank >= 1375) {
            tierDTO.setTier("emerald");
            tierDTO.setTierNumber("1");
            return tierDTO;
        } else if (rank >= 1350) {
            tierDTO.setTier("emerald");
            tierDTO.setTierNumber("2");
            return tierDTO;
        } else if (rank >= 1325) {
            tierDTO.setTier("emerald");
            tierDTO.setTierNumber("3");
            return tierDTO;
        } else {
            tierDTO.setTier("emerald");
            tierDTO.setTierNumber("4");
            return tierDTO;
        }
    }

    // 다이아몬드 등급
    public static TierDTO getDiamondRank(double rank, TierDTO tierDTO) {
        if (rank >= 1550) {
            tierDTO.setTier("diamond");
            tierDTO.setTierNumber("1");

            return tierDTO;
        } else if (rank >= 1500) {
            tierDTO.setTier("diamond");
            tierDTO.setTierNumber("2");
            return tierDTO;
        } else if (rank >= 1450) {
            tierDTO.setTier("diamond");
            tierDTO.setTierNumber("3");
            return tierDTO;
        } else {
            tierDTO.setTier("diamond");
            tierDTO.setTierNumber("4");
            return tierDTO;
        }
    }

    // 마스터 등급
    public static TierDTO getMasterRank(double rank, TierDTO tierDTO) {
        if (rank >= 1900) {
            tierDTO.setTier("master");
            tierDTO.setTierNumber("1");
            return tierDTO;
        } else if (rank >= 1800) {
            tierDTO.setTier("master");
            tierDTO.setTierNumber("2");
            return tierDTO;
        } else if (rank >= 1700) {
            tierDTO.setTier("master");
            tierDTO.setTierNumber("3");
            return tierDTO;
        } else {
            tierDTO.setTier("master");
            tierDTO.setTierNumber("4");
            return tierDTO;
        }
    }
}
