/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGR_Z2.data;

/**
 *
 * @author vlado
 */
public class Bank_account {

    private volatile int balans = 1000;

    public int getBalans() {
        return balans;
    }

    synchronized public boolean withdrawal(int WithSumm) {
        if (balans > 10 && WithSumm < 50 && WithSumm > 10 && balans > WithSumm) {
            balans -= WithSumm;
            return true;
        } else {
            return false;
        }
    }

}
