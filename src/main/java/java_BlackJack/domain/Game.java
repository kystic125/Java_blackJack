package java_BlackJack.domain;

import java.util.List;

public class Game {
    private final Dealer dealer;
    private final List<Player> players;
    private final InputView inputView;
    private final OutputView outputView;

    public Game(Dealer dealer, List<Player> players, InputView inputView, OutputView outputView) {
        this.dealer = dealer;
        this.players = players;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void dealCards() {
        for (int i = 0; i < 2; i++) {
            players.forEach(player -> player.receiveCard(dealer.drawCard()));
            dealer.hit();
        }
    }

    private void showInitialCards() {
        outputView.showDealerInitialCards(dealer);
        players.forEach(outputView::showPlayerCards);
    }

    private void playerTurn(Player player) {

        if (player.isBlackJack()) {
            return;
        }

        while (!player.isBurst()) {
            try {
                if (!inputView.askPlayerHit(player)) {
                    break;
                }
                player.receiveCard(dealer.drawCard());
                outputView.showPlayerCards(player);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void dealerTurn() {
        if (dealer.isBlackJack()) {
            return;
        }

        while (!dealer.isBurst() && dealer.shouldHit()) {
            outputView.showDealerHit();
            dealer.hit();
            outputView.showDealerCards(dealer);
        }
    }

    public void start() {
        outputView.showDealMessage(players);
        dealCards();
        showInitialCards();
        players.forEach(this::playerTurn);
        dealerTurn();
    }
}
