package io.programminglife.recursion;

public class Factorial {

    public static int findFactorial(int number) {
        if(number == 0) {
            return 1;
        }

        return number * findFactorial(--number);
    }

    public static void main(String[] args) {
        int factorial = findFactorial(5);

        System.out.println(factorial);
    }
    
}