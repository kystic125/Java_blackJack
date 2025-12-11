package java_BlackJack.domain;

import java.util.List;

public class Player {

    private final String name;
    private final int bettingMoney;
    private final Hand hand;

    public Player(String name, int bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
        this.hand = new Hand();
    }

    public void receiveCard(Card card) {
        hand.addCard(card);
    }

    public List<Card> openCards() {
        return hand.getCards();
    }

    public String getName() {
        return name;
    }

    public int getBettingMoney() {
        return bettingMoney;
    }

    public Hand getHand() {
        return hand;
    }
}
