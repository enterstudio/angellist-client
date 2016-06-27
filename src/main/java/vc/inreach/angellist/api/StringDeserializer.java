package vc.inreach.angellist.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.google.common.base.Strings;

import java.io.IOException;
import java.util.Optional;

class StringDeserializer extends JsonDeserializer<Optional<String>> {
    @Override
    public Optional<String> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
        final String value = parser.getText();
        if (value == null || Strings.isNullOrEmpty(value.trim())) {
            return Optional.empty();
        }
        return Optional.of(value);
    }

    @Override
    public Optional<String> getNullValue(DeserializationContext ctxt) {
        return Optional.empty();
    }
}
