package com.mss.uno;

import com.mss.uno.Card.Card;
import com.mss.uno.Card.CardColor;
import com.mss.uno.Card.CardType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void testAddCard() {
        Player p1 = new Player("Luke");
        Card testCard = new Card(CardType.BDE, CardColor.GREEN);
        p1.addCard(testCard);

        assertTrue( p1.getHand().contains(testCard));
    }

    @Test
    void addCards() {
        Player p1 = new Player("Luke");
        Card testCard1 = new Card(CardType.BDE, CardColor.GREEN);
        Card testCard2 = new Card(CardType.BN, CardColor.GREY);
        Card testCard3 = new Card(CardType.CORPS, CardColor.GREEN);
        List<Card> testCards = new ArrayList<Card>();
        testCards.add(testCard1);
        testCards.add(testCard2);
        testCards.add(testCard3);

        p1.addCards(testCards);

        assertTrue( p1.getHand().containsAll(testCards));
    }

    @Test
    void testGetHandSize() {
        Player p1 = new Player("Davon");
        p1.addCard(new Card(CardType.BN, CardColor.GREEN));
        p1.addCard(new Card(CardType.BDE, CardColor.GOLD));
        p1.addCard(new Card(CardType.FIELD_ARMY, CardColor.GOLD));

        assertEquals(3, p1.getHandSize());

    }
}