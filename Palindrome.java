package edu.macalester.comp124.palindrome;
import java.util.Scanner;
import acm.program.*;

public class Palindrome extends ConsoleProgram {


    public void run() {

        println("Enter word that might be a palindrome (or quit to stop)?");
        String s = readLine();
        while (!s.equals("Stop")) {
            if (isPalindrome(s)) {
                println("It is a palindrome.");
            } else {
                println("It is not a palindrome.");
            }
            s = readLine();
        }
    }

    public boolean isPalindrome (String pal) {

        println("Enter word that might be a palindrome (or quit to stop)?" + pal);

        StringBuilder pali = new StringBuilder(); //new StringBuilder object

        for(int i = 0; i < pal.length(); i++){
            char ch = pal.charAt(i);              //returns char value at spot indicated by index variable

            if(Character.isLetter(ch)){           //takes char value, returns boolean value
                pali.append(ch);                  //adds char value to StringBuilder
                }
            }


        //Convert StringBuilder pali to a String object
        //StringBuilder pali2 contains reversed pali String

        String original = pali.toString().toLowerCase();
        StringBuilder pali2 = new StringBuilder(pali.reverse());
        String reverse = pali2.toString().toLowerCase();
        println(original);
        println(reverse);


        if (original.equals(reverse)) {
            return true;
        } else {
            return false;

            }

        }
    }







