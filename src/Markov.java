/*
Name: Mohammad Haroon
Date: 09/24/2022
Program Description: This program reads a file and splits it into individual words. Each word is then checked for punctuation marks,
and if it ends with a period, exclamation mark, or question mark, it is added as a key to a hashmap. If the word does not end with punctuation,
the program checks if it has already been added as a key in the hashmap. If it hasn't, the word is added as a key. If the word is already present as a key,
it is added as a value to an ArrayList in the hashmap.
The program then selects values from the hashmap randomly and uses them to create new sentences.
This process continues until the program has generated a specified number of sentences.
Overall, this program is useful for creating randomized sentences using words from a given text file.
 */


import java.io.File;
import java.util.*;

//*********///
// class Markove start
public class Markov {
    private final static String PUNCTUATION = "--$"; // private member field  hold punctuation
    private final static String PUNCTUATION_MARKS =".!?";// private member field  hold punctuation use for comparison
   private HashMap<String , ArrayList<String>> words; // private hashmap which hold key as string arraylist as value
   private String prevWord =PUNCTUATION; // private member that will keep previous word


   // Constructor that initialize  Hashmap assign key and initialize arraylist
   public Markov(){
       words = new HashMap<>();  // Hashmap initialize
       words.put(PUNCTUATION , new ArrayList<>()); // adding a key and arraylist

   }


   // method getter
   protected HashMap<String, ArrayList<String>> getWords(){
       return words; // return Hashmap words
   }

   // This method reading file and adding the file to next method addline
   public void addFromFile(String filename){

       try{ // START OF TRY

           File file = new File(filename); // creating a new file
           Scanner fileReader = new Scanner(file); // creating file name to read

           while(fileReader.hasNext()){ // Start of while loop
               addLine(fileReader.nextLine()); // reading to method addLine from a file
           } // While loop END

           fileReader.close(); // file close for reading

       }catch(Exception e){
           System.out.println("File couldn't open.");

       } // End of catch
   }


   // This method check for blank space in sentence then split a sentence to individual word
   protected void addLine(String word){
       // checking the length of word or looking for blank space
      if(word.length() > 0){ // Start of if statement

          String[] words = word.split(" "); // splitting a sentence to individual word
          for (int i=0; i <words.length; i++){// Start of for loop
              addWord(words[i]); // adding each word to method addWord
          } //End of for loop

      } // End of if

   }

   // This method separate words that end with (.!?) punctuation and not end for different process
   protected void addWord(String word){



       // Check if word end with Punctuation (.!?) add to the key of hashmap
       if(endWithPunctuation(word)){ // Start of IF
          words.get(PUNCTUATION).add(word); // adding current word to the key of hashmap

       } //END of if
       // word doesnt end with Punctuation
       else { // start of ELSE
           // check if the previous   word is not in the key
             if(words.get(prevWord) == null){ // start of IF
                 words.put(word , new ArrayList<>()); // adding current word as key and initialize array list


             } // END OF IF
             else{ // Start of ELSE
                 words.get(prevWord).add(word); // adding the current word as value

             }

       } // END of ELSE
       prevWord = word; // set previous as current word


   }


   // This method create sentence from random word
   public String  getSentence(){

       StringBuilder sen = new StringBuilder(); // initializing String builder
       String currentWord = randomWord(PUNCTUATION); // calling randomWord method and set it to string variable

          // Check if word not end with punctuation add it with sentence with space
       if (!endWithPunctuation(currentWord)) { // Start of IF
           sen.append(currentWord).append(" " + getSentence()); //


       } // END OF IF
       else{ // START OF ELSE

           sen.append(currentWord); // just add word

       } // END OF ELSE

       return sen.toString(); // return the sentence that build
   }

// This method read values from arraylist in Hashmap randomly
   protected String randomWord(String wordKey){

        int key = words.get(wordKey).size();  // get the size of the word
       return  words.get(wordKey).get(new Random().nextInt(key)); // reading randomly and return the word

   }

   // This method check if word end with these special character (.!?)
   public  boolean endWithPunctuation(String word){
       int index = word.length() -1; // get the last index
       // check word end with special character return true otherwise return false
       if( PUNCTUATION_MARKS.contains(String.valueOf(word.charAt(index)))){ //Start IF
           return true;
       } //end of if
       return false;
   }
 // Tostring method
   public String toString(){

       return words.toString();  // return words Hashmap
   }




}
