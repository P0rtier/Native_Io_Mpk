package org.io.mpk.model;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringJoiner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Employee {

    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String pesel;

    public Employee() {
    }

    public Employee(Long id, String name, String surname, LocalDate birthDate, LocalDate hireDate, String pesel) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.pesel = pesel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    //Get time worked based on hire_date

    public long getDaysWorked(LocalDate dateToParse){
        long daysBetweeen = DAYS.between(hireDate, dateToParse);
        if(daysBetweeen < 0){
            throw new IllegalArgumentException();
        }else{
            return daysBetweeen;
        }
    }
    public String getFullNameOfEmployee(){
        return "" + name + " " + surname;
    }
}
