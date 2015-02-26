package com.mentoring.epam.test.lesson71.executer;

import com.mentoring.epam.test.lesson71.exception.ByNameException;
import com.mentoring.epam.test.lesson71.modules.Device;
import com.mentoring.epam.test.lesson71.modules.DeviceRoom;
import com.mentoring.epam.test.lesson71.modules.Utils;

import java.util.*;

/**
 * Created by Iurii_Galias on 1/27/15.
 */
public class Executer  {

    public static void main (String[] args) throws InputMismatchException,IndexOutOfBoundsException{

        boolean enter = true;

        List<DeviceRoom> deviceList = new ArrayList<DeviceRoom>(); // Creating arraylist
        Map<String,Object> criteriaMap = new HashMap<String, Object>();

        deviceList.add(new DeviceRoom("Smartphone", 3, "Hall", "Y")); //Fill this list by basics objects in the room
        deviceList.add(new DeviceRoom("Oven", 220, "Kitchen", "Y"));
        deviceList.add(new DeviceRoom("TV", 250, "Bedroom", "Y"));
        deviceList.add(new DeviceRoom("Light", 100, "Hall", "N" ));
        deviceList.add(new DeviceRoom("TV", 210, "Bedroom", "N" ));

        criteriaMap.put(Utils.NAME,null);
        criteriaMap.put(Utils.POWER,null);
        criteriaMap.put(Utils.PLUG,null);
        criteriaMap.put(Utils.ROOM,null);

        while(enter){ // We will use this menu until enter == false

            System.out.println("1 - Add device to the flat\n" +
                               "2 - Find device by any parameter\n" +
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
                        boolean isCorrect = true;
                        System.out.println("Enter device name (String required): ");
                        String deviceName = new Scanner(System.in).nextLine();
                        System.out.println("Enter device power (Integer required): ");
                        int devicePower = new Scanner(System.in).nextInt();
                        while(isCorrect) {
                            if (devicePower > 0 )
                            {
                                isCorrect = false;
                            }
                            else {
                                System.out.println("Please enter Power > 0");
                                devicePower = new Scanner(System.in).nextInt();
                            }
                        }
                        System.out.println("Enter room (String required): ");
                        String deviceRoom = new Scanner(System.in).nextLine();
                        System.out.println("Is device plug in to the network?(\"Y\" or \"N\") ");
                        String devicePlugIn = new Scanner(System.in).nextLine().toUpperCase().substring(0,1);
                        isCorrect = true;
                        while(isCorrect) {
                            if ("Y".equalsIgnoreCase(devicePlugIn) || "N".equalsIgnoreCase(devicePlugIn))
                            {
                                isCorrect = false;
                            }
                            else {
                                System.out.println("Please enter Y or N");
                                devicePlugIn = new Scanner(System.in).nextLine().toUpperCase().substring(0,1);
                            }
                        }
                        deviceList.add(new DeviceRoom(deviceName, devicePower, deviceRoom, devicePlugIn)); // Adding to ArrayList
                        System.out.println("Device " +deviceName + "has been successfully added !\n");
                    }catch (InputMismatchException e){ // Validation for input data
                        System.out.println("Incorrect input data !!!");
                    }
                    break;

                case 2: //Finding device by entered name
                    boolean entered = true, isCorrect = true;
                        System.out.println("Enter Power:");
                        int devicePower = new Scanner(System.in).nextInt();
                        criteriaMap.put(Utils.POWER,devicePower);
                        System.out.println("Do you want to add another parameter (Name, Room, or Plugging flag)?");
                        String flag = new Scanner(System.in).nextLine().toUpperCase();
                        while(isCorrect) {
                            if ("Y".equalsIgnoreCase(flag))
                            {
                                isCorrect = false;
                            }
                            else if("N".equalsIgnoreCase(flag)) {
                                isCorrect = false;
                                entered = false;
                            }else {
                                System.out.println("Please enter Y or N");
                                flag = new Scanner(System.in).nextLine().toUpperCase().substring(0,1);
                            }
                            while (entered){
                                String deviceName = null, deviceRoom = null, devicePlug = null;
                                System.out.println("Enter another parameter (\"1 - Name\", \"2 - Room\", or \"3 - Plug in\", 4 - Starting search with  selected criteria)");
                                int criteria = new Scanner(System.in).nextInt();
                                /*if (deviceName != "" || deviceRoom != "" || devicePlug != ""){
                                    System.out.println("This parameter was initialized before, please choose another criteria");
                                }*/
                                switch (criteria){
                                    case 1:
                                        if (deviceName !=null){
                                            System.out.println("This parameter was initialized before, please choose another criteria\n");
                                            break;
                                        }
                                        System.out.println("Enter name");
                                        deviceName = new Scanner(System.in).nextLine();
                                        criteriaMap.put(Utils.NAME,deviceName);
                                        break;
                                    case 2:
                                        System.out.println("Enter room");
                                        deviceRoom = new Scanner(System.in).nextLine();
                                        criteriaMap.put(Utils.ROOM,deviceRoom);
                                        break;
                                    case 3:
                                        System.out.println("Enter plug");
                                        devicePlug = new Scanner(System.in).nextLine();
                                        criteriaMap.put(Utils.PLUG,devicePlug);
                                        break;
                                    case 4:
                                        entered = false;
                                        break;
                                }
                            }
                        }
                    for (DeviceRoom result : Utils.advancedSearch(criteriaMap,deviceList)){
                        System.out.println(result);
                    }
                    System.out.println("\n");
                    break;
                case 3: //Displayed all devices in the ArrayList
                    int position = 0;
                  for (Device allPluggedDevices : deviceList){
                      System.out.println(allPluggedDevices + " and has position " + position + "\n");
                      position++;
                  }
                   break;

                case 4:// Summ total power of plugged devices
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
