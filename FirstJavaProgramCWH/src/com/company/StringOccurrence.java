package com.company;
import java.util.Scanner;
public class StringOccurrence{
	// Implemented using Frequency Array. Can be done with Hashmap as well.
        public static void main(String[] args) {
            System.out.println("The Program doesn't differentiate between Upper Case and Lower Case.");
            System.out.print("Enter the string: ");
            Scanner useless= new Scanner(System.in);
            String word= useless.nextLine();
            word=word.toLowerCase();
            stringOccurence(word);

        }

    public static void stringOccurence(String word) {
        int[] ascii_array = new int[256];
        int temp;
        char temp1;
        for(int i=0;i< word.length();i++)
        {
            temp=word.charAt(i);
            ascii_array[temp]= ascii_array[temp]+1;
        }
        for(int i=0;i<ascii_array.length;i++)
        {
            if(ascii_array[i]>0)
            {
                temp1=(char)i;
                System.out.println("Value of " + temp1 +" is "+ascii_array[i]);
            }
        }
    }
}