import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class API {

    public JSONObject getRequest(){
        try {
            URL url = new URL("https://api.abalin.net/today?country=se");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){

                InputStreamReader isr = new InputStreamReader(con.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String inputLine;
                StringBuffer content = new StringBuffer();

                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();

                JSONObject json = new JSONObject(content.toString());

                return json;

            } else {
                System.out.println("Error");
                System.out.println("Server responded with: " + con.getResponseCode());
            }


        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void getNamesOfTheDay(JSONObject json){
        System.out.print("Today is: " + LocalDate.now());
        System.out.println(", namesday in Sweden is: '" +json.getJSONObject("data").getJSONObject("namedays").get("se")+"'");


    }
}
