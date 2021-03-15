/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGR_Z2.console;

import RGR_Z2.data.Bank_account;
import RGR_Z2.data.Potok;

/**
 *
 * @author vlado
 */
public class Main {

    public static void main(String[] args) {
        Bank_account Bank = new Bank_account(1000);

        Potok p1 = new Potok(Bank, "Person1");
        p1.start();
        Potok p2 = new Potok(Bank, "Person2");
        p1.start();
        Potok p3 = new Potok(Bank, "Person3");
        p1.start();

    }
}
