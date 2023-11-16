package org.example.algorithm.offer;

/**
 * 斐波那契数列
 *
 *        | 0      n = 0
 *  f(n) =|1       n = 1
 *        | f(n-1) + f(n - 2)    n> 1
 *
 *
 *
 * 斐波那契数列具有两种方法实现，分别是递归法和循环法
 * 递归法当项数较多时，速度会非常慢
 *
 * 如果考虑效率的话，使用循环法实现
 *
 *
 */
public class Ten {


    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            int val = method2(i);
            System.out.print(val + ",");
        }
    }

    public static int method1(int n) {
        if(n < 0) {
            throw new RuntimeException("n的值只能大于等于0");
        }
        if(n < 2) {
            return n;
        }
        return method1(n - 1) + method1( n - 2);
    }


    public static int method2(int n) {
        if(n < 2) {
            return n;
        }

        int reduceOne = 1;
        int reduceTwo = 0;

        for (int i = 2; i <= n; i++) {
            int tmp = reduceOne;
            reduceOne = reduceOne + reduceTwo;
            reduceTwo = tmp;
        }
        return reduceOne;
    }












}
