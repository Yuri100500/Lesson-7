package com.mentoring.epam.test.lesson71.modules;

import com.mentoring.epam.test.lesson71.exception.ByNameException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class Utils {
    public static final String NAME ="deviceName", POWER = "devicePower", ROOM = "deviceRoom",PLUG = "devicePlug";


    public static int summPower(List<DeviceRoom> listOfDevices){ // Count total power of plugged devices (Only for devices where devicePlugIn == true)

        int powerSumm = 0;

        for (DeviceRoom deviceRoom : listOfDevices){
            if(deviceRoom.getDevicePlugIn().equalsIgnoreCase("Y") ){
                powerSumm = powerSumm + deviceRoom.getDevicePower();
            }
        }return powerSumm;
    }

    public static ArrayList<DeviceRoom> advancedSearch (Map<String,Object> params, List<DeviceRoom> listOfDevices) throws InputMismatchException{
        ArrayList<DeviceRoom> advancedSearchResultList = new ArrayList<DeviceRoom>();
        Object searchCriteriaDeviceName = params.get(NAME);
        Object searchCriteriaDevicePower =(Integer) params.get(POWER);
        Object searchCriteriaDeviceRoom = params.get(ROOM);
        Object searchCriteriaDevicePlugIn = params.get(PLUG);
        if(searchCriteriaDeviceName != null){
            advancedSearchResultList.addAll(searchByName(listOfDevices, searchCriteriaDeviceName.toString()));
        }
        if(searchCriteriaDevicePower != null){
            advancedSearchResultList.addAll(searchByPower(listOfDevices,(Integer)searchCriteriaDevicePower));
        }
        if(searchCriteriaDeviceRoom != null){
            advancedSearchResultList.addAll(searchByRoom(listOfDevices, searchCriteriaDeviceRoom.toString()));
        }
        if(searchCriteriaDevicePlugIn != null){
            advancedSearchResultList.addAll(searchByPlugIn(listOfDevices, searchCriteriaDevicePlugIn.toString()));
        }return advancedSearchResultList;
    }

    private static ArrayList<DeviceRoom> searchByName(List<DeviceRoom> listOfDevices, String name){
        ArrayList<DeviceRoom> listOfResultsByName = new ArrayList<DeviceRoom>();
        for(DeviceRoom currentDeviceFromListOfDevices : listOfDevices){
            String currentDeviceName = currentDeviceFromListOfDevices.getDeviceName();
            if (currentDeviceName.equals(name)){
                listOfResultsByName.add(currentDeviceFromListOfDevices);
            }
        }return listOfResultsByName;
    }

    private static ArrayList<DeviceRoom> searchByPower(List<DeviceRoom> listOfDevices, int power){
        ArrayList<DeviceRoom> listOfResultsByPower = new ArrayList<DeviceRoom>();
        for(DeviceRoom currentDeviceFromListOfDevices : listOfDevices){
            int currentDevicePower = currentDeviceFromListOfDevices.getDevicePower();
            if (currentDevicePower == power){
                listOfResultsByPower.add(currentDeviceFromListOfDevices);
            }
        }return listOfResultsByPower;
    }

    private static ArrayList<DeviceRoom> searchByRoom(List<DeviceRoom> listOfDevices, String room){
        ArrayList<DeviceRoom> listOfResultsByRoom = new ArrayList<DeviceRoom>();
        for(DeviceRoom currentDeviceFromListOfDevices : listOfDevices){
            String currentDeviceRoom = currentDeviceFromListOfDevices.getDeviceRoom();
            if (currentDeviceRoom.equals(room)){
                listOfResultsByRoom.add(currentDeviceFromListOfDevices);
            }
        }return listOfResultsByRoom;
    }

    private static ArrayList<DeviceRoom> searchByPlugIn(List<DeviceRoom> listOfDevices, String plugIn){
        ArrayList<DeviceRoom> listOfResultsByPlugIn = new ArrayList<DeviceRoom>();
        for(DeviceRoom currentDeviceFromListOfDevices : listOfDevices){
            String currentDevicePlugIn = currentDeviceFromListOfDevices.getDevicePlugIn();
            if (currentDevicePlugIn.equals(plugIn)){
                listOfResultsByPlugIn.add(currentDeviceFromListOfDevices);
            }
        }return listOfResultsByPlugIn;
    }

    public static void clearResultList(ArrayList<DeviceRoom> listOfResult){
        listOfResult.removeAll(listOfResult);
    }

}