package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class CatTest {

    @Test
    public void getSoundReceiveMeow() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }
    @Test
    public void getFoodReceivePredatorFood() throws Exception{
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        List<String> felineFood = cat.getFood();
        List<String> expectedFelineFood = new ArrayList<>();
        expectedFelineFood.add("Животные");
        expectedFelineFood.add("Птицы");
        expectedFelineFood.add("Рыба");
        Assert.assertEquals(expectedFelineFood,felineFood);
        }

    }

