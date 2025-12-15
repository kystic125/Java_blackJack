package java_BlackJack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = createCards();
        Collections.shuffle(cards);


    }

    private List<Card> createCards() {
        List<Card> cards = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(shape, rank));
            }
        }
        return cards;
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("덱에 카드가 없습니다");
        }
        return cards.removeFirst();
    }
}