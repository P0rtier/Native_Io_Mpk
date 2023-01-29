package org.io.mpk.service;

import org.io.mpk.model.Allocation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AllocationService {

    private List<Allocation> allocationDB = new ArrayList<>();

    public AllocationService() {
    }

    public AllocationService(List<Allocation> allocationDB) {
        this.allocationDB = allocationDB;
    }

    public void saveAllocation(Allocation allocationDTS){
        allocationDB.add(allocationDTS);
    }

    public Long  getBusLineOccupancy(Long busLineId){
        return allocationDB.stream()
                .filter( t -> t.getBusLine().getLineNumber().equals(busLineId))
                .count();
    }

    public String getAssignedShortInfo(String driverName){
        return allocationDB.stream()
                .filter( t -> t.getDriver().getName().equals(driverName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .getShortAllocationInfo();
    }

    public Allocation getAllocation(String driverName, String busRegistrationPlate, Long busLineNumber){
        return allocationDB.stream()
                .filter( t ->
                        t.getDriver().getName().equals(driverName) && t.getBus().getRegistrationPlate().equals(busRegistrationPlate)
                        && t.getBusLine().getLineNumber().equals(busLineNumber)
                )
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Long countBusAssignements(String busRegistrationPlate) {
        return allocationDB.stream()
                .filter(t -> t.getBus().getRegistrationPlate().equals(busRegistrationPlate))
                .count();
    }

    public Long countDriverAssignements(String driverName) {
        return allocationDB.stream()
                .filter(t -> t.getDriver().getName().equals(driverName))
                .count();
    }
}
