package IPCrawlerDemo.DemoCrawler.Services;

import IPCrawlerDemo.DemoCrawler.models.StatisticsInputObject;
import IPCrawlerDemo.DemoCrawler.models.StatisticsOutputObject;

import java.util.Arrays;
import java.util.List;

public class StatisticsService {

    public StatisticsOutputObject processInfo(List<StatisticsInputObject> statisticsInputObject) {

        return doSomeStuff();
    }


    private StatisticsOutputObject doSomeStuff()
    {
        //prelucrati si apelati api-urile etc

        StatisticsOutputObject statisticsOutputObject = new StatisticsOutputObject("primul", "descriere concept1", "chart?bkg=white&c={ type: 'bar', data: { labels: ['dog', 'man', 'woman', 'hello', 'dog'], datasets: [{ label: 'Users', data: [4, 3, 1, 1, 4] }] }}", "alDoilea","descriere concept2","chart?bkg=white&c={ type: 'bar', data: { labels: ['woman', 'rain', 'sun', 'man', 'woman'], datasets: [{ label: 'Users', data: [4, 2, 1, 1, 4] }] }}", Arrays.asList("man","woman"), Arrays.asList("dog","hello"), Arrays.asList("rain","sun"));
        return statisticsOutputObject;
    }
}
