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
        Random rand = new Random();
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
                    for (int counterArrAdd = 0; counterArrAdd <= 100; counterArrAdd++){
                        arrExampleList.add(rand.nextInt());
                    }Utils.getAverageTime(startTime);


                    System.out.println("For Arraylist\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       long averageResultAdd = Utils.getAverageTime(startTime); //Taking finish time

                    Utils.getStartTime();
                    Utils.searchArrayList(arrExampleList);
                    Utils.getAverageTime(startTime);
                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       long averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    arrExampleList.removeAll(arrExampleList);
                    Utils.getAverageTime(startTime);
                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       long averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryArr = averageResultAdd + averageResultFind + averageResultRemove; // Summary time of adding, finding and removing operation
                    System.out.println("Summary time is " + summaryArr + " Nanoseconds" );

                    List<Integer> linkedExampleList = new LinkedList<Integer>();
                    Utils.getStartTime();
                    for(int counterLinkedList = 0; counterLinkedList <= 100; counterLinkedList++){
                        linkedExampleList.add(rand.nextInt());
                    }Utils.getAverageTime(startTime);

                    System.out.println("For LinkedList\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    Utils.searchLinkedList(linkedExampleList);
                    Utils.getAverageTime(startTime);

                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    linkedExampleList.removeAll(linkedExampleList);
                    Utils.getAverageTime(startTime);

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
                    for(int counterHashSetAdd = 0; counterHashSetAdd <= 100; counterHashSetAdd++){
                        setExample.add(rand.nextInt());
                    }Utils.getAverageTime(startTime);

                    System.out.println("For HashSet\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    Utils.searchHashSet(setExample);
                    Utils.getAverageTime(startTime)
                    ;
                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    setExample.removeAll(setExample);
                    Utils.getAverageTime(startTime);

                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryHashSet = averageResultAdd + averageResultFind + averageResultRemove;
                    System.out.println("Summary time is " + summaryHashSet + " Nanoseconds" );


                    Set<Integer> treeExample = new TreeSet<Integer>();
                    Utils.getStartTime();
                    for(int counterTreeSetAdd = 0; counterTreeSetAdd <= 100; counterTreeSetAdd++){
                        treeExample.add(rand.nextInt());
                    }Utils.getAverageTime(startTime);

                    System.out.println("For TreeSet\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    Utils.searchTreeSet(treeExample);
                    Utils.getAverageTime(startTime);

                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    treeExample.removeAll(treeExample);
                    Utils.getAverageTime(startTime);

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
                    Map<Integer,Integer> hashMapExample = new HashMap<Integer, Integer>();

                    Utils.getStartTime();
                    for(int counterHashMap = 0; counterHashMap <= 100; counterHashMap++){
                        hashMapExample.put(rand.nextInt(),rand.nextInt());
                    }Utils.getAverageTime(startTime);

                    System.out.println("For HashMap\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    for (Map.Entry entry : hashMapExample.entrySet()){
                        if (entry.equals(555666)){
                            System.out.println(entry);
                        }Utils.getAverageTime(startTime);
                    }

                    System.out.println("Finding elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    for(int counterHashMap = 0; counterHashMap <= 100; counterHashMap++){
                        hashMapExample.remove(counterHashMap);
                    }Utils.getAverageTime(startTime);

                    System.out.println("Removing all elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultRemove = Utils.getAverageTime(startTime);
                                       long summaryHashMap = averageResultAdd + averageResultFind + averageResultRemove;
                    System.out.println("Summary time is " + summaryHashMap + " Nanoseconds\n" );

                    TreeMap<Integer, Integer> treeMapExample = new TreeMap<Integer, Integer>();

                    Utils.getStartTime();
                    for(int counterTreeMap = 0; counterTreeMap <= 100; counterTreeMap++){
                        treeMapExample.put(rand.nextInt(),rand.nextInt());
                    }Utils.getAverageTime(startTime);

                    System.out.println("For TreeMap\n" +
                                       "_______________\n" +
                                       "Add elements...\n" +
                                       "Work time = " + Utils.getAverageTime(startTime));
                                       averageResultAdd = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    for(Map.Entry entry: treeMapExample.entrySet()){
                        if (entry.equals(555666)){
                            System.out.println(entry);
                        }Utils.getAverageTime(startTime);
                    }

                    System.out.println("Finding elements...\n" +
                            "Work time = " + Utils.getAverageTime(startTime));
                            averageResultFind = Utils.getAverageTime(startTime);

                    Utils.getStartTime();
                    for(int counterTreeMap = 0; counterTreeMap <= 100; counterTreeMap++){
                        treeMapExample.remove(counterTreeMap);
                    }Utils.getAverageTime(startTime);

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
