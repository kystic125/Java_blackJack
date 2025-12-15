package java_BlackJack.domain;

public class ResultCalculator {

    public int calculateBettingMoney(Player player, Dealer dealer) {
        int betting = player.getBettingMoney();

        if (player.isBurst()) {
            return -betting;
        }

        if (player.isBlackJack() && dealer.isBlackJack()) {
            return 0;
        }

        if (player.isBlackJack()) {
            return (int) (betting * 1.5);
        }

        if (dealer.isBurst()) {
            return betting;
        }

        if (player.getScore() > dealer.getScore()) {
            return betting;
        }

        if (player.getScore() == dealer.getScore()) {
            return 0;
        }

        return -betting;
    }
}
