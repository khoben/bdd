package com.khoben.bdd.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {

    private String word;
    private String descr;
    private List<Boolean> mask;

    public Word(String word, String descr) {
        this.descr = descr;
        this.word = word;
        this.mask = new ArrayList<>(Collections.nCopies(word.length(), false));
    }

    public Word() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj==null || obj.getClass()!=this.getClass()) return false;
        if (((Word)obj).word.equals(this.word) && ((Word)obj).descr.equals(this.descr)) return true;
        else
            return false;
    }

    public int checkLetter(String selectedLetter) {
        int multiply = 0;
        for(int i=0; i<word.length();i++){
            if (Character.toString(word.charAt(i)).equals(selectedLetter.toLowerCase())){
                mask.set(i, true);
                multiply++;
            }
        }
        return multiply;
    }

    public String getMask() {
        StringBuilder printableMask = new StringBuilder();
        for (int i=0; i<mask.size();i++) {
            if (!mask.get(i))
                printableMask.append("*");
            else
                printableMask.append(word.charAt(i));
        }
        return printableMask.toString();
    }

    public String getWord() {
        return word;
    }

    public String getDescr() {
        return descr;
    }
}
