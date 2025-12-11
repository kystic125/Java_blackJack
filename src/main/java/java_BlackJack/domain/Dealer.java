package java_BlackJack.domain;

import java.util.List;

public class Dealer {

    private final Hand hand;
    private final Deck deck;

    public Dealer(Deck deck) {
        this.hand = new Hand();
        this.deck = deck;
    }

    public void deal(Player player) {
        player.receiveCard(deck.drawCard());
    }

    public void drawCard() {
        hand.addCard(deck.drawCard());
    }

    public List<Card> openCards() {
        List<Card> cards = hand.getCards();
        return cards.subList(1, cards.size());
    }

    public boolean shouldHit(int score) {
        return score <= 16;
    }

    public Hand getHand() {
        return hand;
    }
}