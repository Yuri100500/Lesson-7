package com.mentoring.epam.test.lesson71.modules;

import com.mentoring.epam.test.lesson71.exception.ByNameException;

import java.util.List;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class Utils {

    public static void searchByAny (List<DeviceRoom> searchValue, String search) throws ByNameException { //Searching device by entered String
        int count = 0;
        for (DeviceRoom devices : searchValue){
            if (search.equals(devices.getDeviceName()) || search.equals(devices.getDeviceRoom())|| search.equals(devices.getDevicePlugIn())){
                System.out.println(devices.toString());
                count++;
               }
        }
        if(count == 0){  // If ArrayList is empty throw ByName exception
            throw new ByNameException(search);
        }
    }

    public static int summPower(List<DeviceRoom> listOfDevices){ // Count total power of plugged devices (Only for devices where devicePlugIn == true)

        int powerSumm = 0;

        for (DeviceRoom deviceRoom : listOfDevices){
            if(deviceRoom.getDevicePlugIn().equalsIgnoreCase("Y") ){
                powerSumm = powerSumm + deviceRoom.getDevicePower();
            }
        }return powerSumm;
    }

}