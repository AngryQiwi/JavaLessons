package oblom;

public class dictWordModel {
    public String key_word;
    public String value_word;
    public String dictionary;

    public String getKey_word() {
        return key_word;
    }
    public String getValue_word() {
        return value_word;
    }

    public String getDictionary() {
        return dictionary;
    }

    public void setKey_word(String key_word) {
        this.key_word = key_word;
    }
    public void setValue_word(String value_word) {
        this.value_word = value_word;
    }

    public void setDictionary(String dictionary) {
        this.dictionary = dictionary;
    }

    public dictWordModel(String key_word, String value_word, String dictionary) {
        this.key_word = key_word;
        this.value_word = value_word;
        this.dictionary = dictionary;
    }
}
