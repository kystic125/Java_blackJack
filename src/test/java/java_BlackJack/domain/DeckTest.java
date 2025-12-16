package java_BlackJack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void 덱_52장() {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }
    }

    @Test
    void 덱이_빈경우_예외() {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }

        Assertions.assertThatThrownBy(deck::drawCard)
                .isInstanceOf(IllegalStateException.class);
    }
}