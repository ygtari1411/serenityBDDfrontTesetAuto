package com.advyteam.weavin.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        plugin = {"json:target/reports/cucumber.json"},
        glue = "com.advyteam.weavin")
public class Runner {}
