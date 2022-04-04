/*
The "Processor" Class is responsible with processing all the information. It uses the class "Natural Language Processor"
to call the NLP Tool to apply on our data and the "GetInput" class to get the external data from the Crawler team.
We also need a file with the same name, where the class will be located.
 */

package Data_Processing;

public class Processor {

    int currentUtilization;
    private String name;
    private String deviceId;

    public Processor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public int getCurrentUtilization() {
        return currentUtilization;
    }

    public void getInfoFromCrawler(){
        //get info
    }
}
