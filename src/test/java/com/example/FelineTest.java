package com.example;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class FelineTest {
    @Test
    public void testEatMeatHerbivore() throws Exception{
        Animal animal = new Animal();
        String animalKind = "Травоядное";
        List<String> expectedHerbivoreFood = new ArrayList<>();
        expectedHerbivoreFood.add("Трава");
        expectedHerbivoreFood.add("Различные растения");
        Assert.assertEquals(expectedHerbivoreFood,animal.getFood(animalKind));

    }
    @Test
    public void testEatMeatPredator() throws Exception{
        Animal animal = new Animal();
        String animalKind = "Хищник";
        List<String> expectedPredatorFood = new ArrayList<>();
        expectedPredatorFood.add("Животные");
        expectedPredatorFood.add("Птицы");
        expectedPredatorFood.add("Рыба");
        Assert.assertEquals(expectedPredatorFood,animal.getFood(animalKind));

    }

    @Test
    public void testEatMeatException() throws Exception{
        Animal animal = new Animal();
        String animalKindException = "любая строка";
        try{
            animal.getFood(animalKindException);
        } catch(Exception exception) {
            String textException = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
            Assert.assertEquals(textException, exception.getMessage());
        }



    }
    @Test
    public void testGetFamilyReceiveFeline() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        Assert.assertEquals("Кошачьи", family);
    }
    @Test
    public void testGetKittensReceiveOne() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();
        Assert.assertEquals(1, kittens);
    }

}