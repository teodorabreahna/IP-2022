
package com.mycompany.jsonfile;

/**
 *
 * @author Florin
 */
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException{
    
        Concept c1 = new Concept("concept1","descriere concept1");
        Concept c2 = new Concept("concept2","descriere concept2");
        List<String> l1 = new ArrayList<>();
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
        l3.add("cuvant e");
        Output o = new Output(c1,c2,l1,l2,l3);
        Save save = new Save(o,"C:\\Users\\Florin\\Desktop\\java\\jsontest.json");
        save.execute1();

    }
}
