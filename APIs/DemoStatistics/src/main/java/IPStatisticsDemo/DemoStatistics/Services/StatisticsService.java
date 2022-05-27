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

        LinkedHashMap<String, Integer> hs = new LinkedHashMap<>();
        for (String s : arr) {
            if (hs.containsKey(s)) {
                hs.put(s, hs.get(s) + 1);
            } else {
                hs.put(s, 1);
            }
        }
        return hs;
    }

    public String setPieChart(StatisticsInputObject info1, StatisticsInputObject info2){
        //  chart?c={type:'pie',data:{labels:['Concept1','Concept2'], datasets:[{data:[40,60]}]}}
        String relevant1;

       /*List<String> finalList1 = new ArrayList<>();
        while (info1.getNouns().remove("")) {
        }
        while (info1.getAdj().remove("")) {
        }
        while (info1.getVerb().remove("")) {
        }
        finalList1.addAll(info1.getAdj());
        finalList1.addAll(info1.getNouns());
        finalList1.addAll(info1.getVerb());


        List<String> finalList2 = new ArrayList<>();
        while (info2.getNouns().remove("")) {
        }
        while (info2.getAdj().remove("")) {
        }
        while (info2.getVerb().remove("")) {
        }
        finalList2.addAll(info2.getAdj());
        finalList2.addAll(info2.getNouns());
        finalList2.addAll(info2.getVerb());*/

        List<String> finalList1 = new ArrayList<>();
        finalList1 = proccList(info1);
        List<String> finalList2 = new ArrayList<>();
        finalList2 = proccList(info2);

        relevant1 = new String();
        relevant1 = relevant1 + "chart?c={type:'pie',data:{labels:['";
        relevant1 = relevant1 + info1.getTopic();
        relevant1 = relevant1 + "','";
        relevant1 = relevant1 + info2.getTopic();
        relevant1 = relevant1 + "'], datasets:[{data:[";
        relevant1 = relevant1 + finalList1.size() + "," + finalList2.size() + "]}]}}";

        return relevant1;
    }

    public int setSimilaritiesChart(StatisticsInputObject info1, StatisticsInputObject info2)
    {
        int s, t, p;
        List<String> totalList = new ArrayList<>();

        List<String> finalList1 = new ArrayList<>();
        finalList1 = proccList(info1);
        List<String> finalList2 = new ArrayList<>();
        finalList2 = proccList(info2);

        LinkedHashMap<String, Integer> hm1 = frequency(finalList1);
        LinkedHashMap<String, Integer> hm2 = frequency(finalList2);

        Concept concept1 = new Concept(info1.getTopic(), hm1);
        Concept concept2 = new Concept(info2.getTopic(), hm2);

        s = concept1.similarities(concept2).size();
        totalList.addAll(finalList1);
        totalList.addAll(finalList2);

        t = totalList.size();
        p = s*100/t;
        return p;

        // chart?c={ type: 'radialGauge', data: { datasets: [{ data: [80], backgroundColor: getGradientFillHelper('horizontal', ['red', 'blue']), }] }, options: { // See https://github.com/pandameister/chartjs-chart-radial-gauge#options domain: [0, 100], trackColor: '#f0f8ff', centerPercentage: 90, centerArea: { text: (val) => val + '%', }, } }
    }

    public String setBarChart(StatisticsInputObject info1, StatisticsInputObject info2) {
        //  chart?c={type:'bar',data:{labels:['Nouns','Adjectives', 'Verbs'], datasets:[{label:'Concept1',data:[50,60,70]},{label:'Concept2',data:[100,200,300]}]}}
        List<String> finalList1 = new ArrayList<>();
        finalList1 = proccList(info1);
        List<String> finalList2 = new ArrayList<>();
        finalList2 = proccList(info2);

        String relevant2;
        relevant2 = new String();
        relevant2 = relevant2 + "chart?c={type:'bar',data:{labels:['Nouns','Adjectives', 'Verbs'], datasets:[{label:'";
        relevant2 = relevant2 + info1.getTopic();
        relevant2 = relevant2 + "',data:[";
        relevant2 = relevant2 + info1.getNouns().size() + "," + info1.getAdj().size() + "," + info1.getVerb().size();
        relevant2 = relevant2 + "]},{label:'";
        relevant2 = relevant2 + info2.getTopic();
        relevant2 = relevant2 + "',data:[";
        relevant2 = relevant2 + info2.getNouns().size() + "," + info2.getAdj().size() + "," + info2.getVerb().size();
        relevant2 = relevant2 + "]}]}}";

        return relevant2;
    }

    /*public List<String> textProcessing(String text){
        String[] splitText=text.split("[, ?.@(){}:;'\"]+");
        List<String> finalList1 = new ArrayList<>();
        for (String s : splitText) {
            if (!s.equals("the") && !s.equals("in")) {
                finalList1.add(s);
            }
        }
        return finalList1;
    }*/

    public List<String> proccList(StatisticsInputObject info)
    {
        List<String> finalList = new ArrayList<>();

        //remove words of 1-2 letters, nulls
        info.getNouns().removeIf(s -> (s.length()<3));
        info.getAdj().removeIf(s -> (s.length()<3));
        info.getVerb().removeIf(s -> (s.length()<3));

        //remove verbs
//        info.getVerb().removeIf(s -> (s.equals("have")));
//        info.getVerb().removeIf(s -> (s.equals("has")));
//        info.getVerb().removeIf(s -> (s.equals("were")));
//        info.getVerb().removeIf(s -> (s.equals("was")));
//        info.getVerb().removeIf(s -> (s.equals("would")));
//        info.getVerb().removeIf(s -> (s.equals("will")));
//        info.getVerb().removeIf(s -> (s.equals("could")));
//        info.getVerb().removeIf(s -> (s.equals("can")));

        finalList.addAll(info.getAdj());
        finalList.addAll(info.getNouns());
        finalList.addAll(info.getVerb());

        return finalList;
    }


    private StatisticsOutputObject doSomeStuff(StatisticsInputObject info1, StatisticsInputObject info2)
    {
        //prelucrati si apelati api-urile etc

        List<String> finalList1 = new ArrayList<>();
        finalList1 = proccList(info1);
        List<String> finalList2 = new ArrayList<>();
        finalList2 = proccList(info2);

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

        Set<String> concept1Antonyms= null;
        Set<String> concept2Antonyms= null;
        try {
            concept1Antonyms = new DictionaryAccessPoint().getAntonyms(concept1.getConcept());
            concept2Antonyms = new DictionaryAccessPoint().getAntonyms(concept2.getConcept());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> similarities = concept1.commonSynonyms(concept1.getConcept(),concept1Sin,concept2.getConcept(),concept2Sin);
        List<String> similaritiesBasedOnAntonyms=concept1.commonAntonyms(concept1Antonyms,concept2Antonyms);
        int nr1=0;
        while(similarities.size()<20 && nr1<similaritiesBasedOnAntonyms.size()){
            similarities.add(similaritiesBasedOnAntonyms.get(nr1));
            nr1++;
        }
        List<String> commonWords = concept1.similarities(concept2);
        int nr=0;
        while(similarities.size()<20 && nr<commonWords.size()){
            similarities.add(commonWords.get(nr));
            nr++;
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

        //String pieChart="chart?c={type:'pie',data:{labels:['Concept1','Concept2'], datasets:[{data:[40,60]}]}}";
        //String barChart="chart?c={type:'bar',data:{labels:['Nouns','Adjectives', 'Verbs'], datasets:[{label:'Concept1',data:[50,60,70]},{label:'Concept2',data:[100,200,300]}]}}";

        String pieChart = setPieChart(info1, info2);
        String barChart = setBarChart(info1, info2);
        StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject(info1.getTopic(), def1, concept1.setRelevant(), info2.getTopic(),def2, concept2.setRelevant(), similarities, diff1, diff2,pieChart,barChart);
        //StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject(info1.getTopic(), "definitie 1", "chart?bkg=white&c={ type: 'bar', data: { labels: ['dog', 'man', 'woman', 'hello', 'dog'], datasets: [{ label: 'Users', data: [4, 3, 1, 1, 4] }] }}", info2.getTopic(),"definitie 2","chart?bkg=white&c={ type: 'bar', data: { labels: ['woman', 'rain', 'sun', 'man', 'woman'], datasets: [{ label: 'Users', data: [4, 2, 1, 1, 4] }] }}", similarities, diff1, diff2);

        //StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject(info1.getTopic(), def1, concept1.setRelevant(), info2.getTopic(),def2, concept2.setRelevant(), similarities, diff1, diff2);
        return statisticsOutputObject;
    }
}