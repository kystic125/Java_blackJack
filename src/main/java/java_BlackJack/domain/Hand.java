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

    public int getCardCount() {
        return cards.size();
    }
}
