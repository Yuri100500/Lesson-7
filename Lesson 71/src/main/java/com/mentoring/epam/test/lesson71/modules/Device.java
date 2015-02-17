package com.mentoring.epam.test.lesson71.modules;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class Device { //This Superclass responsible for creating object Device

    protected String deviceName;
    protected int devicePower;
    protected boolean devicePlugIn;

    public Device (String deviceName, int devicePower, boolean devicePlugIn){
        this.deviceName = deviceName;
        this.devicePower = devicePower;
        this.devicePlugIn = devicePlugIn;
    }

    public String getDeviceName (){
        return deviceName;
    }

   /* public void setDeviceName(String deviceName){
        this.deviceName = deviceName;
    }*/

    public int getDevicePower(){
        return devicePower;
    }

   /* public void setDevicePower(int devicePower){
        this.devicePower = devicePower;
    }*/

    public boolean getDevicePlugIn(){
        return devicePlugIn;
    }

  /*  public void setDevicePlugIn(boolean devicePlugIn){
        this.devicePlugIn = devicePlugIn;
    }*/


    @Override

    public String toString(){ //Return String  with params of the object (Device)
        return "Device name: \"" +getDeviceName() + "\", " + "Power: \"" + getDevicePower() + "-V\"" + ", Plug: \"" + getDevicePlugIn() + "\"";
    }
}
