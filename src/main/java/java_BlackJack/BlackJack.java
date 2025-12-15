package java_BlackJack;

import java_BlackJack.domain.*;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ResultCalculator calculator = new ResultCalculator();

        String[] names = inputView.getPlayerNames();
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            int betting = inputView.getBettingAmount(name.trim());
            players.add(new Player(name.trim(), betting));
        }

        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        Game game = new Game(dealer, players, inputView, outputView);
        game.start();

        outputView.showFinalResult(dealer, players);
        outputView.showProfitResult(dealer, players, calculator);
    }

    public static void main(String[] args) {
        new BlackJack().start();
    }
}
