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

    public static void main(String[] args) {
        
        Main m =new Main();
        
        new Thread(m, "User1").start();
        new Thread(m, "User2").start();
        new Thread(m, "User3").start();

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
                System.out.println("Bank: "+bank.getBalans());
                break;
            }
        }
    }
}
