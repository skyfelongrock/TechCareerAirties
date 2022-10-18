package com.gokdemiruzunkaya.oop;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
public class StudentDto1 implements Serializable {
    public static final long serialVersionUID= -8904626608843569087L;

    private String nameX;
    private String surname;

    public StudentDto1(String nameX) {
        this.nameX = nameX;
    }

    public StudentDto1(String nameX, String surname) {
        this.nameX = nameX;
        this.surname = surname;
    }
}
