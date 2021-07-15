package com.mss.uno;

import com.mss.uno.Card.Card;
import com.mss.uno.Card.CardColor;
import com.mss.uno.Card.CardType;

import java.util.*;

public class Game {
    CircularLinkedList<Player> players;
    List<Card> deck;
    List<Card> discardPile;
    int curPlayerIndex;


    public Game(CircularLinkedList<Player> players) {
        this.players = players;
        curPlayerIndex = 0;
        this.deck = new ArrayList<Card>();
        for(CardType cardType : CardType.values()){
            if(!(cardType == CardType.WILD || cardType == CardType.PLUS_FOUR)){
                //do colors
                for(CardColor cardColor : CardColor.values()) {
                    this.deck.add(new Card(cardType, cardColor));
                    this.deck.add(new Card(cardType, cardColor));
                }
            }else {
                //do wilds
                this.deck.add(new Card(cardType, null));
                this.deck.add(new Card(cardType, null));
                this.deck.add(new Card(cardType, null));
                this.deck.add(new Card(cardType, null));
            }
        }
        this.discardPile = new ArrayList<>();
    }

    public void initialDeal() {

        for(Player p : players.values()){
            p.addCards(deck.subList(0,7));
            deck.removeAll((deck.subList(0,7)));
        }

        this.discardPile.add(this.deck.remove(0));
    }

    public List<Card> getDeck(){return this.deck;}

    public void dealCard(){
        players.getCurrent().addCard(deck.remove(0));
    }

    public void playCard(Card card){
        players.getCurrent().getHand().remove(card);
        this.discardPile.add(card);

    }


}
