package com.gokdemiruzunkaya.tutorials;
//hesap makinesi
//kullanıcıdan aldığın bir sayı negatig mi pozitif mi hesaplayan algoritma
//kullanıcıdan aldığın bir yapının harf mi, sayı mı, özel karaktermi?(Character.isLetter, CharacterisDigit)

//Vize Final
// Vize Final Ödevi
// kullanıcıdan alınan vize ve final notuna göre geçme(ortalama) Algoritması
// eğer kullanıcı vize veya final 0(sıfır) bir değer girerse sistemden atsın
// ekranda "Sifir disiplin hatasi Sistemden cikiliyor
// bunun haricinde sürekli vize final sorsun
// Not Harfleri ==> AA BA BB FF
// not ortalaması: ortalama<50 altında ise kaldı FF
// not ortalaması: ortalama==50 Geçti
// not ortalaması: 55<=x<=69 BB
// not ortalaması: 70<=x<=84 BA
// not ortalaması: 85<=x<=100 AA
// Vize:40% Final:60%
// Dikkat: Consolda virgül kullanmalısın.
// while sonsuz döngü   ==> while(true) {}
// for sonsuz döngü     ==> for(;;) {}

//String tersten yazdıran algoritma java =< avaj
//Kullanıcı tarafında belirtilen sayıya kadar fibonacci sayısını bulan algoritma

//Dizi
//Bir dizide 1-10 arasında rastgele sayılar oluştursun ve bu sayılardan tekrar eden sayılardan kaç tane olduğunu ve tekrarsız veriler algoritma yazalım ?

import java.util.Scanner;

public class _000_Examples {
    public static void main(String[] args) {
        //hesap makinesi

        double sayi1;
        double sayi2;
        String islem;

        Scanner input=new Scanner(System.in);
        System.out.println("lütfen ilk sayiyi giriniz");
        sayi1=input.nextDouble();

        System.out.println("lütfen ikinci sayiyi giriniz");
        sayi2=input.nextDouble();

        System.out.println("lütfen yapmak istediğiniz işlemi giriniz");
        Scanner is = new Scanner(System.in);
        islem = is.next();

        if (islem.equals("+")){
            System.out.println("yanıtınız: " + (sayi1+sayi2));
        }
        if (islem.equals("-")){
            System.out.println("yanıtınız: " + (sayi1-sayi2));
        }
        if (islem.equals("/")){
            System.out.println("yanıtınız: " + (sayi1/sayi2));
        }
        if (islem.equals("*")){
            System.out.println("yanıtınız: " + (sayi1*sayi2));
        }

    }
}
