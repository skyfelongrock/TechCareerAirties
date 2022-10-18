package com.gokdemiruzunkaya.oop.abstractx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract public class Person {
    private String name;
    private String surname;

    abstract  public void govdesizMetod();

    public void personFullName(){
        System.out.println(name+" "+surname);
    }
}
