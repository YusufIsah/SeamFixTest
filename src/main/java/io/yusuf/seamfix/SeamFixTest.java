/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.yusuf.seamfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hanin
 */
public class SeamFixTest {
    
    public static void main(String... args){
        Scanner scn = new Scanner(System.in);
        FindMedian findMedian = new FindMedian();
        int notificationCount = 0;
       
        System.out.print("Enter an integers as n and d with whitespace seperated  : ");
        int n = scn.nextInt();
         int d = scn.nextInt();
        int[] expenditure = new int[n];
        int i = 0;
        System.out.print("Enter an integers as Expenditure with whitespace seperated : ");
        Scanner InputExpenditure = new Scanner(new Scanner(System.in).nextLine());
        while (InputExpenditure.hasNextInt()) {
            int value = InputExpenditure.nextInt();
            expenditure[i] = value;
            i++;
        }
        System.out.println(">>>>>>> Sample Input <<<<<<<<< ");
        System.out.println("n = " + n +" and d = " + d);
        System.out.println("Expenditure = " + Arrays.toString(expenditure));
         System.out.println("Numbers of Notifications = " + getNumberOfNotificationCount(expenditure, findMedian, notificationCount, n, d));
              

    }
    //this function return total number of notification sent to the user
    private static int getNumberOfNotificationCount(int [] expenditure, FindMedian findMedian, int notificationCount, int n, int d){
         for(int a = 1; a <= n-d; a++){
             int track = 0;
             if(a > 1) track = a-1;
            for(int t = 0; t <= expenditure.length; t++){
                if(t == d) break;
                  findMedian.addNum(expenditure[track]);
                track++;
                
            }
            if(expenditure[d+a-1] >= (2 * findMedian.getMedian())){
                notificationCount++;
            }
        }   
         return notificationCount;
    }
    
}
