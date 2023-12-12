package org.example.sort.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

public class ShellSort {


    public static void main(String[] args) {

        Long l1 = 8874575275145L;
        Long l2 = 8874575275145L;

        System.out.println(l1.equals(l2));

        Map<Long,String> map = new HashMap<>();
        Long key = map.entrySet().iterator().next().getKey();

        System.out.println(key);


        int[] testArray = {12, 34, 54, 2, 3};

        System.out.println("Array before sorting:");
        for (int i=0; i<testArray.length; i++)
            System.out.print(testArray[i] + " ");

        sort(testArray);

        System.out.println("\nArray after sorting:");
        for (int i=0; i<testArray.length; i++)
            System.out.print(testArray[i] + " ");


    }



    public static void sort(int array[]) {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i=gap; i<n; i+=1) {
                int temp = array[i];

                int j;
                for (j=i; j>=gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j-gap];

                array[j]=temp;
            }
        }
    }
}
