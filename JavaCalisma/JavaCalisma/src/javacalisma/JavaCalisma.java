/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacalisma;

/**
 *
 * @author burak
 */
public class JavaCalisma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Java Calisma Application!");
        
        //reverseString("Thecodeprogram");
        //checkWordsAnagram("burak", "kaub");
        //findDublicateCharacters("Thecodeprogram");
        //findNonRepeatedChars("Thecodeprogram");
        //findNonRepeatedChars_2("Thecodeprogram");
        //findFirstDublicatedChar("abcdcb");
        
        
        //permutationListOfString("abcd"); // gun icinde buna caliss
        
        //findSmallestandBiggestInArray();
        //findMissingNumbersInArray();
        
        //selectionSortImplemention();
        
        findOddTimesUsedNumberInArray();
        
        
    }
    
    
    public static void reverseString(String word){
        //First define the output variable
        String output = "";
        //then start to add char by char to output variable
        for(int i=word.length()-1; i>=0; i--){
            output += word.charAt(i);
        }
        System.out.println("Reversed word is : " + output);
    }
      
    public static void checkWordsAnagram(String word1, String word2){
    
        //define he return variable
        boolean isAnagram = true;
        
        //First check the words for same length
        boolean isSameLength = word1.length() == word2.length();
        
        //first check the lengths
        if(isSameLength) {
            //and check the characters for equality
            for(int i = 0; i< word1.length(); i++){
                char ch = word1.charAt(i);
                if(word2.indexOf(ch) < 0){
                    isAnagram = false;
                    break;
                }
            }
        }
        else{
            isAnagram = false;
        }
        if(isAnagram){
            System.out.println("Words are anagram.");
        }
        else{
            System.out.println("Words are NOT Anagram!");
        }
    }
    
    public static void findDublicateCharacters(String word){
        
        //define output variable
        String dublicatedChars = "";
        
        //it will check all chars
        for(int i=0; i<word.length(); i++){
            char selectedChar = word.charAt(i);
            //control the selected char
            for(int j=i+1; j<word.length(); j++){
                //if selected char is dublicated and did not find add it to list
                if(selectedChar == word.charAt(j) && dublicatedChars.indexOf(selectedChar) < 0 ){
                    dublicatedChars += selectedChar + ", ";
                }
            }
        }
        
        if(dublicatedChars.length()>0) {
            System.out.println("Below list you can find the dublicated chars.");
            System.out.println("" + dublicatedChars);
        }
        else{
            System.out.println("Words has no dublicated chars.");
        }
        
    }
    
    public static void findNonRepeatedChars(String word){
        //define the output
        String output = "";
        //define a flag to specify the repedition state
        boolean isRepedated = false;
        
        for(int i=0;i<word.length(); i++){
            //first get the char at index
            char selectedChar = word.charAt(i);
            //assume as non repedated before to start control
            isRepedated = false;
            //start to contol the chars
            for(int j=i+1; j<word.length(); j++){
                if(selectedChar == word.charAt(j)){
                    //if it is repedated set flag as true
                    isRepedated = true;
                    break;
                }
            }
            //and add the output variable to show
            if(!isRepedated) output += selectedChar + ", ";
        }
        
        System.out.println("Below list you can find the non-repeated chars.");
        System.out.println("" + output);
    }
    
    public static void findNonRepeatedChars_2(String word){
        String output = "";
        for(int i=0; i<word.length(); i++){
            output += output.indexOf(word.charAt(i)) < 0 ? word.charAt(i) + ", " : "";
        }
        
        System.out.println("Below list you can find the non-repeated chars.");
        System.out.println("" + output);
    }
    
    public static void findFirstDublicatedChar(String word){
        //Define the initial variables
        String firstDublicatedChar = "";
        char selectedChar;
        int selectedIndex = word.length();
        
        for(int i=0; i<word.length(); i++){
            //set the current char 
            selectedChar = word.charAt(i);
            //control all of chars
            for(int j=i+1; j<word.length(); j++){
                //if selected char found again with less index set it as first dublicated
                //and set the index as minimum index
                if(selectedChar == word.charAt(j) && j < selectedIndex){
                    firstDublicatedChar = selectedChar + "";
                    selectedIndex = j;
                }
            }
        }
        System.out.println("Below you can find the first repedated char.");
        System.out.println("" + firstDublicatedChar);
    }
    
    public static void permutationListOfString(String word){
        
        String permutationList = "";
        //The pointer for the selected char which will be moved in string
        String permPointer = "x";
        for(int i=0; i<word.length(); i++){
            //first set the moving part, transact one by one at every selection
            String permWord = word.substring(i, word.length());
            //and set the pointer of the selected part
            String temp = word.replace(permWord, permPointer);
            //Here we are going to move chars 
            for(int j=i; j<temp.length();j++){
                permutationList += temp.charAt(temp.length()-1) + temp.substring(0, temp.length()-1) + " ";
            }
            

        }
        
        System.out.println("Below you can find the permutation word lsit :");
        System.out.println("" + permutationList);
        
    
    }
    
    public static void findSmallestandBiggestInArray(){
    
        //define un-ordered array
        int[] array = {4, 3, 5, 8, 2, 9, 11, 20, 15};
        int smallest = array[0], biggest = array[0];
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array.length; j++)
            {
                //control the arrays
                smallest = smallest < array[j] ? smallest : array[j];
                biggest = biggest > array[j] ?  biggest : array[j];
            }
        }
        System.out.println("Smallest and biggest values are :" + smallest + " and " + biggest );
    }
    
    public static void findMissingNumbersInArray(){
        //define un-ordered array which has mising numbers
        int[] array = {4, 3, 5, 1, 2, 7, 10};
        String missingNumbers = "";
        
        //first we need to find biggest value
        //because we do not know how many number is missing
        int biggestValue = array[0];
        for(int i=0; i<array.length; i++){
            biggestValue = biggestValue < array[i] ? array[i] : biggestValue; 
        }
        
        boolean isMissing = true;
        //we assume numbers will start from 1
        outerLoop:
        for(int i=1; i<biggestValue; i++){
            isMissing = true;
            //index of is not exist in standrt array so we will use for again
            for(int j =0; j<array.length; j++){
                if(i == array[j]) // means not missing
                {
                    isMissing = false;
                }
            }
            missingNumbers += isMissing ? i + ", " : "";
        }
        
        System.out.println("Missing value list :" + missingNumbers  );
    }
    
    public static void selectionSortImplemention(){
        //define an un-odered array
        int[] array = {4, 3, 5, 1, 2, 6, 7};
        int min_index = -1;
        
        //check all indexex for being small
        for(int i=0; i<array.length; i++){
            //keep the minimum index
            min_index = i;
            //start to control from next element of array
            //because we have ordered them from begining of array
            for(int j=i+1; j<array.length; j++){
                if(array[j] < array[min_index]) min_index = j;
            }
            //to prevent losing the data we will use a variable
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
        
        System.out.println("You can see the sorted aray below :" );
        for(int i=0; i< array.length; i++){
            System.out.println(array[i]);
        }
    }
    
    public static void findOddTimesUsedNumberInArray(){
        /*
        You are given a array of integer. All numbers occur even number of times except one. 
        You need to find the number which occurs odd number of time. 
        You need to solve it with o(n) time complexity and o(1) space complexity.
        */
        
        //Define an array which described above
        int array[] = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
        String oddTimesUsedNumber = "";
        
        for(int i=0; i<array.length; i++){
            int counter = 0;
            int selectedNumber = array[i];
            for(int j=0; j<array.length; j++){
                if(selectedNumber == array[j]) counter++;
            }
            
            if(counter % 2 == 1) {
                oddTimesUsedNumber += selectedNumber + "";
                break;
            }
        }
        
        System.out.println("Odd times used number :" + oddTimesUsedNumber  );
        
    }
    
    
    
}
