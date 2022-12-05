package org.io.mpk.model;

public class Street {

    private Long id;
    private Locality locality;
    private String streetName;

    public Street() {
    }

    public Street(Long id, Locality locality, String streetName) {
        this.id = id;
        this.locality = locality;
        this.streetName = streetName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
