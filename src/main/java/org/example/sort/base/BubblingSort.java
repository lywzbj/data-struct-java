package org.example.sort.base;

import java.io.FileNotFoundException;

/**
 * 冒泡排序
 */
public class BubblingSort {






    public static void main(String[] args) throws FileNotFoundException {


    test();


    }





    public static void test() {


        try {

            System.out.println("111111");
            System.out.println( 1 / 0);
        }catch (Exception e) {
            System.out.println("发生异常");

        }finally {
            throw new RuntimeException("test");
        }



    }






    /**
     * 从前面开始冒泡排序
     * @param array
     */
    public static void preSort(int [] array) {
        if(array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                int left= array[j];
                int nextIndex = j + 1;
                if(nextIndex >= array.length) {
                    break;
                }
                int right = array[nextIndex];
                if(left > right) {
                    array[j] = right;
                    array[nextIndex] = left;
                }
            }
        }
    }







}
