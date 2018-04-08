package com.khoben.bdd.tests;

import cucumber.api.PendingException;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;

import java.util.List;

public class MyStepsDef {
    @Дано("^на выбор буквы$")
    public void на_выбор_буквы(List<String> arg1) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc).
        // Field names for YourType must match the column names in
        // your feature file (except for spaces and capitalization).
        throw new PendingException();
    }

    @Когда("^пользователь выбрал букву А$")
    public void пользователь_выбрал_букву_А() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^на выбор остается$")
    public void на_выбор_остается(List<String> arg1)  {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc).
        // Field names for YourType must match the column names in
        // your feature file (except for spaces and capitalization).
        throw new PendingException();
    }

    @Когда("^пользователь выбрал букву A$")
    public void пользователь_выбрал_букву_A() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Тогда("^появляется предупреждение \"([^\"]*)\"$")
    public void появляется_предупреждение(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
