package com.khoben.bdd.tests;

import com.khoben.bdd.model.Game;
import com.khoben.bdd.model.Word;
import com.khoben.bdd.view.ViewController;
import cucumber.api.PendingException;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.apache.commons.collections.CollectionUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MyStepsDef {
    private Game game;
    private ArrayList<String> avLetters;
    private String selectedLetter;
    @Дано("^При игре в Поле чудес даются на выбор буквы$")
    public void при_игре_в_Поле_чудес_даются_на_выбор_буквы(List<String> arg1) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc).
        // Field names for YourType must match the column names in
        // your feature file (except for spaces and capitalization).
        //throw new PendingException();
        this.game = new Game();
        this.game.setAvLetters(new ArrayList<>(arg1));
    }

    @Когда("^пользователь выбрал букву \"([^\"]*)\"$")
    public void пользователь_выбрал_букву(String arg1) {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        this.selectedLetter = arg1;
    }

    @Тогда("^на выбор остается$")
    public void на_выбор_остается(List<String> arg1) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc).
        // Field names for YourType must match the column names in
        // your feature file (except for spaces and capitalization).
//        throw new PendingException();
        this.game.deleteFromAvLetters(this.selectedLetter);
        assertTrue(CollectionUtils.isEqualCollection(this.game.getAvLetters(), arg1));
    }

    @Дано("^на выбор буквы$")
    public void на_выбор_буквы(List<String> arg1) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc).
        // Field names for YourType must match the column names in
        // your feature file (except for spaces and capitalization).
//        throw new PendingException();
        this.game = new Game();
        this.game.setAvLetters(new ArrayList<>(arg1));
    }

    @Тогда("^появляется предупреждение \"([^\"]*)\"$")
    public void появляется_предупреждение(String arg1) {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        System.out.println(arg1);
        ViewController.makeMessageBox(null, arg1, "Внимание",JOptionPane.WARNING_MESSAGE);
    }

    /* -------------------------------------------------------------------------- */

    private String filename;

    @Дано("^\"([^\"]*)\" -- имя файла со словами$")
    public void имя_файла_со_словами(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
        this.filename = arg1;
    }

    @Когда("^игра загружена$")
    public void игра_загружена() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        this.game = new Game();
    }

    @Тогда("^слова из файла сохраняются в памяти$")
    public void слова_из_файла_сохраняются_в_памяти() {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        this.game.loadFromFile(this.filename);
    }

    @Тогда("^первым словом в массиве слов будет$")
    public void первым_словом_в_массиве_слов_будет(List<String> arg1) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc).
        // Field names for YourType must match the column names in
        // your feature file (except for spaces and capitalization).
//        throw new PendingException();
        ArrayList<String> expectedWord = new ArrayList<>(arg1);
        String actualDescr  = this.game.getRawWords().get(expectedWord.get(0));
        String expectedDescr = "Так в старину называли сторожа городских ворот";
        Assert.assertEquals(expectedDescr, actualDescr);
    }

    @Тогда("^из массива слово-описание создастся массив объектов слов$")
    public void изМассиваСловоОписаниеСоздастсяМассивОбъектовСлов() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Word expected = new Word();
        Assert.assertNotNull(expected);
    }
}
