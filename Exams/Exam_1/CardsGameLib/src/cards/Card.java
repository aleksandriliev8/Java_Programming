package cards;

public class Card {
    private int face; // сила на карта
    private int suit; // цвят на карта

    public static String[] faces = new String[]{"ACE", "TEN", "KING"
            , "QUEEN", "JACK", "NINE", "EIGHT", "SEVEN" };
    public static String[] suits = new String[]{"CLUBS", "DIAMONDS", "HEARTS", "SPADES" };

    public Card(int face, int suit) {
        setFace(face);
        setSuit(suit);
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        if (face >= 0 && face <= 7) {
            this.face = face;
        } else {
            this.face = 0;
        }

    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        if (suit >= 0 && suit <= 3) {
            this.suit = suit;
        } else {
            this.suit = 0;
        }
    }

    public String getSuitName() {
        return suits[suit];
    }

    @Override
    public String toString() {
        return String.format("%s of %s", faces[face], suits[suit]);
    }
}
