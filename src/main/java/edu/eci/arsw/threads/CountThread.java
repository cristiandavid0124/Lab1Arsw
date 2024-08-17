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
    public int A;
    public int B;

    public CountThread(int A, int B) {
        this.A = A;
        this.B = B;
    }

    public void run() {
        if(B < A){
            int newA = B;
            B = A;
            A = newA;
        }
        for (int i = A + 1; i < B; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new CountThread(10, 15));
        thread.start();
    }

}
