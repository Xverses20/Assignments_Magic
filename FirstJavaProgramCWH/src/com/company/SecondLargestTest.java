package com.company;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecondLargestTest {

    @Test
    void Test1(){
        SecondLargest t1 =new SecondLargest();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(18);arr.add(20);arr.add(1);arr.add(14);arr.add(16);arr.add(18);arr.add(9);arr.add(0);
        assertEquals(18,t1.secondLargest(arr));
    }
    @Test
    void Test2(){
        SecondLargest t2 =new SecondLargest();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1000);arr.add(34);arr.add(979);arr.add(910);arr.add(-1);arr.add(1001);arr.add(115);arr.add(1123);arr.add(329);
        assertEquals(1001,t2.secondLargest(arr));
    }
    @Test
    void Test3(){
        SecondLargest t3 =new SecondLargest();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(18);arr.add(20);arr.add(1);arr.add(14);arr.add(16);arr.add(318);arr.add(9);arr.add(220);
        assertEquals(220,t3.secondLargest(arr));
    }
}