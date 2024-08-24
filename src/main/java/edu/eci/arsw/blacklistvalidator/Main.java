/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        //runExperiment("202.24.34.55", 1);
        //runExperiment("202.24.34.55", cores);
        //runExperiment("202.24.34.55", cores * 2);
        //runExperiment("202.24.34.55", 50);
        runExperiment("202.24.34.55", 100);
    }

    private static void runExperiment(String ipaddress, int threads) {
        HostBlackListsValidator hblv = new HostBlackListsValidator();
        long startTime = System.currentTimeMillis();
        List<Integer> blackListOcurrences = hblv.checkHost(ipaddress, threads);
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time with " + threads + " threads: " + (endTime - startTime) + "ms");
        System.out.println("The host was found in the following blacklists:" + blackListOcurrences);
    }
}