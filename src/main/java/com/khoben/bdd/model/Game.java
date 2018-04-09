package com.khoben.bdd.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Game {
    private List<String> avLetters;

    public Game(){
        avLetters = new ArrayList<>();
    }
    public List<String> getAvLetters() {
        return avLetters;
    }

    public void setAvLetters(List<String> avLetters) {
        this.avLetters = avLetters;
    }

    public void deleteFromAvLetters(String letter){
        avLetters.remove(letter);
    }

    public void loadFromFile(String filename) {
    }

    public HashMap<String,String> getRawWords() {

        HashMap<String, String> words = new HashMap<>(){
            {put("вратарь", "Так в старину называли сторожа городских ворот");}
        };
        return words;
    }
}
