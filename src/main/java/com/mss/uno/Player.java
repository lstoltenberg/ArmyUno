package com.mss.uno;

import com.mss.uno.Card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card){
        this.hand.add(card);
    }

    public void addCards(List<Card> cards){
        this.hand.addAll(cards);
    }

}
