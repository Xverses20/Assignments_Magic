package com.company;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
public class NonRepeatNumber {
    public static void main(String[] args) {
        System.out.print("Enter the numbers : ");
        Scanner useless =new Scanner(System.in);
        String numbers = useless.nextLine();
        String [] temp = numbers.split(" ");
        ArrayList <Integer> intArray = new ArrayList<>();
        for (String s : temp) {
            int temp1 = Integer.parseInt(s);
            intArray.add(temp1);
        }
        System.out.println(nonRepeat(intArray));
    }
    public static int nonRepeat(ArrayList<Integer> intArray){
        Map<Integer,Integer> answerMap = new HashMap<>();
        for(int i=0; i< intArray.size();i++)
        {
            int temp = intArray.get(i);
            if(answerMap.containsKey(temp))
            {
                answerMap.put(temp, answerMap.get(temp)+1);
            }
            else
            {
                answerMap.put(temp,1);
            }
        }
        for(int i=0;i< intArray.size();i++)
        {
            if(answerMap.get(intArray.get(i))== 1)
                return intArray.get(i);
        }
        return -1;
    }
}
