package com.pratik.thejavajourney.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<Integer> sList=new ArrayList<>();
        List<List<Integer>> subsetList=new ArrayList<>();

        return checkAndAddSubset(0,sList,subsetList,nums);
    }


    public List<List<Integer>> checkAndAddSubset(int i,List<Integer> sList,List<List<Integer>>  subsetList, int[] arr){

        //at each index either take an element or do not take it

        if(i>=arr.length){
            subsetList.add(new ArrayList<>(sList));
            System.out.println(sList);
            return subsetList;
        }
        //take element
        sList.add(arr[i]);
        checkAndAddSubset(i+1,sList,subsetList,arr);
        // remove lastly added element
        sList.remove(sList.size()-1);
        // not take the element
        checkAndAddSubset(i+1,sList,subsetList,arr);
        return subsetList;

    }

    public static void main(String[] args) {
        int[] arr={1,3,4,5};
        PowerSet s=new PowerSet();
        List<List<Integer>> subsets = s.subsets(arr);
        System.out.println(subsets);
    }
}