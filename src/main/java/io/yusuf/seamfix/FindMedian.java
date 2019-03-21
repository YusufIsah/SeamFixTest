/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.yusuf.seamfix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author hanin
 */
public class FindMedian {
   private PriorityQueue<Integer> minNumber;
   private PriorityQueue<Integer> maxNumber;
 
    /** initialize your data structure here. */
    public FindMedian() {
        minNumber = new PriorityQueue();
        maxNumber = new PriorityQueue(Comparator.reverseOrder());
    }
 //this method add integer value to queue
    public void addNum(int num) {  
        minNumber.offer(num);
        maxNumber.offer(minNumber.poll());
 
        if(minNumber.size()<maxNumber.size()){
            minNumber.offer(maxNumber.poll());
        }     
    }
    //this method return median of a giving data in the queue
    public int getMedian() {
        if(minNumber.size() > maxNumber.size()){
            return maxNumber.peek();
        }else {
            return (minNumber.peek()+maxNumber.peek())/2;
        }

    }
}
