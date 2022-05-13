package IPStatisticsDemo.DemoStatistics.Services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author George
 */
public class DictionaryAccessPoint {

    //This is the base url for searches. If you want to use diffrent lanuages change en to other language code.
    private final String baseURLString = "https://api.dictionaryapi.dev/api/v2/entries/en/";

    /**
     * This is the constructor for the class.
     * TODO: modify so it returns error if free dictionary services don't work.
     *
     */
    public DictionaryAccessPoint() {
    }

    /**
     * Returns all definitions for a given word separated by the lineBreak at the end of each individual definition.
     * WARNING: This function is dependent on the free dictionary API.
     *
     * @param word The search word
     * @return A string containing all the definition from the API for a given word
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public List<String> getDefinitions(String word) throws MalformedURLException, ProtocolException, IOException {

        List<String> tempList = new ArrayList();
        String jsonString;
        StringBuilder temp = new StringBuilder();
        JSONObject baseJSON;
        JSONArray meanings;

        temp.append(baseURLString);
        temp.append(word);

        URL url = new URL(temp.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        temp = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            temp.append(inputLine);
        }
        in.close();
        jsonString = temp.toString();

        baseJSON = new JSONArray(jsonString).getJSONObject(0);
        meanings = baseJSON.getJSONArray("meanings");

        for (int i = 0; i < meanings.length(); i++) {

            for (int j = 0; j < meanings.getJSONObject(i).getJSONArray("definitions").length(); j++) {

                tempList.add(meanings.getJSONObject(i).getJSONArray("definitions").getJSONObject(j).getString("definition"));

            }

        }

        return tempList;

    }

    /**
     * This function returns the antonyms of the given search word
     *
     * @param word The search word
     * @return A list of synonyms extracted from the free dictionary API
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public Set<String> getSynonyms(String word) throws MalformedURLException, ProtocolException, IOException {

        Set<String> tempSet = new HashSet();

        String jsonString;
        StringBuilder temp = new StringBuilder();
        JSONObject baseJSON;
        JSONArray meanings;

        temp.append(baseURLString);
        temp.append(word);

        URL url = new URL(temp.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        temp = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            temp.append(inputLine);
        }
        in.close();
        jsonString = temp.toString();

        baseJSON = new JSONArray(jsonString).getJSONObject(0);
        meanings = baseJSON.getJSONArray("meanings");

        for (int i = 0; i < meanings.length(); i++) {

            for (int j = 0; j < meanings.getJSONObject(i).getJSONArray("synonyms").length(); j++) {

                tempSet.add(meanings.getJSONObject(i).getJSONArray("synonyms").getString(j));

            }

        }

        return tempSet;

    }

    /**
     *  This function returns the antonyms of the given search word
     *
     * @param word The search word
     * @return A list of antonyms extracted from the free dictionary API
     * @throws MalformedURLException
     * @throws ProtocolException
     * @throws IOException
     */
    public Set<String> getAntonyms(String word) throws MalformedURLException, ProtocolException, IOException {

        Set<String> tempSet = new HashSet();

        String jsonString;
        StringBuilder temp = new StringBuilder();
        JSONObject baseJSON;
        JSONArray meanings;

        temp.append(baseURLString);
        temp.append(word);

        URL url = new URL(temp.toString());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        temp = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            temp.append(inputLine);
        }
        in.close();
        jsonString = temp.toString();

        baseJSON = new JSONArray(jsonString).getJSONObject(0);
        meanings = baseJSON.getJSONArray("meanings");

        for (int i = 0; i < meanings.length(); i++) {

            for (int j = 0; j < meanings.getJSONObject(i).getJSONArray("antonyms").length(); j++) {

                tempSet.add(meanings.getJSONObject(i).getJSONArray("antonyms").getString(j));

            }

        }

        return tempSet;

    }

}