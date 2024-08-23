/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

import   java.lang.*;

/**
 *
 * @author hcadavid
 */
public class CountThread implements Runnable {
    public int LowLimit;
    public int UpperLimit;

    public CountThread(int LowLimit, int UpperLimit) {
        this.LowLimit = LowLimit;
        this.UpperLimit = UpperLimit;
    }

    public void run() {
        if(UpperLimit < LowLimit){
            int newA = UpperLimit;
            UpperLimit = LowLimit;
            UpperLimit = newA;
        }
        for (int i = LowLimit + 1; i < UpperLimit; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CountThread(10, 15));
        thread.start();
    }

}
