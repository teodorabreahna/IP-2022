import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.*;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;

import java.io.InputStream;
import java.util.ArrayList;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.PointerTarget;
import net.didion.jwnl.data.PointerUtils;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.data.list.PointerTargetNode;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;


public class Dictionar {
    static Dictionary dictionary;
    public Dictionar(){
        try{
            JWNL.initialize(new FileInputStream(".idea/properties.xml"));
            dictionary = Dictionary.getInstance();
        }
        catch (JWNLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isWord(String word) {
        if (dictionary == null) return false;

        IndexWordSet indexWordSet = null;
        try {
            indexWordSet = dictionary.lookupAllIndexWords(word);
        } catch (JWNLException e) {
            e.printStackTrace();
        }
        return indexWordSet.size() > 0;
    }


    public List<String> synonyms(POS pos, String word, int nr) throws JWNLException {
        List<String> synonyms = new ArrayList<>();
        IndexWord indexWord = dictionary.getIndexWord(pos, word);
        Synset[] synsets = indexWord.getSenses();
        for (int i = 0; i < Math.min(nr, synsets.length); i++) {
            for (Word itr : synsets[i].getWords()) {
                String lemma = itr.getLemma();
                if (!lemma.equals(word)) {
                    synonyms.add(lemma);
                }
            }
        }
        return synonyms;
    }

    public List<String> antonyms(POS pos, String word) throws JWNLException {
        List<String> antonyms = new ArrayList<>();
        IndexWord indexWord = dictionary.getIndexWord(pos, word);
        Synset synsets = indexWord.getSense(1);
        PointerTargetNodeList target = PointerUtils.getInstance().getAntonyms(synsets);
        for (Object aTarget : target) {
            Synset s = ((PointerTargetNode) aTarget).getSynset();
            for (Word itr : synsets.getWords()) {
                String lemma = itr.getLemma();
                if(lemma!=word) {
                    antonyms.add(lemma);
                }
            }
        }
        return antonyms;
    }



    public void hypernyms() throws JWNLException {
        IndexWord word= null;
            word = dictionary.getInstance().getIndexWord(POS.NOUN, "fork");
        PointerTargetNodeList hypernyms = null;
            hypernyms = PointerUtils.getInstance().getDirectHypernyms(word.getSense(1));
        System.out.println("The hypernyms of " + word.getLemma() + "are:");
            hypernyms.print();
    }



}
