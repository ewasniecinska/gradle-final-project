package com.popular.android.java_lib;

import java.util.ArrayList;
import java.util.Random;

public class JokeGenerator {
    public String getJoke(){

        ArrayList<String> stringArray = new ArrayList();
        stringArray.add("What is the difference between a snowman and a snowwoman? Snowballs.");
        int rnd = new Random().nextInt(stringArray.size());
        return stringArray.get(rnd);

    }
}
