package org.io.mpk.service;

import org.io.mpk.model.BusLine;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BusLineService {

    private List<BusLine> busLineDB = new ArrayList<>();

    public BusLineService() {
    }

    public BusLine getBusLineByLineNumber(Long lineNumber){
        return busLineDB.stream()
                .filter(t -> t.getLineNumber().equals(lineNumber))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
