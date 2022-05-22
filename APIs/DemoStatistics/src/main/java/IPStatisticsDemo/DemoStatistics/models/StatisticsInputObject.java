package IPStatisticsDemo.DemoStatistics.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsInputObject {
    /*String topic;
    List<String> nouns;
    List<String> adjectives;
    List<String> verbs;
    String user;
    String text;
    String topic;*/
     List<String> nouns;
     List<String> adj;
     List<String> verb;
     String topic;
}
