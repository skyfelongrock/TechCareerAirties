package com.gokdemiruzunkaya.tutorials;

public enum _014_Enum {
    SMALL,MEDIUM,LARGE
}

enum permission {
    ADMIN,WRITER,USER
}

class Deneme{
    public static void main(String[] args) {
        System.out.println(_014_Enum.MEDIUM);
        System.out.println(_014_Enum.MEDIUM.toString());
        System.out.println(_014_Enum.MEDIUM.ordinal());
    }
}