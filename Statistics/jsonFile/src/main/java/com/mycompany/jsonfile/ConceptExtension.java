package com.mycompany.jsonfile;

import java.util.*;

import static java.util.stream.Collectors.*;
public class ConceptExtension {
    private String concept;
    private LinkedHashMap<String,Integer> topWords;

    public ConceptExtension(String concept, LinkedHashMap<String, Integer> topWords) {
        this.concept = concept;
        this.topWords = topWords;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public HashMap<String, Integer> getTopWords() {
        return topWords;
    }

    public void setTopWords(LinkedHashMap<String, Integer> topWords) {
        this.topWords = topWords;
    }

    public void HashMapSort(){
        List<Map.Entry<String, Integer> > list = new ArrayList<>(topWords.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        topWords = topWords
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public List<String> similarities(ConceptExtension concept2){
        Map<String, Integer> topWords1 =topWords;
        Map<String, Integer> topWords2 =concept2.getTopWords();
        List<String> similar =new ArrayList<>();
        for(String key1: topWords1.keySet()){
            if(similar.size()>20){
                break;
            }
            for(String key2: topWords2.keySet()){
                if(key1.equals(key2)){
                    similar.add(key1);
                    break;
                }
            }
        }
        return similar;
    }

    public List<String> differences(ConceptExtension concept2){
        Map<String, Integer> topWords1 =topWords;
        Map<String, Integer> topWords2 =concept2.getTopWords();
        List<String> diff =new ArrayList<>();
        int ok;
        for(String key1: topWords1.keySet()){
            ok=0;
            if(diff.size()>20){
                break;
            }
            for(String key2: topWords2.keySet()){
                if(key1.equals(key2)){
                    ok=1;
                    break;
                }
            }
            if(ok==0){
                diff.add(key1);
            }
        }
        return diff;
    }
}
