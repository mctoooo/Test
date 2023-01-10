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

    static class PrinterUserFormat {

        String text;

        public interface FormattingText {

            String toUserFormat(String format);
        }
        FormattingText userFormat = (str) -> "defolt format:" + str;

        PrinterUserFormat() {
            text = "Printer";
        }

        void PrintToUserFormat() {

            System.out.println(userFormat.toUserFormat(text));
        }

        void setUserFormat(FormattingText usrFormat) {
            userFormat = usrFormat;
        }

    }
   static String getNewString(String str)
    {
    return  str.toUpperCase();
    }

    interface Expression {

        boolean isEqual(int n);
    }
    // класс, в котором определены методы

    class ExpressionHelper {

        static boolean isEven(int n) {

            return n % 2 == 0;
        }

        static boolean isPositive(int n) {

            return n > 0;
        }
    }

    private static int sum(int[] numbers, Expression func) {
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i)) {
                result += i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        PrinterUserFormat prn = new PrinterUserFormat();
        prn.PrintToUserFormat();
        
        PrinterUserFormat.FormattingText usr = (str)->"UserFormat " + str + "!!!!";
        prn.setUserFormat(usr);
        prn.PrintToUserFormat();
        
        usr = Test::getNewString;
        prn.setUserFormat(usr);
        prn.PrintToUserFormat();

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

        Expression func = (n) -> n % 2 == 0;
        //       int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        int res = sum(nums, func);
        System.out.println("Sum of elements = " + res);

        func = n -> n < 3;
        res = sum(nums, func);
        System.out.println("Sum of elements = " + res);

        Expression expr = ExpressionHelper::isPositive;
        System.out.println("sum positive " + sum(nums, expr));

        System.out.println("sum even " + sum(nums, ExpressionHelper::isEven));

    }
}
