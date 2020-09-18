package com.company;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final HashMap<Long, Long> values = new HashMap<>();

    public static void main(String[] args) {
        long i = 1;
        long j = 1;

        System.out.println("----------------------------" +
                "Welcome! This algorithm calculates how many steps need number to reach 1 using formula" +
                "----------------------------"+
                "\n1.If number is even number = number '/' 2" +
                "\n2.If number is odd = number * 3 + 1"
                +"\nAttention! For numbers >= 113383 algorithm reaches integer bound, so loop will go infinitely");
        Scanner sc = new Scanner(System.in); // створення об'єкту класа Scanner
        System.out.print("Enter first number: ");

        try {
            i = sc.nextLong();
            while (i <= 0) {
                System.out.println("Enter natural!");
                System.out.print("Enter first number: ");
                i = sc.nextLong();
            }


        } catch (InputMismatchException e) {
            System.out.println("You entered String, number=1");

        }
        try {
            System.out.print("Enter second number: ");
            j = sc.nextLong();
            while (j <= 0) {
                System.out.println("Enter natural!");
                System.out.print("Enter second number: ");
                j = sc.nextLong();
            }
        }catch (InputMismatchException e){
            System.out.println("You entered String, number=1");
        }
        long temp = i;
        long temp1 = j;
        if (i > j){
            temp = j;
            temp1 = i;
        }
        long maxLength = 0;
        for (long n = temp; n <= temp1; n++) {
            if (calculateLength(n) > maxLength) maxLength = calculateLength(n);
        }
        System.out.println(i + " " + j + " " + maxLength);

    }

    private static long calculateLength(long n) {
        long number = n;
        long counter = 0;
        if (n == 1)return 1;
        while (n != 1) {
            counter++;
            if (values.containsKey(n)) {
                return counter + values.get(n);
            }
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }

        }
        values.put(number, counter);
        return counter;
    }
}
