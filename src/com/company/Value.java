package com.company;

public class Value {
    private String original;
    private String translate;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
    public Value(String original, String translate){
        this.original = original;
        this.translate = translate;
    }
}
