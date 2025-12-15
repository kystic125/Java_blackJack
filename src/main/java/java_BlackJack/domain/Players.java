package java_BlackJack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Players {

    private final List<Player> players;

    public Players(String[] names, int betting) {
        this.players = Arrays.stream(names)
                .map(String::trim)
                .map(name -> new Player(name, betting))
                .toList();
    }

    public void forEach(Consumer<Player> action) {
        players.forEach(action);
    }
}
