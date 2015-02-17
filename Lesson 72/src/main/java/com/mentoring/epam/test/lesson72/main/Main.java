package com.mentoring.epam.test.lesson72.main;

import com.mentoring.epam.test.lesson72.modules.Utils;

import java.util.*;

/**
 * Created by Iurii_Galias on 2/16/15.
 */
public class Main {
    public static void main(String args[]){

        boolean entered = true; // We will use this menu until enter == false
        long startTime = 0; // inintializing variable which help me count work time

        while(entered){
            System.out.println("Choose comparing method:\n"+
                               "1 - ArrayList vs LinkedList\n" +
                               "2 - HashSet vs TreeSet\n" +
                               "3 - HashMap vs TreeMap\n" +
                               "4 - Exit");

            Scanner scanner = new Scanner(System.in);
            byte operation = scanner.nextByte();                                    // Entering one of three comparing methods

            switch (operation){
                case 1:
                    List<Integer> arrExampleList = new ArrayList<Integer>();

                    Utils.getStartTime(); // Taking start time
                    arrExampleList.add(50);
                    arrExampleList.add(60);
                    arrExampleList.add(70);
                    arrExampleList.add(80);
                    arrExampleList.add(90);
                    System.out.println("For Arraylist\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       long averageResultAdd = Utils.getAverageTime(startTime); //Taking finish time

                    Utils.getStartTime();
                    Utils.searchArrayList(arrExampleList);
                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       long averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    arrExampleList.removeAll(arrExampleList);
                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       long averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryArr = averageResultAdd + averageResultFind + averageResultRemove; // Summary time of adding, finding and removing operation
                    System.out.println("Summary time is " + summaryArr + " Nanoseconds" );

                    List<Integer> linkedExampleList = new LinkedList<Integer>();
                    Utils.getStartTime();
                    linkedExampleList.add(50);
                    linkedExampleList.add(60);
                    linkedExampleList.add(70);
                    linkedExampleList.add(80);
                    linkedExampleList.add(90);
                    System.out.println("For LinkedList\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    Utils.searchLinkedList(linkedExampleList);
                    Utils.searchLinkedList(linkedExampleList);
                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    linkedExampleList.removeAll(linkedExampleList);
                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryLinked = averageResultAdd + averageResultFind + averageResultRemove;
                    System.out.println("Summary time is " + summaryLinked + " Nanoseconds" );

                    if(summaryArr >summaryLinked){                                              //Comparing which method is the fastest
                        System.out.println("ArrayList faster !!!");
                    }else
                        System.out.println("LinkedList faster !!!");
                break;

                case 2:

                    Set<Integer> setExample = new HashSet<Integer>();
                    Utils.getStartTime();
                    setExample.add(50);
                    setExample.add(60);
                    setExample.add(70);
                    setExample.add(80);
                    setExample.add(90);
                    System.out.println("For HashSet\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    Utils.searchHashSet(setExample);
                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    setExample.removeAll(setExample);
                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryHashSet = averageResultAdd + averageResultFind + averageResultRemove;
                    System.out.println("Summary time is " + summaryHashSet + " Nanoseconds" );


                    Set<Integer> treeExample = new TreeSet<Integer>();
                    Utils.getStartTime();
                    treeExample.add(50);
                    treeExample.add(60);
                    treeExample.add(70);
                    treeExample.add(80);
                    treeExample.add(90);
                    System.out.println("For TreeSet\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    Utils.searchTreeSet(treeExample);
                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    treeExample.removeAll(treeExample);
                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryTreeSet = averageResultAdd + averageResultFind + averageResultRemove;
                    System.out.println("Summary time is " + summaryTreeSet + " Nanoseconds" );

                    if(summaryHashSet > summaryTreeSet){
                        System.out.println("HashSet faster !!!\n");
                    }else
                        System.out.println("TreeSet faster !!!\n");
                    break;

                case 3:
                    Map<Integer,String> hashMapExample = new HashMap<Integer, String>();

                    Utils.getStartTime();
                    hashMapExample.put(1, "First");
                    hashMapExample.put(2, "Second");
                    hashMapExample.put(3, "Third");
                    hashMapExample.put(4, "Fourth");
                    hashMapExample.put(5, "Fifth");
                    System.out.println("For TreeSet\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    for (Map.Entry entry : hashMapExample.entrySet());
                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    hashMapExample.remove(0);
                    hashMapExample.remove(1);
                    hashMapExample.remove(2);
                    hashMapExample.remove(3);
                    hashMapExample.remove(4);
                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryHashMap = averageResultAdd + averageResultFind + averageResultRemove;
                    System.out.println("Summary time is " + summaryHashMap + " Nanoseconds\n" );

                    TreeMap<Integer, String> treeMapExample = new TreeMap<Integer, String>();

                    Utils.getStartTime();
                    treeMapExample.put(1, "First");
                    treeMapExample.put(2, "Second");
                    treeMapExample.put(3, "Third");
                    treeMapExample.put(4,"Fourth");
                    treeMapExample.put(5,"Fifth");
                    System.out.println("For TreeMap\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    for(Map.Entry entry: treeMapExample.entrySet());
                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryTreeMap = averageResultAdd + averageResultFind + averageResultRemove;
                    System.out.println("Summary time is " + summaryTreeMap + " Nanoseconds" );

                    if(summaryHashMap > summaryTreeMap){
                        System.out.println("HashMap faster !!!\n");
                    }else
                        System.out.println("TreeMap faster !!!\n");
                    break;
                case 4:
                    System.out.println("GoodBye !"); //Exit from the program
                    entered = false;
                    break;

            }
        }
    }
}
