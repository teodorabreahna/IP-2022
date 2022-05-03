package com.mycompany.jsonfile;

import java.util.HashMap;

public class Frequency {

    static String[] findWord(String[] arr) {
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.containsKey(arr[i])) {

                hs.put(arr[i], hs.get(arr[i]) + 1);

            } else {
                hs.put(arr[i], 1);
            }
        }
        return arr;
    }
}
