package org.example.algorithm.offer;


/**
 * 题目： 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的排列顺序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Four {


    public static void main(String[] args) {
        int [] [] array = {{3,7,9},{5,10,12},{9,15,17},{22,25,30}};
        for (int i = 0; i < array.length; i++) {
            int[] ints = array[i];
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println(" ");
        }
        find(array,30);
    }


    public static void find(int [][] array,int number) {

        if(array == null || array.length < 1) {
            System.out.println("二维数组为空");
            return;
        }

        int row = array.length - 1;
        int y = 0;
        int x = array[0].length - 1;
        while (x >=0 && y<=row) {
            int value = array[y][x];
            if(value == number) {
                System.out.println("找到数字：" + number + "的位置 x:" + x + " y:" + y);
                break;
            }
            // 获取到的值大于  说明在上半部分
            if (value > number) {
                x--;
            } else {
                y++;
            }
        }






















    }







}
