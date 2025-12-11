package java_BlackJack.domain;

public class ScoreCalculator {

    private final AceAdjuster aceAdjuster = new AceAdjuster();

    public int calculate(Hand hand) {
        int total = hand.getCards().stream()
                .mapToInt(Card::getScore)
                .sum();

        int aceCount = (int) hand.getCards().stream()
                .filter(Card::isAce)
                .count();

        return aceAdjuster.adjust(total, aceCount);
    }
}
