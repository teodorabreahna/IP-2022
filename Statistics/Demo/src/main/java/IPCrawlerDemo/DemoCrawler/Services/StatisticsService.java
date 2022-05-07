package IPCrawlerDemo.DemoCrawler.Services;

import IPCrawlerDemo.DemoCrawler.models.StatisticsInputObject;
import IPCrawlerDemo.DemoCrawler.models.StatisticsOutputObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

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

        List<String> finalList2 = new ArrayList<>();
        finalList2.addAll(info2.getAdjectives());
        finalList2.addAll(info2.getNouns());
        finalList2.addAll(info2.getVerbs());

        LinkedHashMap<String, Integer> hm1 = frequency(finalList1);
        LinkedHashMap<String, Integer> hm2 = frequency(finalList2);

        Concept concept1 = new Concept(info1.getTopic(), hm1);
        Concept concept2 = new Concept(info2.getTopic(), hm2);

        concept1.HashMapSort();
        concept2.HashMapSort();

        List<String> similarities = concept1.similarities(concept2);
        List<String> diff1 = concept1.differences(concept2);
        List<String> diff2 = concept2.differences(concept1);

        StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject(info1.getTopic(), "definitie 1", concept1.setRelevant(), info2.getTopic(),"definitie 2", concept2.setRelevant(), similarities, diff1, diff2);
        //StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject(info1.getTopic(), "definitie 1", "chart?bkg=white&c={ type: 'bar', data: { labels: ['dog', 'man', 'woman', 'hello', 'dog'], datasets: [{ label: 'Users', data: [4, 3, 1, 1, 4] }] }}", info2.getTopic(),"definitie 2","chart?bkg=white&c={ type: 'bar', data: { labels: ['woman', 'rain', 'sun', 'man', 'woman'], datasets: [{ label: 'Users', data: [4, 2, 1, 1, 4] }] }}", similarities, diff1, diff2);
        return statisticsOutputObject;
    }
}
