package com.company;

import java.util.HashMap;
import java.util.Scanner;
public class AnagramCheck {
    public static void main(String[] args) {
        Scanner useless = new Scanner(System.in);
        System.out.print("Enter String 1 : ");
        String string1 = useless.nextLine();
        System.out.print("\n"+"Enter String 2 : ");
        String string2 = useless.nextLine();
        System.out.println("The Strings are Anagrams : " + anagrams(string1,string2) );


    }
    public static boolean anagrams(String str1, String str2)
    {
        if(str1.length()!=str2.length())
            return false;
        str1=str1.replaceAll(" ","").toLowerCase();
        str2=str2.replaceAll(" ","").toLowerCase();
        HashMap<Character,Integer> anagram_map = new HashMap<Character,Integer>();
        for(int i=0;i<str1.length();i++)
        {
            char str_1 =str1.charAt(i);
            if(anagram_map.containsKey(str_1))
                anagram_map.put(str_1,anagram_map.get(str_1)+1);
            else
                anagram_map.put(str_1,1);
        }
        for(int i=0;i<str2.length();i++)
        {
            char str_2 = str2.charAt(i);
            if(anagram_map.containsKey(str_2))
            {
                if(anagram_map.get(str_2)==1)
                    anagram_map.remove(str_2);
                else
                    anagram_map.put(str_2, anagram_map.get(str_2)-1);
            }
            else
                return false;
        }
            if (anagram_map.size()>0)
                return false;
            return true;
        }
    }

