package com.mentoring.epam.test.lesson71.modules;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class DeviceRoom extends Device { //This class extends Divice class and added possibility  to add Room where device is

    private String deviceRoom;

    public DeviceRoom(String deviceName, int devicePower, boolean devicePlugIn, String deviceRoom){
        super(deviceName, devicePower, devicePlugIn); // link  to Superclass
        this.deviceRoom = deviceRoom;
    }

    public String getDeviceRoom(){
        return deviceRoom;
    }

   /* public void setDeviceRoom(String deviceRoom){
        this.deviceRoom = deviceRoom;
    }*/

    @Override
    public String toString(){ //Extends toString method and add device room parameter
        return super.toString() + " Placed in: \"" + getDeviceRoom() + "\"";
    }
}
