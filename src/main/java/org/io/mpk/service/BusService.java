package org.io.mpk.service;

import org.io.mpk.model.Bus;
import org.io.mpk.model.Driver;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BusService {

    private List<Bus> busDB =  new ArrayList<>();

    public BusService() {
    }

    public BusService(List<Bus> busDB) {
        this.busDB = busDB;
    }

    public Bus getBusById(Long busId){
        return busDB.stream()
                .filter(t -> t.getId().equals(busId))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Bus getBusByRegistrationPlate(String registrationPlate){
        return busDB.stream()
                .filter(t -> t.getRegistrationPlate().equals(registrationPlate))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public Bus getBusByVinNumber(String busVinNumber){
        return busDB.stream()
                .filter(t -> t.getVinNumber().equals(busVinNumber))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
