package com.pratik.thejavajourney.dsa.bit_manipulation;

public class PowerOfTwo {

    public static void main(String[] args) {
        int nums[] = {16, 12, 32, 22, 1, 100, 128};
        boolean ifPowerOfTwo = false;
        String binaryString;
        for (int num : nums) {
            binaryString = Integer.toBinaryString(num);
            System.out.printf("Binary of :" + num + " : " + binaryString);
            System.out.println();
            ifPowerOfTwo = checkIfPowerOfTwo(num);
            System.out.printf(" and it is power of 2 :" + ifPowerOfTwo);
            System.out.printf("");
            System.out.println();
            System.out.println();
        }
    }

    private static boolean checkIfPowerOfTwo(int x) {
        //13 : 1101
        //if last bit is one return false
        //if count of 1 is 1 return true else false
        if ((x & 1) == 1) {
            return false;
        }
        int count = calculateNumberOfOnes(x);
        if (count == 1) return true;
        return false;
    }

    private static int calculateNumberOfOnes(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        System.out.println("count of 1 is "+ count);
        return count;
    }
}
