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

    public EmployeeService(List<Employee> employeeDB) {
        this.employeeDB = employeeDB;
    }

    public List<Employee> getEmployeeDB() {
        return employeeDB;
    }

    public Driver getDriverById(Long driverId){
        return (Driver) employeeDB.stream()
                .filter( t -> t instanceof Driver && t.getId().equals(driverId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Driver getDriverByName(String name){
        return (Driver) employeeDB.stream()
                .filter(t -> t instanceof Driver && t.getName().equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Driver getDriverBySurname(String surname){
        return (Driver) employeeDB.stream()
                .filter(t -> t instanceof Driver && t.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Driver getDriverByDrivingLicenseId(Long drivingLicenseId){
        return (Driver) employeeDB.stream()
                .filter(t ->
                    t instanceof Driver
                            && ((Driver) t).getDrivingLicenseId().equals(drivingLicenseId)
                )
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public void modifyDriver(Driver driver){
        Driver driverToBeSaved = getDriverById(driver.getId());
        if(driverToBeSaved == null)
            throw new NoSuchElementException();
        int index = employeeDB.indexOf(driverToBeSaved);
        employeeDB.remove(index);
        driverToBeSaved.setName(driver.getName());
        driverToBeSaved.setSurname(driver.getSurname());
        driverToBeSaved.setDrivingLicenseCategory(driver.getDrivingLicenseCategory());
        driverToBeSaved.setDrivingLicenseId(driver.getDrivingLicenseId());
        driverToBeSaved.setBirthDate(driver.getBirthDate());
        driverToBeSaved.setHireDate(driver.getHireDate());
        driverToBeSaved.setPesel(driver.getPesel());

        employeeDB.add(index,driverToBeSaved);
    }

    public void addEmployee(Employee employee){
        if(employee != null) employeeDB.add(employee);
        else throw new IllegalArgumentException();
    }

    public String getDriverShortInfo(String driverName) {
        try {
            Driver driver = getDriverByName(driverName);
            return "ID: " + driver.getId() + ", Name: " + driverName + ", Surname: " + driver.getSurname();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return "No such element!";
    }
}
