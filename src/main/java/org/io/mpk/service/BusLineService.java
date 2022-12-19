package org.io.mpk.service;

import org.io.mpk.model.BusLine;
import org.io.mpk.model.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BusLineService {

    private List<BusLine> busLineDB = new ArrayList<>();

    public BusLineService() {
    }

    /**
     * Konstruktor tylko w celach testowych
     */
    public BusLineService(List<BusLine> busLineDB) {
        this.busLineDB = busLineDB;
    }

    public BusLine getBusLineByLineNumber(Long lineNumber){
        return busLineDB.stream()
                .filter(t -> t.getLineNumber().equals(lineNumber))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
