package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionTestParameterized {
    private String sex;
    private boolean hasMane;
    static Feline feline;

    public LionTestParameterized(String sex, boolean hasMane, Feline feline) throws Exception {
        this.sex = sex;
        this.hasMane = hasMane;
        this.feline = feline;
    }
    @Parameterized.Parameters
    public static Object[][] hasMane(){
        return new Object[][] {
                {"Самец", true, feline},
                {"Самка", false, feline},
        };
    }
    @Test
    public void maleShouldHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean result = lion.doesHaveMane();
        Assert.assertEquals(hasMane, result);
    }

}
