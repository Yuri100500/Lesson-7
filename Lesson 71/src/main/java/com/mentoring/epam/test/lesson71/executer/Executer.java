package com.mentoring.epam.test.lesson71.executer;

import com.mentoring.epam.test.lesson71.exception.ByNameException;
import com.mentoring.epam.test.lesson71.modules.Device;
import com.mentoring.epam.test.lesson71.modules.DeviceRoom;
import com.mentoring.epam.test.lesson71.modules.Utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class Executer  {

    public static void main (String[] args) throws InputMismatchException,IndexOutOfBoundsException{

        boolean enter = true;

        List<Device> deviceList = new ArrayList<Device>(); // Creating arraylist

        deviceList.add(new DeviceRoom("Smartphone", 3, true, "Hall")); //Fill this list by basics objects in the room
        deviceList.add(new DeviceRoom("Oven", 220, true, "Kitchen"));
        deviceList.add(new DeviceRoom("TV", 250, true, "Bedroom"));
        deviceList.add(new DeviceRoom("Light", 100, false, "Hall" ));
        deviceList.add(new DeviceRoom("TV", 210, false, "Bedroom" ));



        while(enter){ // We will use this menu until enter == false

            System.out.println("1 - Add device to the flat\n" +
                               "2 - Find device by name\n" +
                               "3 - Show all  devices in the flat\n" +
                               "4 - Show total power of all devices which are plugged into the network\n" +
                               "5 - Remove device from the flat\n" +
                               "0 - Exit !\n");


            Scanner scanner = new Scanner(System.in);
            byte operation = scanner.nextByte(); // Read  operation

            switch (operation){

                case 0: // Exit from out program
                    enter = false;
                    System.out.println("GoodBye!");
                    break;

                case 1: // Adding device to ArrayList by entering 4th parameters
                    try {
                        System.out.println("Enter device name: ");
                        String deviceName = new Scanner(System.in).nextLine();
                        System.out.println("Enter device power: ");
                        int devicePower = new Scanner(System.in).nextInt();
                        System.out.println("Is device plug in to the network? ");
                        boolean devicePlugIn = new Scanner(System.in).nextBoolean();
                        System.out.println("Enter room: ");
                        String deviceRoom = new Scanner(System.in).nextLine();
                        deviceList.add(new DeviceRoom(deviceName, devicePower, devicePlugIn, deviceRoom)); // Adding to ArrayList
                        System.out.println("Device " +deviceName + "has been successfully added !\n");
                    }catch (InputMismatchException e){ // Validation for input data
                        System.out.println("Incorrect input data !!!" +
                                           "Help: \n" +
                                           "Device name can any.\n" +
                                           "Device power should be numeric.\n" +
                                           "Device plug should be true or false.\n" +
                                           "Device room can be any.\n" +
                                           "Please, try again. \n ");
                    }
                    break;

                case 2: //Finding device by entered name
                    System.out.println("Enter device name: ");
                    String byName = new Scanner(System.in).nextLine();
                    try {
                        Utils.searchByName(deviceList, byName);
                        System.out.println("");
                    }catch (ByNameException e){
                        System.out.println(e.getMsg() + "\n"); //Custom Exception
                    }
                break;

                case 3: //Displayed all devices in the ArrayList
                    int position = 0;
                  for (Device allPluggedDevices : deviceList){
                      System.out.println(allPluggedDevices + " and has position " + position + "\n");
                      position++;
                  }
                   break;

                case 4: // Summ total power of plugged devices
                    System.out.println("Summary power: " + Utils.summPower(deviceList) + " V\n");
                    break;

                case 5: //Removing elements by index
                    try {
                        System.out.println("Enter position which you want to remove: ");
                        int posToRemove = new Scanner(System.in).nextInt();
                        System.out.println("");
                        deviceList.remove(posToRemove);
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("The current element does not exist, please, try again !\n");
                    }
                    break;
                default: //  for other input variants
                    System.out.println("The current operation is absent!\n");
            }
        }
    }
}
