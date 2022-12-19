package org.io.mpk.service;

import org.io.mpk.model.BusStop;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BusStopService {

    private List<BusStop> busStopDB = new ArrayList<>();

    public BusStopService() {
    }

    /**
     * Konstruktor tylko w celach testowych
     */
    public BusStopService(List<BusStop> busStopDB) {
        this.busStopDB = busStopDB;
    }

    public BusStop getBusStopById(Long busStopId){
        return busStopDB.stream()
                .filter(t -> t.getId().equals(busStopId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public BusStop getBusStopByName(String busStopName){
        return busStopDB.stream()
                .filter(t -> t.getBusStopName().equals(busStopName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
