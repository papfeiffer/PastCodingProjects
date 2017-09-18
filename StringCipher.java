package stringPractice;

import acm.program.*;

/**
 * Created by paigepfeiffer on 2/12/16.
 */
public class StringCipher extends GraphicsProgram {

    private int SPACE_SHIFT_LEFT_OR_RIGHT = 3;


    public StringCipher(int SPACE_SHIFT_LEFT_OR_RIGHT) {
        this.SPACE_SHIFT_LEFT_OR_RIGHT = SPACE_SHIFT_LEFT_OR_RIGHT;

    }

    public String encode(String s) {

        //this method takes plain String and turns it into Caesar letters
        String encodedString = "";

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);

            if (Character.isUpperCase(c)) {
                c = c - SPACE_SHIFT_LEFT_OR_RIGHT;

                if (c < 'A')
                    c = c + 26;

            } else if (Character.isLowerCase(c)) {
                c = c - SPACE_SHIFT_LEFT_OR_RIGHT;

                if (c < 'a')
                    c = c + 26;
            }

            encodedString += (char) c; //converts c to char value
        }
        return encodedString;

    }


    public String decode(String encodedString) {

        //this method takes encoded string and makes it "normal"
        encode(encodedString);
        String decoded = "";
        for(int i = 0; i < encodedString.length(); i++ ) {
            int c = encodedString.charAt(i);

            if (Character.isUpperCase(c)) {
                c = c + SPACE_SHIFT_LEFT_OR_RIGHT;

                if (c > 'Z')
                    c = c - 26;

            } else if (Character.isLowerCase(c)) {
                c = c + SPACE_SHIFT_LEFT_OR_RIGHT;

                if (c > 'z')
                    c = c - 26;
            }

            decoded += (char) c;
            }
            return decoded;

        }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof StringCipher) {
            StringCipher stringcipher = (StringCipher) obj;
            result = (this.SPACE_SHIFT_LEFT_OR_RIGHT == stringcipher.SPACE_SHIFT_LEFT_OR_RIGHT);
        }
        return result;
    }

    public int getSPACE_SHIFT_LEFT_OR_RIGHT() {
        return SPACE_SHIFT_LEFT_OR_RIGHT;
    }

}
