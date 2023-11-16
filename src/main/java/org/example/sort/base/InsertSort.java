package org.example.sort.base;

/**
 * 插入排序
 */
public class InsertSort {


    public static void main(String[] args) {

        int [] array = {2,3,55,4,7,25,20,22};

        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }


    public static void sort(int [] array) {

        if(array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j - 1] = tmp;
                }
            }

        }









    }




}
