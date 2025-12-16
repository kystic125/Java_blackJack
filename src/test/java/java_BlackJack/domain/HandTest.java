package java_BlackJack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HandTest {

    @Test
    void 점수계산테스트() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.FIVE));
        hand.addCard(new Card(Shape.DIAMOND, Rank.KING));

        assertThat(hand.getScore()).isEqualTo(15);
    }

    @Test
    void ACE11로계산() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.FIVE));
        hand.addCard(new Card(Shape.DIAMOND, Rank.ACE));

        assertThat(hand.getScore()).isEqualTo(16);
    }

    @Test
    void ACE1로계산() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.FIVE));
        hand.addCard(new Card(Shape.DIAMOND, Rank.ACE));
        hand.addCard(new Card(Shape.CLOVER, Rank.SEVEN));

        assertThat(hand.getScore()).isEqualTo(13);
    }

    @Test
    void 블랙잭() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.KING));
        hand.addCard(new Card(Shape.DIAMOND, Rank.ACE));

        assertThat(hand.isBlackJack()).isTrue();
    }

    @Test
    void 버스트() {
        Hand hand = new Hand();
        hand.addCard(new Card(Shape.HEART, Rank.QUEEN));
        hand.addCard(new Card(Shape.DIAMOND, Rank.KING));
        hand.addCard(new Card(Shape.CLOVER, Rank.SEVEN));

        assertThat(hand.isBurst()).isTrue();
    }



}