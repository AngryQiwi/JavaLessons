package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class DictionaryIO {
    private String pathToDict;

    public String getPathToDict() {
        return pathToDict;
    }

    public void setPathToDict(String pathToDict) {
        this.pathToDict = pathToDict;
    }

    public boolean writeToDictionary(Value value) throws IOException {
        String writedValue = value.getOriginal() + " - " + value.getTranslate() + "\n";
        FileWriter outputStream = new FileWriter(pathToDict, true);
        if (findStringFromDictionary(writedValue.substring(0, 4)) == null) {
            outputStream.write(writedValue);
            outputStream.close();
            return true;
        }
        return false;
    }

    public StringBuilder readAllFromDictionary() throws IOException {
        StringBuilder dictionaryString = new StringBuilder();
        int writedChar;
        FileReader reader = new FileReader(pathToDict);
        while ((writedChar = reader.read()) != -1) dictionaryString.append((char) writedChar);
        reader.close();
        return dictionaryString;
    }

    public String findStringFromDictionary(String findedkey) throws IOException {
        String readedLine;
        BufferedReader reader = new BufferedReader(new FileReader(pathToDict));
        while ((readedLine = reader.readLine()) != null) {
            if (!readedLine.equals("") && readedLine.substring(0, 6).equals(findedkey)) return readedLine;
        }
        reader.close();
        return null;
    }

    public void deleteStringFromDictionary(String deletedkey) throws IOException {
        StringBuilder returnedDictionary = new StringBuilder();
        String[] dictionaryArray = readAllFromDictionary().toString().split("\\n");
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(pathToDict));
        List<String> dictionaryList = new LinkedList<>(Arrays.asList(dictionaryArray));
        dictionaryList.remove("");
        for (String value : dictionaryList) {
            if (!value.substring(0, 6).equals(deletedkey.substring(0, 6))) returnedDictionary.append(value).append("\n");
        }
        outputStream.write(String.valueOf(returnedDictionary));
        outputStream.close();
    }
}
