/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RGR_Z1.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vlado
 */
public class RGR_Z1 {
    
    public static List<Integer> Spisoc(){
        List<Integer> spisoc = new ArrayList();
        spisoc.add(10);
        spisoc.add(100);
        spisoc.add(-100);
        spisoc.add(111);
        spisoc.add(1221);
        spisoc.add(35);
        spisoc.add(3553);
        spisoc.add(1111);
        spisoc.add(345);
        spisoc.add(23);
        return spisoc;
    }

    public static int Scaner() {
        System.out.println("\n Введите номер меню: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    public static void Menu(){
        System.out.println("Меню \n 1-Найти количество нечётных чисел. \n 2-Найти количество простых чисел."
                + " \n 3-Найти количество чисел-полиндромов. \n");
    }
    
    public static void Count(List<Integer> spisoc, int vid_sortirovki) {
        long rezult;
        if (spisoc == null) {
            System.err.println("Список пуст.");
        } else {
            switch (vid_sortirovki) {
                case 1:
                    rezult = spisoc.stream().filter(s -> s % 2 != 0).count();
                    System.out.println("По вашему запросу найдено "+rezult+" совпадения. \n");
                    break;
                case 2:
                    rezult = spisoc.stream().filter((Integer s) -> {
                        boolean isPrime = true;
                        for (int i = 2; i <= s / 2; i++) {
                            int temp = s % i;
                            if (temp == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        return isPrime;
                    }).count();
                    System.out.println("По вашему запросу найдено "+rezult+" совпадения. \n");
                    break;
                case 3:
                    rezult = spisoc.stream().filter(s -> {
                return Integer.toString(s).equals(new StringBuilder().append(s).reverse().toString());
            }).count();
                    System.out.println("По вашему запросу найдено "+rezult+" совпадения. \n");
                    break;
                default:
                    System.err.println("Таково менью нет выберите другое:");
                    Menu();
                    Count(spisoc, Scaner());
                    break;
            }
        }
    }
}
