package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionTestParameterized {
    private String sex;
    private boolean hasMane;

    public LionTestParameterized(String sex, boolean hasMane) throws Exception {
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

}
