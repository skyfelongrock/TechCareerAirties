package com.gokdemiruzunkaya.tutorials;

import java.io.IOException;

public class _011_ExceptionHandling {
    public static void main(String[] args) throws  ArithmeticException, IOException {

        try{
            int number =4/0;
            System.out.println(number);

        }catch (ArithmeticException ai){
            // ai.printStackTrace();
        }finally {
            System.out.println("db.close");
        }

        System.out.println("son satır");
    }
}
