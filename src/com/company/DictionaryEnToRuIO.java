package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DictionaryEnToRuIO extends DictionaryIO {
    public DictionaryEnToRuIO() {
        super.setPathToDict("resources/DictionaryEnToRu.txt");
    }

    public boolean writeToDictionary(Value value) throws IOException {
        String writedValue = value.getOriginal() + " - " + value.getTranslate() + "\n";
        FileWriter outputStream = new FileWriter(getPathToDict(), true);
        if (findStringFromDictionary(writedValue.substring(0, 6)) == null && valueCheck(writedValue.substring(0, 5))) {
            outputStream.write(writedValue);
            outputStream.close();
            return true;
        }
        return false;
    }

    boolean valueCheck(String value) {
        char[] digits = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] valueChars = value.toCharArray();
        Arrays.sort(digits);
        for (int i = 0;i < 5; i++) {
            if(i<4) {
                if (Arrays.binarySearch(digits, valueChars[i]) < 0) return false;
            }
            else{
                if (valueChars[i] != ' ') return false;
            }
        }
        return true;
    }
}
