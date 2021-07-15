package com.mss.uno;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList<E>

{
    //variables to make linked list work:
    private boolean nextRight;
    private BdLLNode<E> current;
    private int count;

    //constructors
    public CircularLinkedList() {
        this.nextRight = true;
        this.current = null;
        this.count = 0;
    }

    //special functions
    public int size() {
        return this.count;
    }

    public boolean changeDirection() {
        this.nextRight = !this.nextRight;
        return true;
    }

    public boolean next(){
        if(nextRight){
            current = current.right;
        }
        else{
            current = current.left;
        }
        return true;
    }


    //Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
    public boolean add(E e) {
        if (this.count == 0) {
            this.current = new BdLLNode<E>(e, null, null);
            this.count++;
            return true;
        }
        if (this.count == 1) {
            BdLLNode<E> temp = new BdLLNode<E>(e, this.current, this.current);
            this.current.left = temp;
            this.current.right = temp;
            this.count++;
            return true;
        }
        if (this.count > 1) {
            BdLLNode<E> temp = new BdLLNode<E>(e, null, null);
            if (nextRight) { //adds to left, direction of travel is right
                temp.right = current;
                temp.left = current.left;
                current.left.right = temp;
                current.left = temp;
            } else { //adds to right, direction of travel is left
                temp.left = current;
                temp.right = current.right;
                current.right.left = temp;
                current.right = temp;
            }
            this.count++;
            return true;
        }
        return false; //negative number count
    }


//    Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    public E getCurrent() {
        if(count < 1){return null;}
        return current.data;
    }


    //Retrieves and removes the head of this queue.
    public E removeCurrent() {
        if(count==0){
            return null;
        }
        if(count==1){
            E temp = current.data;
            current = null;
            count --;
            return temp;
        }
        if(count > 1){
            E temp = current.data;
            //leftsy-rightsy
            current.right.left = current.left;
            current.left.right = current.right;
            //set new current
            if(nextRight){
                current = current.right;
            }
            else{
                current = current.left;
            }
            count --;
            return temp;
        }
        return null; //negative number count
    }


    public List<E> values(){
        List<E> list = new ArrayList<>();
        for(int position = 0; position < count; position++){
            list.add(current.data);
            this.next();
        }

        return list;
    }

}


class BdLLNode<E> {
    public E data;
    public BdLLNode<E> left;
    public BdLLNode<E> right;

    public BdLLNode(E data, BdLLNode<E> left, BdLLNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
