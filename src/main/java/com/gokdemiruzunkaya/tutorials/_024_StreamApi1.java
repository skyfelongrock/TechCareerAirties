package com.gokdemiruzunkaya.tutorials;

//Stream
/*
filter  => filtrelemek
forEach => döngü
map     => her bir elemana uğramak
distinct=> tekrar eden verileri göstermez.
sorted  => sıralama
limit   => limitleme
count   => sayma
*/

import java.util.*;
import java.util.stream.Collectors;

public class _024_StreamApi1 {

    //Array
    public static String[] strArray() {
        String[] arrayData = {"ankara", "malatya", "istanbul", "eskişehir", "sivas", "malatya", "elazığ", "malatya"};
        return arrayData;
    }

    //Collection
    public static List<String> collectionListData() {
        List<String> strList = new ArrayList<>();
        strList.add("ankara");
        strList.add("malatya");
        strList.add("istanbul");
        strList.add("eskişehir");
        strList.add("sivas");
        strList.add("malatya");
        strList.add("elazığ");
        strList.add("malatya");
        return strList;
    }

    //Array'ı => Liste çevir
    public static List<String> arrayToList() {
        return  List.of(strArray());
    }

    public static void streamForEachMethod(){
        //List<String> list= collectionListData();
        List<String> list= arrayToList();
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println("\n*******************");
        //forEach
        /*System.out.println("\n*******************");
        list.stream().forEach(System.out::println);
        System.out.println("\n*******************");
        //method referances
        list.forEach(System.out::println);*/

        //forEach Lambda Expression
        list.forEach( (temp)->{
            System.out.print(temp.toUpperCase().substring(0,3)+" ");
        });
    }

    public static void streamSortedSmallToLargeMethod(){
        List<String> list=collectionListData().stream().sorted().collect(Collectors.toList());
        list.forEach((temp)->{
            System.out.print(temp+" ");
        });
    }

    public static void streamSortedLargeToSmallMethod(){
        collectionListData()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach((temp)->{
                    System.out.print(temp+" ");
                });
    }

    public static void streamLimitMethod(){
        collectionListData()
                .stream()
                .sorted()
                .limit(5)
                .collect(Collectors.toList())
                .forEach((temp)->{
                    System.out.print(temp+" ");
                });
    }

    public static void streamDistinctMethod(){
        collectionListData()
                .stream()
                .sorted()
                .distinct()
                .limit(3)
                .collect(Collectors.toList())
                .forEach((temp)->{
            System.out.print(temp.toUpperCase()+" ("+temp.length()+") ");
        });
    }

    public static void streamCountMethod(){
        long counter=collectionListData()
                .stream()
                .sorted()
                .count();
        System.out.println(counter);
    }

    //listeyi küçükten büyüğe doğru sıralayalım
    //bu listede malatya geçmeyen verileri ekranda gösterin
    public static void streamFilterMethod(){
        String city ="malatya";
        collectionListData()
                .stream()
                .sorted()
                .filter((temp)->!city.equalsIgnoreCase(temp))
                .collect(Collectors.toList())
                .forEach((temp)->{
                    System.out.print(temp+" ");
                });
    }

    // random 1-10 arasında 8 tane sayı olsun ve bu sayılardan çift olanları listeleyelim?

    /* public static void collectionListIntData(){
        Random random = new Random();
        int[] arr = new int[8];
        for (int i =0; i <arr.length; i++){
            arr[i] = random.nextInt(1,10);
            System.out.print(arr[i]+" ");
        }
    } */

    //her bir data verisini bir arttıralım
    public static void streamMapMethod(){
        collectionListData()
                .stream()
                //.map((temp)-> temp+1)
                .collect(Collectors.toList())
                .forEach((temp)->{
                    System.out.print(temp+" ");
                });
    }

    public static void streamMethodReferances() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L,"username1","surname1",11));
        studentList.add(new Student(2L,"username2","surname2",22));
        studentList.add(new Student(3L,"username3","surname3",33));
        studentList.add(new Student(4L,"username4","surname4",44));
        studentList.stream().forEach(Student::numberMethod);
    }

    //PSVM
    public static void main(String[] args) {
        //streamForEachMethod();
        //streamSortedSmallToLargeMethod();
        //streamSortedLargeToSmallMethod();
        //streamLimitMethod();
        //streamDistinctMethod();
        //streamCountMethod();
        //streamFilterMethod();
        //streamMapMethod();
        //streamMethodReferances();

    }
}
