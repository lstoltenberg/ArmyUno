package com.mss.uno;

import com.mss.uno.Card.Card;
import com.mss.uno.Card.CardColor;
import com.mss.uno.Card.CardType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    private List<Card> getSevenCards(){
        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card(CardType.BN, CardColor.BLACK));
        cards.add(new Card(CardType.BDE, CardColor.GOLD));
        cards.add(new Card(CardType.CO, CardColor.GREEN));
        cards.add(new Card(CardType.BN, CardColor.BLACK));
        cards.add(new Card(CardType.BN, CardColor.BLACK));
        cards.add(new Card(CardType.BN, CardColor.BLACK));
        cards.add(new Card(CardType.BN, CardColor.BLACK));

        return cards;
    }


    @Test
    public void testDeal(){
        Player p1 = new Player("Josh");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);

        List<Card> deck = new ArrayList<Card>();
        deck.addAll(this.getSevenCards());

        Game game = new Game(playerList, deck);
        game.initialDeal();

        assertTrue(deck.isEmpty());
        assertEquals(7, p1.getHand().size());
    }

    @Test
    public void testDealManyPLayers(){
        Player p1 = new Player("Josh");
        Player p2 = new Player("Luke");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);
        playerList.add(p2);

        List<Card> deck = new ArrayList<Card>();
        deck.addAll(this.getSevenCards());
        deck.addAll(this.getSevenCards());

        Game game = new Game(playerList, deck);

        game.initialDeal();

        assertTrue(deck.isEmpty());
        assertEquals(7, p1.getHand().size());
        assertEquals(7, p2.getHand().size());
    }


}