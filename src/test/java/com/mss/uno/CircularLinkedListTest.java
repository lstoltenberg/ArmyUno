package com.mss.uno;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CircularLinkedListTest {

    @Test
    void addOneString() {
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";

        assertTrue(myList.add(firstString));
        assertEquals(1, myList.size());
    }

    @Test
    void addOneInt() {
        CircularLinkedList<Integer> myList = new CircularLinkedList<>();
        int firstInt = 1;

        assertTrue(myList.add(firstInt));
        assertEquals(1, myList.size());
    }

    @Test
    void addTwoString() {
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";

        assertTrue(myList.add(firstString));
        assertTrue(myList.add(secondString));
        assertEquals(2, myList.size());
    }

    @Test
    void addManyString() {
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);

        assertTrue(myList.add(thirdString));
        assertTrue(myList.add(fourthString));
        assertEquals(4, myList.size());
    }

    @Test
    void addManyStringReverse() {
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        assertTrue(myList.changeDirection());
        myList.add(firstString);
        myList.add(secondString);

        assertTrue(myList.add(thirdString));
        assertTrue(myList.add(fourthString));
        assertEquals(4, myList.size());
    }

    @Test
    void checkPeak_oneItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";

        assertTrue(myList.add(firstString));
        assertEquals(firstString, myList.getCurrent());
    }

    @Test
    void checkPeak_multiItem_notMoved(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);
        myList.add(thirdString);
        myList.add(fourthString);

        assertEquals(firstString, myList.getCurrent());
    }

    @Test
    void checkNextandPeak_multiItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);
        myList.add(thirdString);
        myList.add(fourthString);

        assertEquals(firstString, myList.getCurrent());
        assertTrue(myList.next());
        assertEquals(secondString, myList.getCurrent());
    }

    @Test
    void checkNextandPeak_reverse_multiItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);
        myList.add(thirdString);
        myList.add(fourthString);

        myList.changeDirection();
        assertEquals(firstString, myList.getCurrent());
        assertTrue(myList.next());
        assertEquals(fourthString, myList.getCurrent());
    }

    @Test
    void checkRemove_oneItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";

        assertTrue(myList.add(firstString));
        assertEquals(firstString, myList.removeCurrent());
        assertEquals(0, myList.size());
    }

    @Test
    void checkRemove_multiItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);
        myList.add(thirdString);
        myList.add(fourthString);

        assertEquals(firstString, myList.removeCurrent());
        assertEquals(3, myList.size());
        assertEquals(secondString, myList.getCurrent());
    }

    @Test
    void checkRemoveAll_multiItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);
        myList.add(thirdString);
        myList.add(fourthString);

        assertEquals(firstString, myList.removeCurrent());
        assertEquals(secondString, myList.removeCurrent());
        assertEquals(thirdString, myList.removeCurrent());
        assertEquals(fourthString, myList.removeCurrent());
        assertEquals(0, myList.size());
    }

    @Test
    void checkRemove_reverse_multiItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);
        myList.add(thirdString);
        myList.add(fourthString);

        myList.changeDirection();
        assertEquals(firstString, myList.removeCurrent());
        assertEquals(3, myList.size());
        assertEquals(fourthString, myList.getCurrent());
    }

    @Test
    void checkRemoveToOneAddTwo_multiItem(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);

        assertEquals(firstString, myList.removeCurrent());
        assertEquals(1, myList.size());
        assertEquals(secondString, myList.getCurrent());
        assertTrue(myList.add(thirdString));
        assertEquals(secondString, myList.getCurrent());
        assertTrue(myList.next());
        assertEquals(thirdString, myList.getCurrent());
        assertTrue(myList.add(fourthString));
        myList.changeDirection();
        myList.next();
        assertEquals(fourthString, myList.getCurrent());


    }

    @Test
    void loopingAction(){
        CircularLinkedList<String> myList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        myList.add(firstString);
        myList.add(secondString);
        myList.add(thirdString);
        myList.add(fourthString);


        assertEquals(firstString, myList.getCurrent());
        myList.next();
        assertEquals(secondString, myList.getCurrent());
        myList.next();
        assertEquals(thirdString, myList.getCurrent());
        myList.next();
        assertEquals(fourthString, myList.getCurrent());
        myList.next();
        assertEquals(firstString, myList.getCurrent());

    }

    @Test
    void returnListOfValues(){
        CircularLinkedList<String> actualList = new CircularLinkedList<>();
        String firstString = "First";
        String secondString = "Second";
        String thirdString = "Third";
        String fourthString = "Four";

        actualList.add(firstString);
        actualList.add(secondString);
        actualList.add(thirdString);
        actualList.add(fourthString);

        List<String> expectedStringList = new ArrayList<>();
        expectedStringList.add(firstString);
        expectedStringList.add(secondString);
        expectedStringList.add(thirdString);
        expectedStringList.add(fourthString);

        assertEquals(firstString, actualList.getCurrent());
        assertEquals(expectedStringList, actualList.values());
        assertEquals(firstString, actualList.getCurrent());

    }

}