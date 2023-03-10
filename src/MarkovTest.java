/*
Name : Mohammad Haroon
Date: 09/24/2022
Program Description: this program test all the methods that working properly as it is design
 */


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MarkovTest {
   Markov MarkovTest = null; // Create Markov reference
    @BeforeEach
    void setUp() {
          MarkovTest = new Markov(); // create the object
    }

    @AfterEach
    void tearDown() {
    }


    // Check getWord method that reading from file
    @Test
    void getWords() {
        HashMap<String , ArrayList<String >> testWords = new HashMap<>();
        ArrayList <String> arr = new ArrayList<>();
        arr.add(0 , "Hello");
        arr.add(1 , "World.");
        testWords.put("--?" , arr);
           MarkovTest.addFromFile("/Users/zainabzoya/Documents/Java File/Markov/src/test.txt");

       assertEquals(testWords , MarkovTest.getWords());




    }

    @Test
    void addFromFile() {


    }

    @Test
    void addLine() {
    }

    @Test
    void addWord() {
    }


    // testing getSentence method that creating a sentence
    @Test
    void getSentence() {

        MarkovTest.addFromFile("/Users/zainabzoya/Documents/Java File/Markov/src/test.txt");
        assertEquals("Hello", MarkovTest.getSentence());

    }


    // testing randomWord method that read random word from arrylist hashmap
    @Test
    void randomWord() {

        MarkovTest.addFromFile("/Users/zainabzoya/Documents/Java File/Markov/src/test.txt");
        assertNotEquals(MarkovTest.getSentence() , MarkovTest.getSentence());
    }


    // testing endWithPunctuation method that return true result if word end with special characters
    @Test
   void endWithPunctuation() {

    assertEquals(true , MarkovTest.endWithPunctuation("Hello?"));


    }

    // testing toString method
    @Test
    void testToString() {
        HashMap<String, ArrayList<String >> check = new HashMap<>();
        ArrayList<String > arr = new ArrayList<>();
        arr.add(0, "[Hello.]}");

        check.put(MarkovTest.toString(), new ArrayList<>());



        assertNotEquals(check.toString().length() , MarkovTest.toString().length());
    }
}