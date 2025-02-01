package com.pratik.thejavajourney.dsa.bit_manipulation;

public class Countsetbits {
    public static void main(String[] args) {
        int num=16;
        int count =countSetBits(num);
        System.out.println(count);
    }

    private static int countSetBits(int num) {
        int count=0;

        while (num > 0) {
            if((num & 1)==1){
                count++;
            }
            num=num>>1;
        }

        return count;
    }
}
