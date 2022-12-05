package org.io.mpk.model;

import java.time.LocalTime;

public class BusTimetable {

    private Long id;
    private BusLine busLine;
    private BusStop busStop;
    private LocalTime time;

    public BusTimetable() {
    }

    public BusTimetable(Long id, BusLine busLine, BusStop busStop, LocalTime time) {
        this.id = id;
        this.busLine = busLine;
        this.busStop = busStop;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusLine getBusLine() {
        return busLine;
    }

    public void setBusLine(BusLine busLine) {
        this.busLine = busLine;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
