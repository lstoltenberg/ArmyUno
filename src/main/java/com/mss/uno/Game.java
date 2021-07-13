package com.mss.uno;

import com.mss.uno.Card.Card;
import com.mss.uno.Card.CardColor;
import com.mss.uno.Card.CardType;

import java.util.*;

public class Game {
    List<Player> players;
    List<Card> deck;
    List<Card> discardPile;
    Card curCard;
    int curPlayerIndex;


    public Game(List<Player> players) {
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

    }

    public void initialDeal() {
        int index = this.deck.size();

        for(Player p : players){
            p.addCards(deck.subList(index-7,index));
            deck.removeAll((deck.subList(index-7,index)));
            index -= 7;
        }
    }

    public List<Card> getDeck(){return this.deck;}

    public void dealCard(){//String name) {
//        for(Player p : players){
//            if( p.name.equals( name ) ){
//                p.addCard(deck.remove(0));
//            }
//        }

        //this.players(this.curPlayerIndex).addCard(this.deck.remove(0));
    }

}
