package com.ozanaydogan.core.randomnumber;

import java.util.Random;

public class RandomNumberGenerator {

    public static Random r = new Random();
    public  static int low = 0;
    public static int  high = 2000;

    public static Integer createRandomNumber(){
        return r.nextInt(high-low) + low;
    }

}
