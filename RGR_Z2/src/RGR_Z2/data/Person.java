/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGR_Z2.data;

import java.util.Random;

/**
 *
 * @author vlado
 */
public class Person {

    private final String name;
    private int Snataia_summa;

    public Person(String _name) {
        name = _name;
    }

    public int snatie(Bank_account a) {
        Random random = new Random();
        int summa_snatia = random.nextInt(40) + 10;

        if (a.Withdrawal(summa_snatia) == 0) {
            Snataia_summa += summa_snatia;
            return snatie(a);
        }
        if (a.Withdrawal(summa_snatia) == 1) {
            return snatie(a);
        }
        System.out.println(toString());
        return 0;
    }

    @Override
    public String toString() {
        return name + " " + Snataia_summa;
    }

}
