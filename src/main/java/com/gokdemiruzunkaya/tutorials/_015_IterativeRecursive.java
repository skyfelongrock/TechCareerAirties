package com.gokdemiruzunkaya.tutorials;

import java.util.Scanner;

public class _015_IterativeRecursive {
    //iterative method
    public static Integer userData() throws GokdemirUzunkayaException {
        Scanner klavye = new Scanner(System.in);
        System.out.println("\nLütfen faktöriyel sayısı giriniz");
        int number = klavye.nextInt();
        if (number < 0) {
            System.out.println("Sıfırdan küçük giremezsiniz");
            throw new GokdemirUzunkayaException("Sıfırdan küçük giremezsiniz");
        } else if (Math.abs(number) == 0 || Math.abs(number) == 1)
            return 1;
        return number;
    }

    public static void facResult(int number) {
        int result = 1;
        for (int i = number; i > 0; i--) {
            result = result * i;
        }
        System.out.println(number + " sayınının  faktöriyel sonucu: " + result);
    }

    //recursive
    public static Integer recursiveMethod(int number) throws GokdemirUzunkayaException {
        if (number < 0)
            throw new GokdemirUzunkayaException("Sıfırdan küçük giremezsiniz");
        if (number == 0 || number == 1)
            return 1;
        return number * recursiveMethod(number - 1);
    }
    // 5 * 4 * 3 * 2 * 1
    public static void resultMain() throws GokdemirUzunkayaException {
        int number = userData();

        //iterative
        //facResult(number);

        //recursive
        int temp = recursiveMethod(number);
        System.out.println(temp);
    }

    public static void main(String[] args) throws GokdemirUzunkayaException {
        while (true) {
            resultMain();
        }
    }
}