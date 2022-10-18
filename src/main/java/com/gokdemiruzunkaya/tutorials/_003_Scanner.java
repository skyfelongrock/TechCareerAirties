package com.gokdemiruzunkaya.tutorials;

import javax.swing.*;
import java.util.Scanner;

public class _003_Scanner {
    public static void main(String[] args) {
        Scanner klavye=new Scanner(System.in);
        System.out.println("lütfen bir şeyler giriniz");
        String data1=klavye.nextLine();
        System.out.println(data1);
        String data2= JOptionPane.showInputDialog("Lütfen bir şey yazınız");
        System.out.println(data2);
    }
}
