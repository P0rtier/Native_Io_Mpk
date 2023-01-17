package org.io.mpk.controller;

import org.io.mpk.model.BusLine;
import org.io.mpk.model.BusStop;
import org.io.mpk.model.BusTimetable;
import org.io.mpk.service.BusLineService;
import org.io.mpk.service.BusStopService;
import org.io.mpk.service.BusTimetableService;

public class BusTimetableController {

    private final BusStopService busStopService;
    private final BusLineService busLineService;

    private final BusTimetableService busTimetableService;

    public BusTimetableController(BusStopService busStopService, BusLineService busLineService, BusTimetableService busTimetableService) {
        this.busStopService = busStopService;
        this.busLineService = busLineService;
        this.busTimetableService = busTimetableService;

    }

    public BusTimetable getBusTimetableByBusLine(Long busLineNumber){
        BusLine busLineSearched = busLineService.getBusLineByLineNumber(busLineNumber);
        if (busLineSearched == null)
            return null;
        Long busLineFoundId = busLineSearched.getLineNumber();
        return busTimetableService.getBusTimetableByBusLine(busLineFoundId);
    }

    public BusTimetable getBusTimetableByBusStopId(Long busStopId){
        BusStop busStopSearched = busStopService.getBusStopById(busStopId);
        if (busStopSearched == null)
            return null;
        return busTimetableService.getBusTimetableByBusStop(busStopSearched.getId());
    }

    public BusTimetable getBusTimetableByBusStopName(String busStopName){
        BusStop busStopSearched = busStopService.getBusStopByName(busStopName);
        if (busStopSearched == null)
            return null;
        return busTimetableService.getBusTimetableByBusStop(busStopSearched.getId());
    }

}
