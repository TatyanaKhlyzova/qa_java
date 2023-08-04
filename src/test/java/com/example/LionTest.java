package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Test
    public void hasManeException() throws Exception {

        try { Lion lion = new Lion("любое другое значение, отличное от самец или самка");
            Assert.fail("У нас баг - исключение не работает");
        } catch(Exception exception){
            String expectedException = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(expectedException, exception.getMessage());
        }

    }
    @Test
    public void getFoodReceivePredatorFood() throws Exception{
        Feline feline = new Feline();
        Lion lion = new Lion(feline);
        Arrays Array = null;
        List expectedPredatorFood = new ArrayList<>(Array.asList("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(expectedPredatorFood,lion.getFood());

    }
    @Mock
    Feline feline;
    @Test
    public void getKittensReceiveOne() {
        Lion lion = new Lion (feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int kittensLion = lion.getKittens();
        Assert.assertEquals(1, kittensLion);
    }

    @Test
    public void shouldUseGetFood() throws Exception {
        Lion lion = new Lion(feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

}



