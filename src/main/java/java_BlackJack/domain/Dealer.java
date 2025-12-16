package java_BlackJack.domain;

import java.util.List;

public class Dealer {

    private final Hand hand;
    private final Deck deck;

    public Dealer(Deck deck) {
        this.hand = new Hand();
        this.deck = deck;
    }

    public Dealer(Deck deck, Hand hand) {
        this.hand = hand;
        this.deck = deck;
    }

    public Card drawCard() {
        return deck.drawCard();
    }

    public void hit() {
        hand.addCard(deck.drawCard());
    }

    public boolean shouldHit() {
        return hand.getScore() <= 16;
    }

    public List<Card> getCards() {
        return hand.getCards();
    }

    public int getScore() {
        return hand.getScore();
    }

    public boolean isBurst() {
        return hand.isBurst();
    }

    public boolean isBlackJack() {
        return hand.isBlackJack();
    }
}