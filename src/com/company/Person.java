package com.company;

import java.time.LocalDate;

public class Person {
    private String firstName ;
    private String lastName ;
    private String nationalCode;
    private LocalDate birthDate;

    public Person(){}

    public Person(String firstName, String lastName, String nationalCode, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthDate=" + birthDate ;
    }
}
