package java_BlackJack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public int getScore() {
        int total = cards.stream()
                .mapToInt(Card::getScore)
                .sum();

        int aceCount = (int) cards.stream()
                .filter(Card::isAce)
                .count();

        return adjustAce(total, aceCount);
    }

    private int adjustAce(int score, int aceCount) {
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
        return score;
    }

    public boolean isBurst() {
        return getScore() > 21;
    }

    public boolean isBlackJack() {
        return getScore() == 21 && cards.size() == 2;
    }
}
