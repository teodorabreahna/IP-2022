
package com.mycompany.jsonfile;

/**
 *
 * @author Florin, Andrei, Alisa
 *
 */

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

    /**
     * Funtia primeste ca parametru un array de cuvinte pentru care calculeaza frecventa aparitiilor.
     * @param arr un array de string-uri
     * @return un HashMap cu fiecare cuvant si frecventa lui
     */
    static LinkedHashMap<String, Integer> frequency(String[] arr) {

        LinkedHashMap<String, Integer> hs = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < arr.length; i++)
        {
            if (hs.containsKey(arr[i])) {
                hs.put(arr[i], hs.get(arr[i]) + 1);
            } else {
                hs.put(arr[i], 1);
            }
        }
        return hs;
    }

    public static void main(String[] args){

        /*LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
        hm.put("reading", 15);
        hm.put("working", 11);
        hm.put("playing", 14);
        hm.put("traveling", 7);
        hm.put("singing", 2);
        hm.put("talking", 20);

        LinkedHashMap<String, Integer> hm1 = new LinkedHashMap<String, Integer>();
        hm1.put("cooking", 1);
        hm1.put("shopping", 11);
        hm1.put("reading", 9);
        hm1.put("running", 24);
        hm1.put("playing", 7);
        hm1.put("swimming", 6);*/

        String arr[] = { "dog", "dog", "dog", "dog", "man", "man", "man", "woman"};
        LinkedHashMap<String, Integer> hm = frequency(arr);

        String arr2[] = { "woman", "woman", "woman", "woman", "rain", "rain", "sun", "man"};
        LinkedHashMap<String, Integer> hm1 = frequency(arr2);

        ConceptExtension concept1=new ConceptExtension("primul", hm);
        ConceptExtension concept2=new ConceptExtension("alDoilea", hm1);

        concept1.HashMapSort();
        concept2.HashMapSort();

        System.out.println(concept1.getTopWords());
        System.out.println(concept2.getTopWords());
        System.out.println();

        List<String> similarities=concept1.similarities(concept2);
        System.out.println(similarities);
        System.out.println();
        List<String> diff1=concept1.differences(concept2);
        System.out.println(diff1);
        System.out.println();
        List<String> diff2=concept2.differences(concept1);
        System.out.println(diff2);

    
        Concept c1 = new Concept(concept1.getConcept(),"descriere concept1");
        Concept c2 = new Concept(concept2.getConcept(),"descriere concept2");
        /*List<String> l1 = new ArrayList<>();
        l1.add("cuvant a");
        l1.add("cuvant b");
        l1.add("cuvant c");
        l1.add("cuvant d");
        l1.add("cuvant e");
        List<String> l2 = new ArrayList<>();
        l2.add("cuvant a");
        l2.add("cuvant b");
        l2.add("cuvant c");
        l2.add("cuvant d");
        l2.add("cuvant e");
        List<String> l3 = new ArrayList<>();
        l3.add("cuvant a");
        l3.add("cuvant b");
        l3.add("cuvant c");
        l3.add("cuvant d");
        l3.add("cuvant e");*/
        Output o = new Output(c1,c2,similarities,diff1,diff2);
        Save save = new Save(o,"jsonTest.json");
        try {
            save.execute1();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
