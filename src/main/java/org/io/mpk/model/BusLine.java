package org.io.mpk.model;

import java.util.List;

public class BusLine {

    private Long lineNumber;

    private List<Driver> driverList;

    private Integer maxDriverAmount;

    public BusLine() {
    }

    public BusLine(Long id, List<Driver> driverList, Integer maxDriverAmount) {
        this.lineNumber = id;
        this.driverList = driverList;
        this.maxDriverAmount = maxDriverAmount;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public Integer getMaxDriverAmount() {
        return maxDriverAmount;
    }

    public void setMaxDriverAmount(Integer maxDriverAmount) {
        this.maxDriverAmount = maxDriverAmount;
    }

    public void addDriverToDriverList(Driver driver){
        if(driver != null)
            driverList.add(driver);
    }
}
