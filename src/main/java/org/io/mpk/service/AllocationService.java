package org.io.mpk.service;

import org.io.mpk.model.Allocation;

import java.util.ArrayList;
import java.util.List;

public class AllocationService {

    private List<Allocation> allocationDB = new ArrayList<>();

    public AllocationService() {
    }

    public void saveAllocation(Allocation allocationDTS){
        allocationDB.add(allocationDTS);
    }

    public Long getBusLineOccupancy(Long busLineId){
        return allocationDB.stream()
                .filter( t -> t.getBusLine().getLineNumber().equals(busLineId))
                .count();
    }
}
