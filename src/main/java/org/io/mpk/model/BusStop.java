package org.io.mpk.model;

public class BusStop {

    private Long id;
    private String busStopName;
    private Address address;

    public BusStop() {
    }

    public BusStop(Long id, String busStopName, Address address) {
        this.id = id;
        this.busStopName = busStopName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
