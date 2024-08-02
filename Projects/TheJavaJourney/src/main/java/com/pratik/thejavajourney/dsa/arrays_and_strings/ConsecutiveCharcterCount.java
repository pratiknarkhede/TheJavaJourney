package com.pratik.thejavajourney.dsa.arrays_and_strings;

public class ConsecutiveCharcterCount {



    public static void main(String[] args) {
        String inputString="aaaabbbbbbccdddde";
        //expected output: a4b5c3d4e1

        String outputString=countConsecutiveCharacters(inputString);
        System.out.println(outputString);
    }

    private static String countConsecutiveCharacters(String inputString) {
        StringBuilder sb=new StringBuilder();
        int tempCount=1;
        int length = inputString.length();
        for(int i = 1; i< length; i++){
            //focus here we are staring from index position 1 and equating charcter at
            // current position to character of previous position.
            // and in the end for last element appending character at last postion with its count,
            // also count it iniliaze to 1 because if elements exists it will have minimum occurence of 1

            if(inputString.charAt(i)==inputString.charAt(i-1)){
               tempCount++;
            }else{
               sb.append(inputString.charAt(i-1)).append(tempCount);
               tempCount=1;
            }
        }
        sb.append(inputString.charAt(length-1)).append(tempCount);

        return sb.toString();
    }


}
