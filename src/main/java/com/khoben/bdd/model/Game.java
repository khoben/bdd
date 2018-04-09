package com.khoben.bdd.model;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Game {
    private List<String> avLetters;
    private HashMap<String, String> rawWords;

    public Game(){
        avLetters = new ArrayList<>();
        rawWords = new HashMap<>();
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
        rawWords.clear();

        String cvsSplitBy = "\\|";

        ClassLoader classLoader = getClass().getClassLoader();
        File file;
        try {
            file = new File(classLoader.getResource(filename).getFile());

            try (Scanner scanner = new Scanner(file)) {

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] data = line.split(cvsSplitBy); //size=2
                    rawWords.put(data[0], data[1]);
                }

                scanner.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public HashMap<String,String> getRawWords() {
        return rawWords;
    }
}
