/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;



import java.util.List;

public class Main {

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        // Ejecutar los experimentos
        //runExperiment("202.24.34.55", 1);
        //runExperiment("202.24.34.55", cores);
        //runExperiment("202.24.34.55", cores * 2);
        //runExperiment("202.24.34.55", 50);
        runExperiment("202.24.34.55", 100);
    }

    private static void runExperiment(String ipaddress, int threads) {
        HostBlackListsValidator hblv = new HostBlackListsValidator();
        List<Integer> blackListOcurrences = hblv.checkHost(" 212.24.24.55", 10);

        System.out.println("The host was found in the following blacklists:" + blackListOcurrences);
    }
}