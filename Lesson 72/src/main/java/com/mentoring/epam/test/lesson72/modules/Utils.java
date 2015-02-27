package com.mentoring.epam.test.lesson72.modules;

import java.util.List;
import java.util.Set;

/**
 * Created by Iurii_Galias on 2/16/15.
 */
public class Utils {
    public static long getStartTime(){
        long startTime = System.nanoTime();
        return startTime;
    }

    public static long getAverageTime(long startTime){
        long averageTime;
        averageTime = System.nanoTime() - startTime;
        return averageTime;
    }

    public static void searchArrayList(List<Integer> arraySearch){
        for(Integer integer : arraySearch){
            if (integer.equals(5445454)){
                System.out.println(integer);
            }
            //System.out.println(integer);
        }
    }
    public static void searchLinkedList(List<Integer> linkedSearch){
        for(Integer integer : linkedSearch){
        }
    }

    public static void searchHashSet(Set<Integer> hashSearch){
        for(Integer integer : hashSearch){
        }
    }

    public static void searchTreeSet(Set<Integer> treeSearch){
        for(Integer integer : treeSearch){
        }
    }
}
