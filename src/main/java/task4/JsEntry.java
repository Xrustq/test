package task4;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializableWithType;

import java.io.IOException;

public class JsEntry implements JsonSerializableWithType {
    private String value;

    JsEntry(String value) {
        this.value = value;
    }

    @Override
    public void serializeWithType(org.codehaus.jackson.JsonGenerator jgen, org.codehaus.jackson.map.SerializerProvider provider, org.codehaus.jackson.map.TypeSerializer typeSer) throws IOException, JsonProcessingException {
        this.serialize(jgen, provider);
    }

    @Override
    public void serialize(org.codehaus.jackson.JsonGenerator jgen, org.codehaus.jackson.map.SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeRawValue(value);
    }
}