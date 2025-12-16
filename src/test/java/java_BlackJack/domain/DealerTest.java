package java_BlackJack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DealerTest {


    @Test
    void 딜러_16이하_히트() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.TWO));
        hand.addCard(new Card(Shape.HEART, Rank.THREE));

        Dealer dealer = new Dealer(new Deck(), hand);

        assertThat(dealer.shouldHit()).isTrue();
    }

    @Test
    void 딜러_17이상_스탠드() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.KING));
        hand.addCard(new Card(Shape.HEART, Rank.QUEEN));

        Dealer dealer = new Dealer(new Deck(), hand);

        assertThat(dealer.shouldHit()).isFalse();
    }

    @Test
    void 딜러_블랙잭() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.KING));
        hand.addCard(new Card(Shape.HEART, Rank.ACE));

        Dealer dealer = new Dealer(new Deck(), hand);

        assertThat(dealer.isBlackJack()).isTrue();
    }

    @Test
    void 딜러_버스트() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.KING));
        hand.addCard(new Card(Shape.HEART, Rank.QUEEN));
        hand.addCard(new Card(Shape.HEART, Rank.JACK));

        Dealer dealer = new Dealer(new Deck(), hand);

        assertThat(dealer.isBurst()).isTrue();
    }


}