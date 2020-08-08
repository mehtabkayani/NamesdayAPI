import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        API api = new API();
        JSONObject jsonObject = api.getRequest();
        api.getNamesOfTheDay(jsonObject);
    }
}

