
package com.mycompany.jsonfile;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.io.FileWriter;
/**
 *
 * @author Florin
 */
public class Save {
    
    
    Object object;
    String path;

    public Save(Object object, String path) {
        this.object = object;
        this.path = path;
    }
    
    public void execute1() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path),object);

    }
    
    public void execute2() throws IOException {

        //Creating a JSONObject object
      JSONObject jsonObject = new JSONObject();
      //Inserting key-value pairs into the json object
      jsonObject.put("concept2","descriere");
      jsonObject.put("concept2", "descriere");

      try {
         FileWriter file = new FileWriter(path);
         file.write(jsonObject.toJSONString());
         file.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("JSON file created: "+jsonObject);

    }
}
