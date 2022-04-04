package Data_Processing;

public class Processor {

    private String name;
    private String deviceID;
    int CurrentUtilization;

    public Processor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public int getCurrentUtilization() {
        return CurrentUtilization;
    }

    public void getInfoFromCrawler(){
        //get info
    }
}
