package com.example;

import java.util.List;

public class Feline extends Animal implements Predator, Kittens {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }
    @Override
    public int getKittens() {
        return 1;
    }


}
