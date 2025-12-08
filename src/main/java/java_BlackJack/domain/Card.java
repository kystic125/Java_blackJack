package java_BlackJack.domain;

public class Card {
    private final Shape shape;
    private final Rank rank;

    public Card(Shape shape, Rank rank) {
        this.shape = shape;
        this.rank = rank;
    }

    public String getRank() {
        return rank.getRank();
    }

    public int getScore() {
        return rank.getValue();
    }

    @Override
    public String toString() {
        return shape.getShape() + rank.getRank();
    }
}
