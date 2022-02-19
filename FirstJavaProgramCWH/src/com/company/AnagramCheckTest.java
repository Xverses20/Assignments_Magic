package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckTest {

    @Test
    void Test1(){
        AnagramCheck t1 = new AnagramCheck();
        assertEquals(true,t1.anagrams("abcd","dbca"));

    }
    @Test
    void Test2(){
        AnagramCheck t2 = new AnagramCheck();
        assertEquals(false,t2.anagrams("LISTEN","SILENTLY"));

    }
    @Test
    void Test3(){
        AnagramCheck t3 = new AnagramCheck();
        assertEquals(true,t3.anagrams("TRINAGLE","integral"));

    }

    }
