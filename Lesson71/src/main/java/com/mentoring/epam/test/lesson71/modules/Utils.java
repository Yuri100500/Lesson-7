package com.mentoring.epam.test.lesson71.modules;

import com.mentoring.epam.test.lesson71.exception.ByNameException;

import java.util.List;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class Utils {

    public static void searchByName (List<Device> searchValue, String byName) throws ByNameException { //Searching device by entered String
        int count = 0;
        for (Device devices : searchValue){
            if (byName.equals(devices.getDeviceName())){
                System.out.println(devices.toString());
                count++;
            }
        }
        if(count == 0){  // If ArrayList is empty throw ByName exception
            throw new ByNameException(byName);
        }
    }

    public static int summPower(List<Device> listOfDevices){ // Count total power of plugged devices (Only for devices where devicePlugIn == true)

        int powerSumm = 0;

        for (Device device : listOfDevices){
            if(device.getDevicePlugIn()){
                powerSumm = powerSumm + device.getDevicePower();
            }
        }return powerSumm;
    }
}