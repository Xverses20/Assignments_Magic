package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        System.out.print("Enter the numbers : ");
        Scanner useless =new Scanner(System.in);
        String numbers = useless.nextLine();
        String [] temp = numbers.split(" ");
        ArrayList<Integer> intArray = new ArrayList<>();
        for (String s : temp) {
            int temp1 = Integer.parseInt(s);
            intArray.add(temp1);
        }
        System.out.println("Second Largest Element is: "+ secondLargest(intArray));
    }
    public static int secondLargest(ArrayList<Integer> intArray){
        int l1,l2;
        l1= intArray.get(0);
        l2=0;
        for(Integer i : intArray)
        {
            if(i>l1)
            {
                l2=l1;
                l1=i;
            }
            else if (i>l2 && i !=l1)
            {
                l2=i;
            }
        }
        return l2;

    }
}
