package com.pratik.thejavajourney.dsa.greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills={5,5,5,10,20};
        LemonadeChange lc = new LemonadeChange();
        boolean b = lc.lemonadeChange(bills);
        System.out.println(b);
    }

    public boolean lemonadeChange(int[] bills) {
        int reserveCash=0;

        for (int i=0;i< bills.length;i++) {
            System.out.println(reserveCash);
            reserveCash=(reserveCash+bills[i])-(bills[i]-5);
            if(reserveCash < 0) return false;
        }
        return true;
    }
}
