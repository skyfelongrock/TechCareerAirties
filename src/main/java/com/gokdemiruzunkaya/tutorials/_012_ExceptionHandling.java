package com.gokdemiruzunkaya.tutorials;

public class _012_ExceptionHandling {
    public static void main(String[] args) throws GokdemirUzunkayaException{
        System.out.println("Merhabalar");

        //throw new ArithmeticException("Burda dur");
        throw new GokdemirUzunkayaException("Burda dur");
    }
}
