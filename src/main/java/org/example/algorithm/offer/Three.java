package org.example.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题3：数组中的重复数字
 *  在一个长度为n的数组里所有数字都在0-n-1的范围内，数组中某些数字是重复的，但不知道有那几个数字重复，也不知道每个数字重复了几次
 *  请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2，3，1，0，2，5，3}那么对应的输出是重复的数字2或者3
 *
 */
public class Three {


    public static void main(String[] args) {
        int [] array = {1,2,3,3,4,5,6};
        duplicate(array,7);

    }


    /**
     * 哈希表的方法记录重复数字与重复次数
     * @param array
     */
    public static void  hashDistinct(int [] array) {
        if(array == null || array.length < 2) {
            return;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : array) {
            Integer integer = map.get(i);
            if(integer != null) {
                integer++;
            } else {
                integer=1;
            }
            map.put(i,integer);
        }

        for (Integer integer : map.keySet()) {
            Integer value = map.get(integer);
            if(value >= 2) {
                System.out.println("重复的数字为： " + integer);
            }
        }
    }


    /**
     * 数组下标标记重复数字法
     * @param array
     */
    public static void indexDistinct(int [] array) {
        if(array == null || array.length < 2) {
            return;
        }

        // 先排序
        for (int i = 1; i < array.length; i++) {
            for (int j = array.length - 1; j >= 0; j--) {
                int right = array[j];
                int nextIndex = j - 1;
                if(nextIndex < 0) {
                    break;
                }
                int left = array[nextIndex];
                if(right < left) {
                    array[j] = left;
                    array[nextIndex] = right;
                }
            }
        }
        }



    public static void duplicate(int[] numbers,int length) {
        if(numbers == null || length <=0) {
            return;
        }
        for (int i = 0; i < length; i++) {

            if(numbers[i] < 0 || numbers[i] > length -1) {
                return;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    System.out.println(numbers[i]);
                    return;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

    }


}










