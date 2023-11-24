package zad3;

import java.util.Arrays;

public class Anagram {
        private String text;
        private String sortedText;

    public Anagram(String text) {
        this.text = text;
        this.sortedText = sortWord(text);
    }

    private String sortWord(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public String getText() {
        return text;
    }

    public String getSortedText() {
        return sortedText;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSortedText(String sortedText) {
        this.sortedText = sortedText;
    }

    @Override
    public String toString() {
        return text;
    }
}
