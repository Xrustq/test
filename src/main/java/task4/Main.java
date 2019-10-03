package task4;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

import static task4.Main.Rq.printJsonNode;

public class Main {


    public static void main(String[] args) throws IOException, JSONException {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
        HashMap<String, String> params = new HashMap();
        String json = "{\"Статус\":\"В обработке\"}";
        String json2 = "{ }";
        params.put( "1",json);
        params.put("first", json);

        String jsonNode =  objectMapper.writeValueAsString(params);
        System.out.println((jsonNode));
        json = json.replaceAll("\\\\\\+", "\\");
        System.out.println(json);

        JSONParser parser = new JSONParser();
        org.json.simple.JSONObject obj = new JSONObject(params);
        System.out.println(obj);
        try {
            obj = (org.json.simple.JSONObject) parser.parse(obj.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JsonNode obj2 = objectMapper.readTree(json2);
        System.out.println("111111" + obj);
//        printJsonNode(obj);
//        printJsonObject(obj);
        Rq rq= new Rq();
//        rq.setS(obj);
        System.out.println(rq);
//        HashMap<String, String> map = new HashMap();
//        map.put("key", StringEscapeUtils.unescapeJson(json));


        ArrayList<Object> sad = new ArrayList<>();
        sad.add("asd");
        sad.add("asdasdas");
        System.out.println(sad);

//        Rq ronaldo = objectMapper.readValue(json, Rq.class);
//        System.out.println(ronaldo);
//
//        System.out.println(jsonNode);

//        JSONObject obj = new JSONObject(json);
//        printJsonObject(obj);
//        System.out.println(obj.toString());
String s = null;
Object o  = null;
        System.out.println(o.toString());
    }

    private static void c(Rq2 s) {
        s.setString("dasdasdsd");
    }

    public static class Rq2{
        private String string;

        public Rq2(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return "Rq2{" +
                    "string='" + string + '\'' +
                    '}';
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

    public static class Rq{
//        @JsonRawValue
//        @JsonProperty
        private JsonNode s;

        public JsonNode getS() {
            return s;
        }

        public void setS(JsonNode s) {
            this.s = s;
        }

        public static void printJsonNode(JsonNode jsonObj) {
            for (Iterator it = jsonObj.fieldNames(); it.hasNext(); ) {
                String keyStr = (String) it.next();
                Object keyvalue = jsonObj.get(keyStr);

                //Print key and value
                System.out.println("key: "+ keyStr + " value: " + keyvalue);

                //for nested objects iteration if required
//                if (keyvalue instanceof JSONObject)
//                    printJsonObject((JSONObject)keyvalue);
            }
        }
    }
}
