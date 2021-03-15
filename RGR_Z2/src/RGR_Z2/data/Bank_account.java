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

    private int invoice_amount;

    public Bank_account(int _invoice_amount) {
        invoice_amount = _invoice_amount;
    }

    public int Withdrawal(int WithSumm) {
        int statys;

        if (WithSumm < 10 || WithSumm > 50) {
            return 1;
        }
        if (invoice_amount < 10) {
            return 2;
        }

        invoice_amount -= WithSumm;
        return 0;
    }

}
