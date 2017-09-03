package com.smartpower.cilab.smartpower.Beacon;

/**
 * Created by YuYao on 2017/9/3.
 */

public class NearBeacon {


    private String beaconID;
    private String beaconUUID;

    public NearBeacon(String beaconID, String beaconUUID) {
        this.beaconID = beaconID;
        this.beaconUUID = beaconUUID;
    }

    public String getBeaconID() {
        return beaconID;
    }

    public String getBeaconUUID() {
        return beaconUUID;
    }


}
