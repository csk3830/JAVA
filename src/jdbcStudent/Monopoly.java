package jdbcStudent;

import java.util.Random;
import java.util.Scanner;

public class Monopoly {
	public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        System.out.println(RED + "이것은 빨간색 텍스트입니다." + RESET);
        System.out.println(GREEN + "이것은 초록색 텍스트입니다." + RESET);
        System.out.println(BLUE + "이것은 파란색 텍스트입니다." + RESET);
        System.out.println(YELLOW + "이것은 노란색 텍스트입니다." + RESET);

        // 예시: 게임에서 플레이어 상태 출력
        String playerName = "Yuri";
        int playerMoney = 1500000;
        System.out.println(CYAN + playerName + RESET + "님의 보유 금액: " + YELLOW + playerMoney + RESET + "원");
    }
}

