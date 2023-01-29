package org.io.mpk.testyfitnessefixture;

import java.util.IllegalFormatCodePointException;

public class GetDriverShortInfoTest {

    private String driverName;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverShortInfoTest() throws IllegalFormatCodePointException {
        try {
            return SetUp.adminController.getDriverShortInfo(driverName);
        }catch (IllegalFormatCodePointException e){}
        return "";
    }
}
