package java_BlackJack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int totalScore = cards.stream()
                .mapToInt(Card::getScore)
                .sum();

        int aceCount = (int) cards.stream()
                .filter(Card::isAce)
                .count();

        while (totalScore > 21 && aceCount >= 1) {
            totalScore -= 10;
            aceCount --;
        }

        return totalScore;
    }

    public List<Card> openPlayerCards() {
        return Collections.unmodifiableList(cards);
    }

}
