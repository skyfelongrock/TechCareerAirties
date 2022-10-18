package com.gokdemiruzunkaya.oop.extendsx;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private String name;
    private String surname;

    public void personFullName(){
        System.out.println(name+" "+surname);
    }
}
