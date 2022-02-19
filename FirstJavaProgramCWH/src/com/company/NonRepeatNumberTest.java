package com.company;
import com.company.NonRepeatNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonRepeatNumberTest {

    @Test
    void Test1() {
        NonRepeatNumber t1 = new NonRepeatNumber();
        assertEquals(20,t1.nonRepeat("1 18 20 1 14 16 18 9 0"));

    }
    @Test
    void Test2() {
        NonRepeatNumber t2 = new NonRepeatNumber();
        assertEquals(-1,t2.nonRepeat("32 7 -3 -1 32 7 -3 0"));

    }
    @Test
    void Test3() {
        NonRepeatNumber t3 = new NonRepeatNumber();
        assertEquals(14,t3.nonRepeat("1 18 20 1 14 16 18 9 0 1 20"));

    }
    @Test
    void Test4() {
        NonRepeatNumber t1 = new NonRepeatNumber();
        assertEquals(-4,t1.nonRepeat("1 18 20 1 14 16 18 9 0 -4 20 14 16 9 0"));

    }
}