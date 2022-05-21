package Demo.DemoDataProcessing.Services;

import Demo.DemoDataProcessing.models.DataProcessingInputObject;
import Demo.DemoDataProcessing.models.DataProcessingOutputObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnResponse;
import com.monkeylearn.MonkeyLearnException;
import org.json.simple.JSONObject;

public class DataProcessingService {

    public List<DataProcessingOutputObject> processInfo(List<DataProcessingInputObject> dataProcessingInputObject) throws MonkeyLearnException, IOException {
        //return ...
        return doSomeStuff(dataProcessingInputObject.get(1).getUser(), dataProcessingInputObject.get(1).getText(), dataProcessingInputObject.get(1).getTopic());
    }

    private List<DataProcessingOutputObject> doSomeStuff(String user, String text, String topic) throws MonkeyLearnException, IOException {

        /*
        // Use the MonkeyLearn API key.
        MonkeyLearn monkeyLearn = new MonkeyLearn("[80b5620adec21db1d2ad3a21f5a8e0c2def5064b]");

        // Make the POST request to the model found here: https://api.monkeylearn.com/v3/extractors/ex_6DsxKMca/extract/.
        URL url = new URL("https://api.monkeylearn.com/v3/extractors/ex_6DsxKMca/extract/");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        // Send the input string.
        String[] textString = {"text1", "text2", "text3"};
        String jsonInputString = new JSONObject().put("data", textString).toString();
        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            outputStream.write(input, 0, input.length);
        }

        // Set the necessary model. Necessary model: ex_6DsxKMca.
        String modelId = "ex_6DsxKMca";

        // Set the input data.
        String[] inputData =
        {
            "This is the first sentence.",
            "This is a new proposition.",
            "This is not other text."
        };

        // Get the MonkeyLearn response. The final response is monkeyLearnResponse.jsonResult or .arrayResult.
        MonkeyLearnResponse monkeyLearnResponse = monkeyLearn.extractors.extract(modelId, inputData);
        */

        //prelucrati si apelati api-urile etc
        List<DataProcessingOutputObject> list = new ArrayList<>();
        DataProcessingOutputObject dataProcessingOutputObject1 = new DataProcessingOutputObject("mere", Arrays.asList("ana", "mere"), Arrays.asList(""), Arrays.asList("are") );
        DataProcessingOutputObject dataProcessingOutputObject2 = new DataProcessingOutputObject("pere", Arrays.asList("ana", "pere"), Arrays.asList(""), Arrays.asList("are") );
        list.add(0, dataProcessingOutputObject1);
        list.add(1, dataProcessingOutputObject2);
        return list;
        // return monkeyLearnResponse.arrayResult;
    }
}
