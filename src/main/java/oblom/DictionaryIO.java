package oblom;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DictionaryIO {
    private String validCheckString;
    private int valueLength;
    private String pathToDictionary;

    public void setPathToDictionary(String pathToDictionary) {
        this.pathToDictionary = pathToDictionary;
    }

    public void setValidCheckString(String validCheckString) {
        this.validCheckString = validCheckString;
    }

    public void setValueLength(int valueLength) {
        this.valueLength = valueLength;
    }

    public boolean writeToDictionary(ValueModel value) throws IOException {
        String writedValue = value.getOriginal() + " - " + value.getTranslate() + "\n";
        FileWriter outputStream = new FileWriter(pathToDictionary, true);
        if (findStringFromDictionary(writedValue.substring(0, valueLength)) == null && value.getOriginal().matches(validCheckString)) {
            outputStream.write(writedValue);
            outputStream.close();
            return true;
        }
        return false;
    }

    public StringBuilder readAllFromDictionary() throws IOException {
        StringBuilder dictionaryString = new StringBuilder();
        int writedChar;
        FileReader reader;
        try {
            reader = new FileReader(pathToDictionary);
            while ((writedChar = reader.read()) != -1) dictionaryString.append((char) writedChar);
            reader.close();
        }
        catch (FileNotFoundException e){
            new FileWriter(pathToDictionary);
        }
        return dictionaryString;
    }

    public String findStringFromDictionary(String findedkey) throws IOException {
        String readedLine;
        BufferedReader reader = new BufferedReader(new FileReader(pathToDictionary));
        while ((readedLine = reader.readLine()) != null) {
            if (!readedLine.equals("") && readedLine.substring(0, valueLength).equals(findedkey)) return readedLine;
        }
        reader.close();
        return null;
    }

    public void deleteStringFromDictionary(String deletedkey) throws IOException {
        StringBuilder returnedDictionary = new StringBuilder();
        String[] dictionaryArray = readAllFromDictionary().toString().split("\\n");
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(pathToDictionary));
        List<String> dictionaryList = new LinkedList<>(Arrays.asList(dictionaryArray));
        dictionaryList.remove("");
        for (String value : dictionaryList) {
            if (!value.substring(0, valueLength).equals(deletedkey.substring(0, valueLength)))
                returnedDictionary.append(value).append("\n");
        }
        outputStream.write(String.valueOf(returnedDictionary));
        outputStream.close();
    }
}
