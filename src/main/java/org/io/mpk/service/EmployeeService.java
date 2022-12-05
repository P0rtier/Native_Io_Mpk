package org.io.mpk.service;

import org.io.mpk.model.Driver;
import org.io.mpk.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeService {

    private List<Employee> employeeDB = new ArrayList<>();

    public EmployeeService() {
    }

    public Employee getDriverById(Long driverId){
        return employeeDB.stream()
                .filter( t -> t instanceof Driver && t.getId().equals(driverId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Employee getDriverByName(String name){
        return employeeDB.stream()
                .filter(t -> t instanceof Driver && t.getName().equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Employee getDriverBySurname(String surname){
        return employeeDB.stream()
                .filter(t -> t instanceof Driver && t.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Employee getDriverByDrivingLicenseId(Long drivingLicenseId){
        return employeeDB.stream()
                .filter(t ->
                    t instanceof Driver
                            && ((Driver) t).getDrivingLicenseId().equals(drivingLicenseId)
                )
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
