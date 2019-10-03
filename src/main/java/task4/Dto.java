package task4;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class Dto {

    @JsonRawValue
//    @JsonDeserialize(using = JsonRawValueDeserializer.class)
    private Object foo;
    private int anInt;

    public Dto() {
    }

    public Object getFoo() {
        return foo;
    }

    public void setFoo(Object foo) {
        this.foo = foo;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public Dto(Object foo, int anInt) {
        this.foo = foo;
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "foo=" + foo +
                ", anInt=" + anInt +
                '}';
    }
}

//    class Serializer extends JsonSerializer<String> {
//
//    @Override
//    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//        gen.writeString(value);
//    }
//}
//class Deserializer extends JsonDeserializer<String> {
//
//    @Override
//    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//
//        return p.getText();
//    }
//}
class JsonRawValueDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jp, DeserializationContext context)
            throws IOException {

        return jp.readValueAsTree().toString();
    }

    public static boolean isJSONValid(String jsonInString ) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return !StringUtils.isNumeric(jsonInString);
        } catch (IOException e) {
            return false;
        }
    }
}


