import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.POS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WordNetTest {
    public static void main(String[] args){

        Dictionar dict = new Dictionar();

        String concept1="man";
        if(dict.isWord(concept1)){
            ArrayList<String> sinonime= null;
            try {
                sinonime = (ArrayList<String>) dict.synonyms(POS.NOUN,concept1,10);
            } catch (JWNLException e) {
                e.printStackTrace();
            }
            System.out.println("Synonyms for "+concept1+":");
            System.out.println(sinonime);
        }
        String concept2="small";
        if(dict.isWord(concept2)){
            ArrayList<String> sinonime= null;
            ArrayList<String> antonime= null;
            try {
                sinonime = (ArrayList<String>) dict.synonyms(POS.ADJECTIVE,concept2,7);
                antonime = (ArrayList<String>) dict.antonyms(POS.ADJECTIVE,concept2);
            } catch (JWNLException e) {
                e.printStackTrace();
            }
            System.out.println("Synonyms for "+concept2+":");
            System.out.println(sinonime);
            System.out.println("Antonyms for "+concept2+":");
            System.out.println(antonime);
        }

    }
}
