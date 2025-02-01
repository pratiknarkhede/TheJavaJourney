package com.pratik.thejavajourney.dsa.recursion;

import java.util.ArrayList;

public class PrintSubesequencesUsingRecursion {

    public static void main(String[] args) {
        int[] arr={3,2,1};
        printSubsequence(arr);
    }

    private static void printSubsequence(int[] arr) {
        ArrayList<Integer> intList = new ArrayList<>();
        calAndPrintSub(0,intList,arr);
    }

    /*
    * key point here is we have two choices at eveyr index , it is either to take element at that index or not take
    *  so for the first call (0,[],arr)
    *
    * we have choice to take element 3 or not take
    * but we take it and add it to list then go ahead
    * now call becomes f(1,[3],arr)
    *
    * now again we have choice at index 1 to take element from there which is 1 or not take it
    *
    * so we take it (2, [3,1],arr)
    * again at index 3  -> f(3, [3,1,2]),arr) since break condtion print intlist
    *
    * now we come back to index to , and now since we already taken choice to take element , this time we dont take it
    *
    * so call becomes f(3,[3,1],arr), since break condtion print intlist
    *
    * now call goes to index 1 ,we do not take 1,  f(2,[3],arr) f(3,[3],arr)
    *
    *
    *
    *
    *
    * */

    private static void calAndPrintSub(int i, ArrayList<Integer> intList, int[] arr) {
        if(i==arr.length){
            System.out.println(intList);
            return;
        }
        intList.add(arr[i]);
        calAndPrintSub(i+1,intList,arr);
        intList.remove(intList.size()-1);
        calAndPrintSub(i+1,intList,arr);
    }
}
