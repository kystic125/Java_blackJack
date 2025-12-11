package java_BlackJack.domain;

public class AceAdjuster {

    public int adjust(int score, int aceCount) {
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }

        return score;
    }
}
