package com.khoben.bdd.tests;

import com.khoben.bdd.model.Game;
import cucumber.api.PendingException;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.apache.commons.collections.CollectionUtils;

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
    }

    @Тогда("^появляется предупреждение \"([^\"]*)\"$")
    public void появляется_предупреждение(String arg1) {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}
