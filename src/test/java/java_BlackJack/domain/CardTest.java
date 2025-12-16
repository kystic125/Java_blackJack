package java_BlackJack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CardTest {

    @Test
    void 점수_확인() {
        Card card1 = new Card(Shape.HEART, Rank.FIVE);
        Card card2 = new Card(Shape.HEART, Rank.KING);
        assertThat(card1.getScore()).isEqualTo(5);
        assertThat(card2.getScore()).isEqualTo(10);

    }

    @Test
    void ACE_확인() {
        Card card = new Card(Shape.HEART, Rank.ACE);
        assertThat(card.isAce()).isTrue();
    }
}