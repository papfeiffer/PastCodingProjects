package edu.macalester.comp124.stringtransformer;


public class PigLatinizer extends StringTransformer {

    @Override
    public String transform(String s) {


        String ay = "ay";

        String printedWordConsonants = "";

        String dividedWord = " ";
        int endofWord = s.length();

        if (s.length() > 0) {
            for (int i = 0; i <= s.length(); i++) {

                char c = s.charAt(i);


                if (isConsonant(c)) {
                    printedWordConsonants += c;

                } else if (isVowel(s.charAt(0))) {
                    dividedWord += s.substring(0, endofWord) + "y";
                    break;
                } else if (isVowel(c)) {
                    dividedWord += s.substring(i, endofWord);
                    break;
                } else if (s.substring(0, endofWord) == printedWordConsonants) {
                    dividedWord = "";
                    break;
                }

            }
        }
        return dividedWord + printedWordConsonants + ay;

    }


    public static boolean isConsonant(char c) {
        String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        return cons.contains(Character.toString(c)); //contains method returns boolean value

    }

    public static boolean isVowel(char c) {
        String vowel = "aeiouAEIOU";
        return vowel.contains(Character.toString(c));
    }





    @Override
    public String toString() { return "All pig latinized"; }

}

