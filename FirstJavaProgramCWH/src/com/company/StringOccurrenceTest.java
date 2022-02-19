package com.company;

import org.junit.jupiter.api.Test;
import com.company.StringOccurrence;
import static org.junit.jupiter.api.Assertions.*;

class StringOccurrenceTest {

    @Test
    void Test1() {
        StringOccurrence t1=new StringOccurrence();
        assertEquals("[2, 1, 1, 2, 3, 3]",t1.stringOccurence("AAA aaa #&$&"));
    }
    @Test
    void Test2() {
        StringOccurrence t2=new StringOccurrence();
        assertEquals("[2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1]" ,t2.stringOccurence("Work is Everything"));
    }
    @Test
    void Test3() {
        StringOccurrence t3=new StringOccurrence();
        assertEquals("[1, 2, 1, 1, 2, 1, 2, 2, 2, 2, 2]" ,t3.stringOccurence("Ayush $51233$Ayush"));
    }
    @Test
    void Test4() {
        StringOccurrence t4 = new StringOccurrence();
        assertEquals("[5, 2, 2, 1, 1, 1, 2, 1, 1, 4, 3, 3, 3, 1, 2, 1, 1]", t4.stringOccurence("Hell is debugging Please Wait @!@!"));

    }
}