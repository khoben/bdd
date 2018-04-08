package com.khoben.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src//main//resources//features"},
        glue = "com.khoben.bdd.tests"
)
public class CucuRunner {
}