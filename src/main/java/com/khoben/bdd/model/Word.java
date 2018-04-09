package com.khoben.bdd.model;

public class Word {

    private String word;
    private String descr;

    public Word(String word, String descr) {
        this.descr = descr;
        this.word = word;
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
}
