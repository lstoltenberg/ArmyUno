package com.mss.uno;

import com.mss.uno.Card.Card;
import com.mss.uno.Card.CardColor;
import com.mss.uno.Card.CardType;
import org.junit.jupiter.api.Test;

import javax.swing.text.Caret;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GameTest {

    @Test
    public void whenGameIsInstantiated_shouldCreateDeckOfCorrectLength(){
        Player p1 = new Player("Josh");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);
        Game game = new Game(playerList);

        assertEquals(104, game.getDeck().size());
    }

    @Test
    public void whenGameIsInstantiated_deckComposistionIsCorrect(){
        Player p1 = new Player("Josh");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);
        Game game = new Game(playerList);
        List<Card> deck = game.getDeck();

        assertEquals(24, deck.stream().filter(a -> a.color == CardColor.BLACK).count());
        assertEquals(24, deck.stream().filter(a -> a.color == CardColor.GREEN).count());
        assertEquals(24, deck.stream().filter(a -> a.color == CardColor.GOLD).count());
        assertEquals(24, deck.stream().filter(a -> a.color == CardColor.GREY).count());
        assertEquals(8, deck.stream().filter(a -> a.color == null).count());

        assertEquals(4, deck.stream().filter(a -> a.type == CardType.PLUS_FOUR).count());
        assertEquals(4, deck.stream().filter(a -> a.type == CardType.WILD).count());

        assertEquals(8, deck.stream().filter(a -> a.type == CardType.SKIP).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.REVERSE).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.PLUS_TWO).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.TM).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.SQD).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.PL).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.CO).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.BN).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.BDE).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.DIV).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.CORPS).count());
        assertEquals(8, deck.stream().filter(a -> a.type == CardType.FIELD_ARMY).count());
    }

    public Game setUpTwoPlayerGame(){
        Player p1 = new Player("Josh");
        Player p2 = new Player("Luke");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);
        playerList.add(p2);

        Game game = new Game(playerList);
        return game;
    }

    @Test
    public void testDeal(){
        Player p1 = new Player("Josh");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);

        Game game = new Game(playerList);
        game.initialDeal();

        assertEquals((104 - ( playerList.size() * 7 )), game.getDeck().size());
        assertEquals(7, p1.getHandSize());
    }

    @Test
    public void testDealManyPLayers(){
        Game game = setUpTwoPlayerGame();

        game.initialDeal();

        assertEquals((104 - ( game.players.size() * 7 )), game.getDeck().size());
        assertEquals(7, game.players.get(0).getHandSize());
        assertEquals(7, game.players.get(1).getHandSize());
    }

    @Test
    public void testDealCard(){
        Player p1 = new Player("Josh");
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(p1);

        Game game = new Game(playerList);
        assertEquals(104,game.getDeck().size() );

        int initalHandSize = p1.getHandSize();
        game.dealCard();//p1.name );

        assertEquals(initalHandSize + 1, p1.getHandSize());
        assertEquals(103,game.getDeck().size() );
    }

    //next player function






}