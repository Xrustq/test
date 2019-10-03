package task4;

import org.json.simple.parser.ParseException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) throws ParseException {

        String str= "1:true, 2:false, 3:false";
        List<String> list = Arrays.asList(str.split("\\s*,\\s*"));

        HashMap<String, String> map = list.stream()
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(s -> s[0], s -> s[1], (a, b) -> a, HashMap::new));

        String name = "test.zip";

        System.out.println(name.substring(0, name.lastIndexOf('.')).concat(".jar"));
        System.out.println(false && true);

    }

}
