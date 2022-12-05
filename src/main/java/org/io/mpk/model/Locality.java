package org.io.mpk.model;

public class Locality {

    private Long id;
    private String localityName;

    public Locality() {
    }

    public Locality(Long id, String localityName) {
        this.id = id;
        this.localityName = localityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }
}
