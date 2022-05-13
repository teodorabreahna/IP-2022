package IPStatisticsDemo.DemoStatistics.Services;

import IPStatisticsDemo.DemoStatistics.models.StatisticsInputObject;
import IPStatisticsDemo.DemoStatistics.models.StatisticsOutputObject;

import java.io.IOException;
import java.util.*;

public class StatisticsService {

    public StatisticsOutputObject processInfo(List<StatisticsInputObject> statisticsInputObject) {

        return doSomeStuff(statisticsInputObject.get(0), statisticsInputObject.get(1));
    }

    static LinkedHashMap<String, Integer> frequency(List<String> arr) {

        LinkedHashMap<String, Integer> hs = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < arr.size(); i++)
        {
            if (hs.containsKey(arr.get(i))) {
                hs.put(arr.get(i), hs.get(arr.get(i)) + 1);
            } else {
                hs.put(arr.get(i), 1);
            }
        }
        return hs;
    }

    private StatisticsOutputObject doSomeStuff(StatisticsInputObject info1, StatisticsInputObject info2)
    {
        //prelucrati si apelati api-urile etc

        List<String> finalList1 = new ArrayList<>();
        finalList1.addAll(info1.getAdjectives());
        finalList1.addAll(info1.getNouns());
        finalList1.addAll(info1.getVerbs());
        while (finalList1.remove("")) {
        }

        List<String> finalList2 = new ArrayList<>();
        finalList2.addAll(info2.getAdjectives());
        finalList2.addAll(info2.getNouns());
        finalList2.addAll(info2.getVerbs());
        while (finalList2.remove("")) {
        }

        LinkedHashMap<String, Integer> hm1 = frequency(finalList1);
        LinkedHashMap<String, Integer> hm2 = frequency(finalList2);

        Concept concept1 = new Concept(info1.getTopic(), hm1);
        Concept concept2 = new Concept(info2.getTopic(), hm2);

        concept1.HashMapSort();
        concept2.HashMapSort();

        Set<String> concept1Sin=new HashSet<>();
        Set<String> concept2Sin=new HashSet<>();
        try {
            concept1Sin=new DictionaryAccessPoint().getSynonyms(concept1.getConcept());
            concept2Sin=new DictionaryAccessPoint().getSynonyms(concept2.getConcept());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> similarities = concept1.commonSynonyms(concept1.getConcept(),concept1Sin,concept2.getConcept(),concept2Sin);
        List<String> commonWords = concept1.similarities(concept2);
        int nr=0;
        while(similarities.size()<20 && nr<commonWords.size()){
            similarities.add(commonWords.get(nr));
            nr++;
        }

        Set<String> concept1Antonyms= null;
        Set<String> concept2Antonyms= null;
        try {
            concept1Antonyms = new DictionaryAccessPoint().getAntonyms(concept1.getConcept());
            concept2Antonyms = new DictionaryAccessPoint().getAntonyms(concept2.getConcept());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> diff1 = concept1.diffBetweenSinAndAnt(concept1.getConcept(),concept1Sin,concept2Antonyms);
        List<String> differenceWords1 = concept1.differences(concept2);
        nr=0;
        while(diff1.size()<20 && nr<differenceWords1.size()){
            diff1.add(differenceWords1.get(nr));
            nr++;
        }

        List<String> diff2 = concept2.diffBetweenSinAndAnt(concept2.getConcept(),concept2Sin,concept1Antonyms);
        List<String> differenceWords2 = concept2.differences(concept1);
        nr=0;
        while(diff2.size()<20 && nr<differenceWords2.size()){
            diff2.add(differenceWords2.get(nr));
            nr++;
        }

/*
        List<String> diff1 = concept1.differences(concept2);
        List<String> diff2 = concept2.differences(concept1);*/

        List<String> def1 = new ArrayList();
        List<String> def2 = new ArrayList();
        try {
            def1 = new DictionaryAccessPoint().getDefinitions(concept1.getConcept());
            def2 = new DictionaryAccessPoint().getDefinitions(concept2.getConcept());
        } catch (IOException e) {
            e.printStackTrace();
        }

        StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject(info1.getTopic(), def1, concept1.setRelevant(), info2.getTopic(),def2, concept2.setRelevant(), similarities, diff1, diff2);
        //StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject(info1.getTopic(), "definitie 1", "chart?bkg=white&c={ type: 'bar', data: { labels: ['dog', 'man', 'woman', 'hello', 'dog'], datasets: [{ label: 'Users', data: [4, 3, 1, 1, 4] }] }}", info2.getTopic(),"definitie 2","chart?bkg=white&c={ type: 'bar', data: { labels: ['woman', 'rain', 'sun', 'man', 'woman'], datasets: [{ label: 'Users', data: [4, 2, 1, 1, 4] }] }}", similarities, diff1, diff2);
        return statisticsOutputObject;
    }
}