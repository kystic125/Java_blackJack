package java_BlackJack.domain;

public class Card {
    private final Shape shape;
    private final Rank rank;

    public Card(Shape shape, Rank rank) {
        this.shape = shape;
        this.rank = rank;
    }

    public int getScore() {
        return rank.getValue();
    }

    public boolean isAce() {
        return rank == Rank.ACE;
    }

    @Override
    public String toString() {
        return shape.getShape() + rank.getRank();
    }
}
