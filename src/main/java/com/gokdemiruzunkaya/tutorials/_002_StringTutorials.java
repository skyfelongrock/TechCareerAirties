package com.gokdemiruzunkaya.tutorials;

import java.util.Scanner;

public class _002_StringTutorials {

    public static void main(String[] args) {
        String data="Merhabalar nasılsınız zonguldak";
        System.out.println(data.length());
        System.out.println(data.trim().length());
        System.out.println(data.toLowerCase());
        System.out.println(data.toUpperCase());
        System.out.println(data.startsWith("M"));
        System.out.println(data.startsWith("m"));
        System.out.println(data.endsWith(" "));
        System.out.println(data.charAt(0));
        System.out.println(data.charAt(20));
        System.out.println(data.charAt(data.length()-1));
        System.out.println(data.indexOf("z"));
        System.out.println(data.lastIndexOf("z"));
        System.out.println(data.replace(data, "yeni"));
        System.out.println(data.substring(1));
        if(data.length()>5){
            System.out.println(data.substring(0,5)); //0<=X<=5-1
        }

        System.out.println(data.isEmpty());
        Scanner klavye=new Scanner(System.in);
        System.out.println("lütfen bir şeyler giriniz");
        String data1=klavye.nextLine();
        // String data=klavye.nextLine().charAt(0);
    }

}
