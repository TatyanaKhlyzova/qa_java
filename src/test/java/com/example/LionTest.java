package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private String sex;
    private boolean hasMane;


    public LionTest(String sex, boolean hasMane) throws Exception {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] hasMane(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},

        };
    }
    @Test
    public void maleShouldHasMane() throws Exception {
        Lion lion = new Lion(sex);
        boolean result = lion.doesHaveMane();
        Assert.assertEquals(hasMane, result);
    }
    @Test
    public void testHasManeException() throws Exception {

        try { Lion lion = new Lion("любое другое значение, отличное от самец или самка");
        } catch(Exception exception){
            String expectedException = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(expectedException, exception.getMessage());
        }

    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetKittensReceiveOne() {
        Kittens kittens = Mockito.mock(Kittens.class);
        Lion lion = new Lion (kittens);
        Mockito.when(kittens.getKittens()).thenReturn(1);
        int kittensLion = lion.getKittens();
        Assert.assertEquals(1, kittensLion);
    }

    @Before
    public void initial() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void shouldUseGetFood() throws Exception {
        Lion lion = Mockito.mock(Lion.class);
        lion.getFood("Хищник");
        Mockito.verify(lion, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFood() throws Exception{
        Lion lion = new Lion("Самка");
        List<String> expectedPredatorFood = new ArrayList<>();
        expectedPredatorFood.add("Животные");
        expectedPredatorFood.add("Птицы");
        expectedPredatorFood.add("Рыба");
        Assert.assertEquals(expectedPredatorFood,lion.getFood());

    }

}



