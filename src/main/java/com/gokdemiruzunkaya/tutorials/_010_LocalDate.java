package com.gokdemiruzunkaya.tutorials;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class _010_LocalDate {
    public static void main(String[] args) {
        //1900 ekle veya çıkar
        Date date=new Date();
        System.out.println(date);
        System.out.println(date.getDate());
        System.out.println(date.getMonth());
        System.out.println(date.getYear()+1900);

        Locale local=new Locale("en", "US");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM-dd-yyyy",local);
        String dateChange=simpleDateFormat.format(date);
        System.out.println(dateChange);

        System.out.println(new Date(System.currentTimeMillis()));
    }
}
