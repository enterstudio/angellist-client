package vc.inreach.angellist.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.common.base.Strings;

import java.io.IOException;
import java.util.Optional;

class StringSerializer extends JsonSerializer<Optional<String>> {

    private final ToStringSerializer stringSerializer = ToStringSerializer.instance;

    @Override
    public void serialize(Optional<String> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null && value.isPresent() && ! Strings.isNullOrEmpty(value.get())) {
            stringSerializer.serialize(value.get(), gen, serializers);
        }
    }

    @Override
    public boolean isEmpty(SerializerProvider provider, Optional<String> value) {
        return value == null || ! value.isPresent() || Strings.isNullOrEmpty(value.get());
    }
}
