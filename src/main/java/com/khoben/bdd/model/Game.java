package com.khoben.bdd.model;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Game {
    private List<String> avLetters;
    private HashMap<String, String> rawWords;
    private List<Word> words;
    private Word curWord;
    private int curStepCost;
    private int totalScore;
    private final List<Character> alphabet = "абвгдеёжзийклмнопрстуфхчцьыъэюя".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    private final List<Integer> scores = new ArrayList<>(){
        {
            add(10);
            add(100);
            add(300);
            add(500);
            add(1000);
            add(2000);
        }

    };

    public int generateRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Game(){
        avLetters = new ArrayList<>();
        rawWords = new HashMap<>();
        words = new ArrayList<>();
        loadGame();
    }

    public void loadGame(){
        totalScore = 0;
        setAvLetters(alphabet.stream().map(Object::toString)
                .collect(Collectors.toList()));

        loadFromFile("words.csv");
        loadWordObjects();
        selectCurWord();
        selectNewCost();
    }

    private void selectCurWord() {
        curWord = words.get(generateRandomInt(0, words.size() - 1));
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

    public void loadWordObjects() {
        words.clear();
        for (Map.Entry<String, String> word : rawWords.entrySet()) {
            words.add(new Word(word.getKey(),word.getValue()));
        }
    }

    public List<Word> getWordObjects() {
        return words;
    }

    public void selectNewCost() {
        curStepCost = scores.get(generateRandomInt(0, scores.size() - 1));
    }
}
