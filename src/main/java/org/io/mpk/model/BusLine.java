package org.io.mpk.model;

import java.util.List;

public class BusLine {

    private Long lineNumber;

    private Integer maxDriverAmount;

    public BusLine() {
    }

    public BusLine(Long id, Integer maxDriverAmount) {
        this.lineNumber = id;
        this.maxDriverAmount = maxDriverAmount;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getMaxDriverAmount() {
        return maxDriverAmount;
    }

    public void setMaxDriverAmount(Integer maxDriverAmount) {
        this.maxDriverAmount = maxDriverAmount;
    }
}
