package task4;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main2 {
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException, ParseException {
        Dto dto = new Dto("{\"a\" : 1 }", 1);


        Gson gson = new Gson();
        System.out.println(gson.toJson(dto));
        String s = mapper.writeValueAsString(dto);
        System.out.println(s);
//        System.out.println(mapper.readValue(s, Map.class));


        System.out.println(JsonRawValueDeserializer.isJSONValid("1"));

        System.out.println(java.net.InetAddress.getLocalHost().getHostName());
        System.out.println(java.net.InetAddress.getLocalHost().getCanonicalHostName());
    }




}
