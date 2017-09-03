package com.smartpower.cilab.smartpower.Beacon;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by YuYao on 2017/9/3.
 */

public class BeaconList {
    public static ArrayList<NearBeacon> nearBeacons = new ArrayList<>();
    public static ArrayList<String> nearBeaconsList = new ArrayList<>();
    public static int listCounter = 0;

    public static void showBeaconlist(){
        for(int i = 0; i< nearBeaconsList.size(); i++) {
            Log.e("Beaconlist", listCounter + "showBeaconlist: " + nearBeaconsList.get(i));
        }
        listCounter++;
    }
}