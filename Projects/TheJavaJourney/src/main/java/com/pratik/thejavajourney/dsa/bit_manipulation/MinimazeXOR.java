package com.pratik.thejavajourney.dsa.bit_manipulation;

public class MinimazeXOR {
    public static void main(String[] args) {

        int num1 = 79;
        int num2 = 74;
        int x = findMinimizedXOR(num1, num2);
        System.out.println("minimized number :" + x);
    }

    private static int findMinimizedXOR(int num1, int num2) {
        int x = num1;
        int onesInNum2 = countNumberOfOnes(num2);
        int onesInNum1 = countNumberOfOnes(num1);
        //iterate for i with it constraint , it being 32 at max
        // from msb to lsb
        for (int i = 31; i >= 0; i--) {
            if ((x & (1 << i)) != 0) { // If the ith bit is set
                x = x & (~(1 << i));  // Turn it off
                onesInNum1--;
            }
            if (onesInNum1 == onesInNum2) break; // Stop when we reach the desired count
        }


        for (int i = 0; i < 32; i++) {
            if (onesInNum1 < onesInNum2) {
                //turn on bits to macth number of ones in num2
                if ((x & (1 << i)) == 0) {
                    //turn on the bits
                    x = x | (1 << i);
                    onesInNum1++;
                }
            }
            if (onesInNum1 == onesInNum2) break;
        }

        return x;
    }

    // 1 = 0001
    //12 = 1100
    //
    // 3 : 0011
    //  1 : 0001
    //     0010

    private static int countNumberOfOnes(int num) {
        int count = 0;
        //check last bit if 1 , increment count
        // num & 1 will create mask of
        // xor it with number if result is 1 then last digit of number is 1

        // right shift till number becomes zero

        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }

        return count;
    }
}

//  25       0001101
/// 33       0100001
// 72        1001000
//