package com.mss.uno;

import com.mss.uno.Card.Card;

import java.util.List;

public class Game {
    List<Player> players;
    List<Card> deck;
    List<Card> discardPile;
    Card curCard;
    String curPlayerId;

    public Game(List<Player> players, List<Card> deck) {
        this.players = players;
        this.deck = deck;
    }

    public void initialDeal() {

        int index = this.deck.size();

        for(Player p : players){
            p.addCards(deck.subList(index-7,index));
            deck.removeAll((deck.subList(index-7,index)));
            index -= 7;
        }

//        for(int i = this.deck.size()-1; i >= 0; i--){
//            players.get(0).addCard(deck.get(i));
//            deck.remove(i);
//        }
    }
}
