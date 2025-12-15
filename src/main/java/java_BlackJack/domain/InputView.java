package java_BlackJack.domain;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String[] getPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return scanner.nextLine().split(",");
    }

    public int getBettingAmount(String player) {
        while (true) {
            try {
                return validateAndGetBetting(player);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAndGetBetting(String player) {
        System.out.println(player + "의 배팅 금액은?");

        try {
            int amount = Integer.parseInt(scanner.nextLine());

            if (amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 배팅 금액은 1 이상이어야 합니다.");
            }

            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public boolean askPlayerHit(Player player) {
        System.out.println(player.getName() + "님, 카드를 더 받으시겠습니까? (y/n)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (!input.equals("y") && !input.equals("n")) {
            throw new IllegalArgumentException("[ERROR] y 또는 n을 입력해주세요.");
        }

        return input.equals("y");
    }
}
