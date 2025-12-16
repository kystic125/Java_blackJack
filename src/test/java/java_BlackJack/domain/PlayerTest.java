package java_BlackJack.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void 플레이어_카드받기() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.HEART, Rank.JACK));

        assertThat(player.getCards()).hasSize(1);
    }

    @Test
    void 플레이어_블랙잭() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.HEART, Rank.ACE));
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));

        assertThat(player.isBlackJack()).isTrue();
    }

    @Test
    void 플레이어_버스트() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.HEART, Rank.QUEEN));
        player.receiveCard(new Card(Shape.HEART, Rank.JACK));

        assertThat(player.isBurst()).isTrue();
    }
}