package java_BlackJack.domain;

public class BlackJackChecker {

    public boolean isBlackJack(int score, int cardCount) {
        return score == 21 && cardCount == 2;
    }
}
