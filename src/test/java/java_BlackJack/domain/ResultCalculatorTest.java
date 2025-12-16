package java_BlackJack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultCalculatorTest {

    @Test
    void 플레이어_블랙잭_딜러_블랙잭_아님() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.ACE));

        Hand dealerHand = new Hand();
        dealerHand.addCard(new Card(Shape.HEART, Rank.TWO));
        dealerHand.addCard(new Card(Shape.HEART, Rank.THREE));
        Dealer dealer = new Dealer(new Deck(), dealerHand);

        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(15000);
    }

    @Test
    void 플레이어_블랙잭_딜러_블랙잭() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.ACE));

        Hand dealerHand = new Hand();
        Dealer dealer = new Dealer(new Deck(), dealerHand);
        dealerHand.addCard(new Card(Shape.HEART, Rank.KING));
        dealerHand.addCard(new Card(Shape.HEART, Rank.ACE));

        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(0);
    }

    @Test
    void 딜러블랙잭_플레이어일반() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.NINE));

        Hand dealerHand = new Hand();
        dealerHand.addCard(new Card(Shape.HEART, Rank.ACE));
        dealerHand.addCard(new Card(Shape.HEART, Rank.KING));

        Dealer dealer = new Dealer(new Deck(), dealerHand);
        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(-10000);
    }

    @Test
    void 플레이어_버스트() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.JACK));
        player.receiveCard(new Card(Shape.SPADE, Rank.QUEEN));

        Hand dealerHand = new Hand();
        dealerHand.addCard(new Card(Shape.HEART, Rank.KING));
        dealerHand.addCard(new Card(Shape.HEART, Rank.NINE));

        Dealer dealer = new Dealer(new Deck(), dealerHand);

        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(-10000);
    }

    @Test
    void 딜러_버스트() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.JACK));

        Hand dealerHand = new Hand();
        dealerHand.addCard(new Card(Shape.SPADE, Rank.KING));
        dealerHand.addCard(new Card(Shape.DIAMOND, Rank.KING));
        dealerHand.addCard(new Card(Shape.CLOVER, Rank.KING));

        Dealer dealer = new Dealer(new Deck(), dealerHand);

        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(10000);
    }

    @Test
    void 블랙잭_아닌_동점() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.QUEEN));

        Hand dealerHand = new Hand();
        dealerHand.addCard(new Card(Shape.CLOVER, Rank.KING));
        dealerHand.addCard(new Card(Shape.CLOVER, Rank.QUEEN));

        Dealer dealer = new Dealer(new Deck(), dealerHand);

        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(0);
    }

    @Test
    void 플레이어_승리() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.QUEEN));

        Hand dealerHand = new Hand();
        dealerHand.addCard(new Card(Shape.CLOVER, Rank.KING));
        dealerHand.addCard(new Card(Shape.CLOVER, Rank.SEVEN));

        Dealer dealer = new Dealer(new Deck(), dealerHand);

        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(10000);
    }

    @Test
    void 플레이어_패배() {
        Player player = new Player("player", 10000);
        player.receiveCard(new Card(Shape.SPADE, Rank.KING));
        player.receiveCard(new Card(Shape.SPADE, Rank.TWO));

        Hand dealerHand = new Hand();
        dealerHand.addCard(new Card(Shape.CLOVER, Rank.KING));
        dealerHand.addCard(new Card(Shape.CLOVER, Rank.SEVEN));

        Dealer dealer = new Dealer(new Deck(), dealerHand);

        ResultCalculator calculator = new ResultCalculator();

        assertThat(calculator.calculateBettingMoney(player, dealer)).isEqualTo(-10000);
    }
}