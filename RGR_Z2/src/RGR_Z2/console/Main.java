/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGR_Z2.console;

import RGR_Z2.data.Bank_account;
import RGR_Z2.data.User;
import java.util.Random;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author vlado
 */
public class Main {

    public static void main(String[] args) {

        Bank_account bank = new Bank_account();

        //Получить ExecutorService из служебного класса Executors
        //размер пула потоков равен 3
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //создать список для хранения объекта Future, связанного с Callable
        List<Future> list = new ArrayList<>();
        //Create User instance
        Callable users = new User(bank);
        for (int i = 0; i < 3; i++) {
            Future future = executor.submit(users);
            //добавив Future в список, мы можем получить возвращаемое значение
            list.add(future);
        }
        for (Future fut : list) {
            try {
// выводим возвращаемое значение Future, замечаем задержку вывода в консоли
// потому что Future.get() ожидает завершения задачи
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        //закрыть службу
        executor.shutdown();

        System.out.println("Bank: " + bank.getBalans());

    }

}
