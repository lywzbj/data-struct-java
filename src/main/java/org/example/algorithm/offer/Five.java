package org.example.algorithm.offer;

/**
 * 替换空格
 *
 * 请实现一个函数，把字符串中的每个空格替换成  %20. 例如，输入  “We are happy" 则输出  ”We%20are%20happy"
 *
 */
public class Five {


    public static void main(String[] args) {



        String str = "We are happy";

        String replace = replace(str, ' ', "%20");

        System.out.println(replace);


    }

    public static String replace(String target,char a,String newStr) {
        char[] chars = target.toCharArray();
        int aCount = 0;
        for (char c : chars) {
            if(c == a) {
                aCount++;
            }
        }
        int strSize = newStr.length();
        char[] array = newStr.toCharArray();
        int newSize = (newStr.length() * aCount) + (chars.length - aCount);
        char[] newChars = new char[newSize];
        newSize--;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c =  chars[i];
            if(c == a) {
                for (int i1 = strSize - 1; i1 >= 0; i1--) {
                    newChars[newSize] = array[i1];
                    newSize--;
                }

            } else {
                newChars[newSize] = c;
                newSize--;
            }
        }
        return new String(newChars);
    }











}
