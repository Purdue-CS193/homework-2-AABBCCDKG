/*
* CS 193 Homework 3
*
* TODO: READ THESE INSTRUCTIONS!
*
* The comments in the methods are for clarification. No tricks or riddles.
*
* The overall algorithm should not change. Don't focus on improving the runtime. 
*
* Debug in whichever way you feel is best.
*
* IT WILL BE AN AUTOMATIC 0, IF YOU MAKE CHANGES TO TESTCASES.JAVA
*
* Bonus: Understand these methods! They are helpful in interviews :)
* 
*/

import java.util.*;
import java.util.ArrayList;

public class Questions {

    // Task 1
    public static int findMax(int[] input) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }

    // Task 2
    public static int findMin(int[] input) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < min) {
                min = input[i];
            }
        }
        return min;
    }

    // Task 3
    public static int findSum(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        return sum;
    }

    // Task 4
    public static int findAverage(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        return sum / input.length;
    }

    // Task 5
    public static ArrayList<String> fizzBuzz(int n) {
        // EXPLANATION: RETURN A LIST 1 TO n BUT
        // Multiples OF 3 ARE REPLACED BY "fizz"
        // Multiples OF 5 ARE REPLACED BY "buzz"
        // Multiples OF 3 AND 5 ARE REPLACED BY "fizzbuzz"
        //
        // FROM 1 TO 15 THE LIST WOULD LOOK LIKE
        // {"1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"}
        // Note: In java an array is different from a list
        // The data structure we will be using is an ArrayList

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                answer.add("fizzbuzz");
            } else if (i % 3 == 0) {
                answer.add("fizz");
            } else if (i % 5 == 0) {
                answer.add("buzz");
            } else {
                answer.add(Integer.toString(i));
            }
        }
        return answer;
    }

    // Task 6
    public static int reverseNumber(int input) {
        // reverse the number
        // 12345 should become 54321
        // Hint: How would you turn 9 into 95? Not by adding 86
        int answer = 0;
        while (input != 0) {
            int digit = input % 10;
            answer = answer * 10 + digit;
            input = input / 10;
        }
        return answer;
    }

    //EXTRA CREDIT BELOW HERE

    // Task 7
    // Look for a specific element in sorted array
    // keep in mind for this algorithm to work, array HAS to be sorted
    public static int binarySearch(int[] input, int target) {
        // look for the index of target in input
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (input[mid] == target) { // middle element is the target. Success!!!
                return mid;
            } else if (input[mid] < target) { // middle element is greater than the target
                low = mid + 1;
            } else { // middle element is smaller than the target
                high = mid - 1;
            }
        }
        return -1; // element is not found
    }

    // Task 8
    public static int countDuplicates(String input) {
        // Count the number of letters that are duplicated
        // The input string will always be lower case and contain no numbers
        // Example: Input: This is homework, Return: 3 (letters i, s, h, and o occur more than once

        input = input.toLowerCase(); // ensuring string is lower case
        int[] alphabetTemplate = new int[26];
        for (int i = 0; i < input.length(); i++) {// iterate over the string
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int index = ch - 'a';
                alphabetTemplate[index]++;
            }
        }
        int counter = 0;
        for (int i = 0; i < alphabetTemplate.length; i++) {
            if (alphabetTemplate[i] > 1) {
                counter++;
            }
        }
        return counter;
    }

    // Task 9
    public static int sumBetween193(int[] input) {
        int sum = 0;
        boolean startCounting = false;
        for (int i = 0; i < input.length; i++) {
            if (startCounting) {
                if (input[i] == 193) {
                    break;
                }
                sum += input[i];
            } else if (input[i] == 193) {
                    startCounting = true;
            }
        }
        return sum;
    }

    // Task 10
    public static boolean findSubstring(String theBigOne, String sub) {
        // checks to see if variable sub appears in theBigOne
        // highly recommended to write this one out on a notebook
        for (int i = 0; i <= theBigOne.length() - sub.length(); i++) {
            if (theBigOne.startsWith(sub, i)) {
                return true;
            }
        }
        return false;
    }

    // Main method is used for testing purposes
    public static void main(String[] args) {
        // Example given below
        // Run reverseNumber with your own input
        System.out.println(reverseNumber(54321));
    }
}

