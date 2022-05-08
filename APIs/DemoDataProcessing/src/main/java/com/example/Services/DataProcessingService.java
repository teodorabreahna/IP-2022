package com.example.Services;

import com.example.models.DataProcessingInputObject;
import com.example.models.DataProcessingOutputObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProcessingService {

    public List<DataProcessingOutputObject> processInfo(List<DataProcessingInputObject> dataProcessingInputObject) {
        //return ...
        return doSomeStuff(dataProcessingInputObject.get(1).getUser(), dataProcessingInputObject.get(1).getText(), dataProcessingInputObject.get(1).getTopic());
    }



    private List<DataProcessingOutputObject> doSomeStuff(String user, String text, String topic)
    {
        //prelucrati si apelati api-urile etc
        List<DataProcessingOutputObject> list = new ArrayList<>();
        DataProcessingOutputObject dataProcessingOutputObject1 = new DataProcessingOutputObject("mere", Arrays.asList("ana", "mere"), Arrays.asList(""), Arrays.asList("are") );
        DataProcessingOutputObject dataProcessingOutputObject2 = new DataProcessingOutputObject("pere", Arrays.asList("ana", "pere"), Arrays.asList(""), Arrays.asList("are") );
        list.add(0, dataProcessingOutputObject1);
        list.add(1, dataProcessingOutputObject2);
        return list;
    }
}
