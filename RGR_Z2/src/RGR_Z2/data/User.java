/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGR_Z2.data;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author vlado
 */
public class User implements Callable {

    private Bank_account bank;

    public User(Bank_account bank) {
        this.bank = bank;
    }

    @Override
    public String call() throws Exception {
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
                break;
            }
        }
        return Thread.currentThread().getName() + ": " + summa;
    }

}
