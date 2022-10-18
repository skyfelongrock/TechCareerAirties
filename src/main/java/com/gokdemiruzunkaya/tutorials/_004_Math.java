package com.gokdemiruzunkaya.tutorials;

import java.util.Random;

public class _004_Math {
    public static void main(String[] args) {
        System.out.println(Math.max(2,5));
        System.out.println(Math.floor(Math.random()*4+1));
        Random random=new Random();
        int number=random.nextInt(4)+1;
        System.out.println(number);
    }
}
