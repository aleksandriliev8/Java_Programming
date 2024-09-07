package cards;

import java.util.Random;

public class StackOfCards {
    private Card[] cards; // масив от всички карти в тестето от карти
    private Card[] smallerPack; // масив на по-малкото тесте делени карти
    private Card[] largerPack; // масив на второто тесте делени карти
    private Card[] hand; // текущо изтеглена ръка от 12 карти
    private Random random; // генератор на случайни числа
    private int currentCard; // брой карти изтеглени текущо от cards
    private int[] faceCounters; // масив за брой на честотата на сила в hand

    public StackOfCards() {
        cards = new Card[64];
        int index = 0;
        for (int i = 0; i < Card.suits.length; i++) {
            for (int j = 0; j < Card.faces.length; j++) {
                cards[index++] = new Card(j, i);
                cards[index++] = new Card(j, i);
            }
        }
    }

    public void shuffleCards() {
        random = new Random();
        int index;
        Card temporary;
        for (int i = 0; i < cards.length; i++) {
            index = random.nextInt(cards.length);//vzima sluchaino chislo ot 0 do 64
            temporary = cards[i];
            cards[i] = cards[index];
            cards[index] = temporary;
        }
        currentCard = 0;
    }

    public String printCards() {
        String result = "";
        for (int i = 0; i < hand.length; i += 3) {
            result += String.format("%s, %s, %s\n", hand[i], hand[i + 1], hand[i + 2]);
        }
        return result;
    }

    public void make2packs() {
        shuffleCards();
        int N = random.nextInt(20, 31);
        smallerPack = new Card[N];
        largerPack = new Card[cards.length - N];
        int index = 0;
        for (int i = 0; i < N; i++) {
            smallerPack[i] = cards[index++];
        }
        for (int i = 0; i < cards.length - N; i++) {
            largerPack[i] = cards[index++];
        }
    }

    //???
    public boolean dealHand() {
        faceCounters = new int[Card.faces.length];//masiv[8]
        hand = new Card[12];
        if (cards.length - currentCard >= 12) {
            for (int i = 0; i < 12; i++) {
                if (smallerPack.length > currentCard) {
                    hand[i] = smallerPack[currentCard];
                    faceCounters[hand[i].getFace()]++;
                } else {
                    hand[i] = largerPack[currentCard - smallerPack.length];
                    faceCounters[hand[i].getFace()]++;
                }
                currentCard++;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean hasQueenAndKing() {
        return faceCounters[2] >= 1 && faceCounters[3] >= 1;
    }

    public boolean hasFiveQueen() {
        return faceCounters[3] == 5;
    }

}
