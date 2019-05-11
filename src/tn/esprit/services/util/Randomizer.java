/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;

import java.util.Random;

/**
 *
 * @author mdsaadlaoui
 */
public class Randomizer {

    /**
     *
     * @return
     */
    public static String randomStringGenerator() {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    /**
     *
     * @param maxValue
     * @return
     */
    public static Integer randomIntgeger(Integer maxValue){
        Random RND = new Random();
        return  RND.nextInt(maxValue);
    }

}
