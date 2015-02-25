package com.mentoring.epam.test.lesson71.modules;

import java.util.Scanner;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class Device { //This Superclass responsible for creating object Device

    protected String deviceName;
    protected int devicePower;
    protected String deviceRoom;

    public Device (String deviceName, int devicePower, String deviceRoom){
        this.deviceName = deviceName;
        this.devicePower = devicePower;
        this.deviceRoom = deviceRoom;
    }

    public String getDeviceName (){
        return deviceName;
    }

    public int getDevicePower(){
        return devicePower;
    }

    public String getDeviceRoom(){
        return deviceRoom;
    }

    @Override

    public String toString(){ //Return String  with params of the object (Device)
        return "Device name: \"" + getDeviceName() + "\", " + "Power: \"" + getDevicePower() + "-V\"" + ", Placed in: \"" + getDeviceRoom() + "\"";
    }
}
