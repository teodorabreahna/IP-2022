package IPCrawlerDemo.DemoCrawler.Services;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Concept {
    private String concept;
    private LinkedHashMap<String,Integer> topWords;
    private String relevant;

    public Concept(String concept, LinkedHashMap<String, Integer> topWords) {
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

    public String setRelevant(){
        int contor=0;
        /*
        StringBuilder sb1 = new StringBuilder("chart?bkg=white&c={ type: 'bar', data: { labels: [");
        StringBuilder sb2 = new StringBuilder();
         */
        relevant = new String();
        String s = new String();
        relevant = relevant +"chart?bkg=white&c={ type: 'bar', data: { labels: [";
        while (contor<=4){
            for(Map.Entry<String,Integer> entry: topWords.entrySet()){
                if(contor<=3){
                    relevant = relevant +"'"+entry.getKey()+"', ";
                    s=s+entry.getValue()+", ";
                }
                else if(contor==4){
                    relevant= relevant+"'"+entry.getKey()+"'";
                    s=s+entry.getValue();
                }
                contor++;
            }
        }

        relevant=relevant+"], datasets: [{ label: 'Users', data: ["+s+"] }] }}";
        return relevant;
    }

    public List<String> similarities(Concept concept2){
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

    public List<String> commonSynonyms(String concept1,Set<String> sin1, String concept2, Set<String> sin2){
        List<String> result=new ArrayList<>();
        for (String it1:sin1) {
            for (String it2:sin2) {
                if(it1.equals(it2)){
                    result.add(it1);
                    break;
                }
            }
        }
        for (String it2:sin2) {
            if(concept1.equals(it2)){
                result.add(concept1);
                break;
            }
        }
        for (String it1:sin1) {
            if(concept2.equals(it1)){
                result.add(concept2);
                break;
            }
        }
        return result;
    }

    public List<String> diffBetweenSinAndAnt(String con1,Set<String> sin1,Set<String> ant2){
        List<String> result=new ArrayList<>();
        for (String it1:sin1) {
            for (String it2:ant2) {
                if(it1.equals(it2)){
                    result.add(it1);
                    break;
                }
            }
        }
        for(String it2:ant2){
            if(con1.equals(it2)){
                result.add(it2);
                break;
            }
        }
        return result;
    }

    public List<String> differences(Concept concept2){
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