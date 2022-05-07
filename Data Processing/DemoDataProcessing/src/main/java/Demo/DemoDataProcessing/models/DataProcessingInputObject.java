package Demo.DemoDataProcessing.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataProcessingInputObject {
    private String user;
    private String text;
    private String topic;

}
