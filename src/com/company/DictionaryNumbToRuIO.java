package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DictionaryNumbToRuIO extends DictionaryIO{
    public DictionaryNumbToRuIO(){
        super.setPathToDict("resources/DictionaryNumbToRu.txt");
    }

    public boolean writeToDictionary(Value value) throws IOException {
        String writedValue = value.getOriginal()+" - "+value.getTranslate()+"\n";
        FileWriter outputStream = new FileWriter(getPathToDict(), true);
        if(findStringFromDictionary(writedValue.substring(0, 6)) == null && valueCheck(writedValue.substring(0, 6))) {
            outputStream.write(writedValue);
            outputStream.close();
            return true;
        }
        return false;
    }
    boolean valueCheck(String value){
        char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] valueChars = value.toCharArray();
        Arrays.sort(digits);
        for (int i = 0;i < 6; i++) {
            if(i<5) {
                if (Arrays.binarySearch(digits, valueChars[i]) < 0) return false;
            }
            else{
                if (valueChars[i] != ' ') return false;
            }
        }
        return true;
    }
}
