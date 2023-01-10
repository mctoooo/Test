/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.test;

/**
 *
 * @author Admin
 */
public class Test {

    interface SomeOperation {

        int calculate(int x, int y);
    }
    interface Expression{
    boolean isEqual(int n);   
}
    private static int sum (int[] numbers, Expression func)
    {
        int result = 0;
        for(int i : numbers)
        {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        SomeOperation sumOperation;
        sumOperation = (x, y) -> x + y;
        System.out.println(sumOperation.calculate(1, 2));

        sumOperation = (x, y) -> x * y;
        System.out.println(sumOperation.calculate(2, 2));

        sumOperation = (x, y)
                -> {
            if (x < y) {
                return x;
            }
            return y;
        };
        System.out.println(sumOperation.calculate(10, 30));
        
        Expression func = (n)-> n%2==0;
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int res =sum(nums,func);
        System.out.println("Sum of elements = "+ res);
        
        func = n->  n<3;
        res =sum(nums,func);
        System.out.println("Sum of elements = "+ res);

    }
}
