package com.mentoring.epam.test.lesson71.modules;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class DeviceRoom extends Device { //This class extends Device class and added possibility  to add Room where device is

    private String devicePlugIn;

    public DeviceRoom(String deviceName, int devicePower, String deviceRoom, String devicePlugIn ){
        super(deviceName, devicePower, deviceRoom); // link  to Superclass
        this.devicePlugIn = devicePlugIn;
    }

    public String getDevicePlugIn(){
        return devicePlugIn;
    }

    @Override
    public String toString(){ //Extends toString method and add device room parameter
        return super.toString() + " Plug: \"" + getDevicePlugIn() + "\"";
    }
}
