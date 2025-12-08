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
        int aceCount = 0;
        int totalScore = 0;
        for (Card card : cards) {
            totalScore += card.getScore();
            if (card.getRank().equals("ACE")) {
                aceCount ++;
            }
        }

        while (totalScore > 21 && aceCount >= 1) {
            totalScore -= 10;
            aceCount --;
        }

        return totalScore;
    }

    public List<Card> openCards() {
        return Collections.unmodifiableList(cards);
    }

}
