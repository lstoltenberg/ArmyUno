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

    public Game setUpTwoPlayerGame(){
        Player p1 = new Player("Josh");
        Player p2 = new Player("Luke");
        CircularLinkedList<Player> playerList = new CircularLinkedList<>();
        playerList.add(p1);
        playerList.add(p2);

        Game game = new Game(playerList);
        return game;
    }

    @Test
    public void whenGameIsInstantiated_shouldCreateDeckOfCorrectLength(){
        Player p1 = new Player("Josh");
        CircularLinkedList<Player> playerList = new CircularLinkedList<>();
        playerList.add(p1);
        Game game = new Game(playerList);

        assertEquals(104, game.getDeck().size());
    }

    @Test
    public void whenGameIsInstantiated_deckComposistionIsCorrect(){
        Player p1 = new Player("Josh");
        CircularLinkedList<Player> playerList = new CircularLinkedList<>();
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


    @Test
    public void testDealManyPLayers(){
        Game game = setUpTwoPlayerGame();

        int numCardsDealt = game.players.size() * 7 +1;
        Card expectedDiscard = game.getDeck().get(numCardsDealt -1 );

        game.initialDeal();

        assertEquals((104 - numCardsDealt ), game.getDeck().size());
        assertEquals(7, game.players.getCurrent().getHandSize());
        game.players.next();
        assertEquals(7, game.players.getCurrent().getHandSize());
        assertEquals(1, game.discardPile.size());
        assertEquals(expectedDiscard, game.discardPile.get(0));
    }

    @Test
    public void whenDealCard_shouldDealCardToCurrentPlayer(){
        Game game = setUpTwoPlayerGame();

        assertEquals(104,game.getDeck().size() );

        int initialCurrentPlayerHandSize = game.players.getCurrent().getHandSize();
        game.dealCard();
        List<Player> playerList = game.players.values();

        assertEquals(initialCurrentPlayerHandSize + 1, game.players.getCurrent().getHandSize());
        assertEquals(103,game.getDeck().size() );
        assertEquals(1, playerList.get(0).getHandSize());
        assertEquals(0, playerList.get(1).getHandSize());
    }

    //playcard(card)
    //remove from player hand
    //add to discard pile
    @Test
    public void playCard(){
        Game game = setUpTwoPlayerGame();
        game.initialDeal();

        Card cardToPlay = game.players.getCurrent().getHand().get(0);
        game.playCard(cardToPlay);

        assertFalse(game.players.getCurrent().getHand().contains(cardToPlay));
        assertEquals(cardToPlay, game.discardPile.get(game.discardPile.size()-1));
        assertEquals(2, game.discardPile.size());

    }


    //turn function
    //normal turn:
    //check if forced to draw card
    //if forced to draw card: check if you have +2/+4 in hand - ask if want to place
    //     else draw appropriate card count, skip turn = true
    //check if turn is skipped
    //
    //what do you want to play?
    //

    //for initial testing have +2 be curCard


    //shuffle discard pile into deck function
    //yes we need to preserve discard pile to create new deck with

    //next player function






}