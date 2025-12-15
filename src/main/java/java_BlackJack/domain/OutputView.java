package java_BlackJack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void showDealMessage(List<Player> players) {
        String names = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(", "));
        System.out.println("딜러와 " + names + "에게 2장의 카드를 나누었습니다.");
    }

    public void showPlayerCards(Player player) {
        String playerCards = player.getCards().stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
        System.out.println(player.getName() + ": " + playerCards);
    }

    public void showDealerInitialCards(Dealer dealer) {
        System.out.print("딜러: ");
        System.out.println(dealer.getCards().getFirst());
    }

    public void showDealerCards(Dealer dealer) {
        System.out.print("딜러: ");
        String cards = dealer.getCards().stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
        System.out.println(cards);
    }

    public void showDealerHit() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void showFinalResult(Dealer dealer, List<Player> players) {
        List<Card> cards = dealer.getCards();

        String dealerCards = dealer.getCards().stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
        System.out.println("딜러: " + dealerCards + " - 결과: " + dealer.getScore());

        for (Player player : players) {
            String playerCards = player.getCards().stream()
                    .map(Card::toString)
                    .collect(Collectors.joining(", "));
            System.out.println(player.getName() + ": " + playerCards + " - 결과: " + player.getScore());
        }
    }

    public void showProfitResult(Dealer dealer, List<Player> players, ResultCalculator calculator) {
        System.out.println();
        System.out.println("## 최종 수익");

        int dealerProfit = 0;
        for (Player player : players) {
            dealerProfit -= calculator.calculateBettingMoney(player, dealer);
        }
        System.out.println("딜러: " + dealerProfit);

        for (Player player : players) {
            int profit = calculator.calculateBettingMoney(player, dealer);
            System.out.println(player.getName() + ": " + profit);
        }
    }
}
