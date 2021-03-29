/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGR_Z2.console;

import RGR_Z2.data.Bank_account;
import java.util.Random;

/**
 *
 * @author vlado
 */
public class Main implements Runnable {

    Bank_account bank = new Bank_account();

    public Bank_account getBank() {
        return bank;
    }

    public static void main(String[] args) {

        Main m = new Main();

        Thread t1 = new Thread(m, "User1");
        Thread t2 = new Thread(m, "User2");
        Thread t3 = new Thread(m, "User3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Bank: " + m.getBank().getBalans());

    }

    @Override
    public void run() {
        int summa = 0;
        while (true) {
            if (bank.getBalans() > 10) {
                int snatie = new Random().nextInt(40) + 10;
                if (bank.withdrawal(snatie)) {
                    summa += snatie;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }
            } else {
                System.out.println(Thread.currentThread().getName() + ": " + summa);
                break;
            }
        }
    }
}
