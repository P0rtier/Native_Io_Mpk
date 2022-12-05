package org.io.mpk.model;

import java.time.LocalDate;

public class Admin extends Employee{

    private String adminIdentificator;

    public Admin() {
        super();
    }

    public Admin(Long id, String name, String surname, LocalDate birthDate, LocalDate hireDate, String pesel, String adminIdentificator) {
        super(id, name, surname, birthDate, hireDate, pesel);
        this.adminIdentificator = adminIdentificator;
    }

    public String getAdminIdentificator() {
        return adminIdentificator;
    }

    public void setAdminIdentificator(String adminIdentificator) {
        this.adminIdentificator = adminIdentificator;
    }
}
