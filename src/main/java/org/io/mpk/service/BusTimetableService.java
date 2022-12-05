package org.io.mpk.service;

import org.io.mpk.model.BusLine;
import org.io.mpk.model.BusStop;
import org.io.mpk.model.BusTimetable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BusTimetableService {

    private List<BusTimetable> busTimetableDB = new ArrayList<>();

    public BusTimetableService() {
    }

    public BusTimetable getBusTimetableByBusLine(Long busLineNUmber){
        return busTimetableDB.stream()
                .filter(t -> t.getBusLine().getLineNumber().equals(busLineNUmber))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public BusTimetable getBusTimetableByBusStop(Long busStopId){
        return busTimetableDB.stream()
                .filter(t -> t.getBusStop().getId().equals(busStopId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }


}
