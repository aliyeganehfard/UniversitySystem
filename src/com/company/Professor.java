package com.company;

import java.time.LocalDate;

public class Professor extends Person{
    private String professorCode;
    private STATUS status ;

    public Professor(String firstName, String lastName, String nationalCode,
                     String birthDate,  String status) {

        super(firstName, lastName, nationalCode, birthDate);
        this.status = STATUS.valueOf(status.toUpperCase());
        this.professorCode = String.valueOf(RandomNumber.getRandomNumber());
    }

    public STATUS getStatus() {
        return status;
    }

    public String getProfessorCode() {
        return professorCode;
    }

    @Override
    public String toString() {
        return  super.toString() +
                " , professorCode=" + professorCode +
                ", status=" + status +
                '}';
    }

}
