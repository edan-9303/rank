package com.example.airlinerating.util;

public class Tier {
    public static String getRank(int rank) {
        if (rank >= 2200) {
            return "챌린저";
        } else if (rank >= 1800) {
            return getMasterRank(rank);
        } else if (rank >= 1600) {
            return getDiamondRank(rank);
        } else if (rank >= 1400) {
            return getEmeraldRank(rank);
        } else if (rank >= 1200) {
            return getPlatinumRank(rank);
        } else if (rank >= 1000) {
            return getGoldRank(rank);
        } else if (rank >= 800) {
            return getSilverRank(rank);
        } else if (rank >= 600) {
            return getIronRank(rank);
        } else {
            return "점수가 범위에 없습니다.";
        }
    }

    // 아이언 등급
    public static String getIronRank(int rank) {
        if (rank >= 750) {
            return "아이언 1";
        } else if (rank >= 700) {
            return "아이언 2";
        } else if (rank >= 650) {
            return "아이언 3";
        } else {
            return "아이언 4";
        }
    }

    // 실버 등급
    public static String getSilverRank(int rank) {
        if (rank >= 950) {
            return "실버 1";
        } else if (rank >= 900) {
            return "실버 2";
        } else if (rank >= 850) {
            return "실버 3";
        } else {
            return "실버 4";
        }
    }

    // 골드 등급
    public static String getGoldRank(int rank) {
        if (rank >= 1150) {
            return "골드 1";
        } else if (rank >= 1100) {
            return "골드 2";
        } else if (rank >= 1050) {
            return "골드 3";
        } else {
            return "골드 4";
        }
    }

    // 플래티넘 등급
    public static String getPlatinumRank(int rank) {
        if (rank >= 1350) {
            return "플래티넘 1";
        } else if (rank >= 1300) {
            return "플래티넘 2";
        } else if (rank >= 1250) {
            return "플래티넘 3";
        } else {
            return "플래티넘 4";
        }
    }

    // 에메랄드 등급
    public static String getEmeraldRank(int rank) {
        if (rank >= 1450) {
            return "에메랄드 1";
        } else if (rank >= 1400) {
            return "에메랄드 2";
        } else if (rank >= 1350) {
            return "에메랄드 3";
        } else {
            return "에메랄드 4";
        }
    }

    // 다이아몬드 등급
    public static String getDiamondRank(int rank) {
        if (rank >= 1550) {
            return "다이아몬드 1";
        } else if (rank >= 1500) {
            return "다이아몬드 2";
        } else if (rank >= 1450) {
            return "다이아몬드 3";
        } else {
            return "다이아몬드 4";
        }
    }

    // 마스터 등급
    public static String getMasterRank(int rank) {
        if (rank >= 1700) {
            return "마스터 1";
        } else if (rank >= 1650) {
            return "마스터 2";
        } else if (rank >= 1600) {
            return "마스터 3";
        } else {
            return "마스터 4";
        }
    }
}
