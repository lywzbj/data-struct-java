package org.example.sort.base;

public class SelectSort {


    public static void main(String[] args) {

        int [] array = {2,5,3,90,12,44,39,-1};
        sort(array);


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }






    }


    public static void sort(int [] array) {
        if(array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    index = j;
                }
            }

            int tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;
        }








    }



}
