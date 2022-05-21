package IPStatisticsDemo.DemoStatistics.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
public class StatisticsOutputObject {
    String concept1;   //primul concept primit
    List<String> def1;    //definitia pt primul concept
    String chart1;      //diagrama
    String concept2;
    List<String> def2;
    String chart2;
    List<String> intersect;     //asemanarile dintre cele doua concepte
    List<String> diferit1;      //chestii specifice primului concept
    List<String> diferit2;
    //String chartPie;        //diagrama comuna
    //String chartBar;        //diagrama comuna
}