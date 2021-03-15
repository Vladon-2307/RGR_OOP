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
public class Potok implements Runnable {

    private final Bank_account bank;
    private Thread thread;
    private final String threadName;

    public Potok(Bank_account Bank, String _threadName) {
        bank = Bank;
        threadName = _threadName;
    }

    @Override
    public void run() {
        Person p = new Person(threadName);
        p.snatie(bank);
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
        
    }
}
