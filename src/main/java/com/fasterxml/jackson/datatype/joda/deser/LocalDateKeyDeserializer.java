package com.fasterxml.jackson.datatype.joda.deser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;

public class LocalDateKeyDeserializer extends KeyDeserializer
{
    private static final long serialVersionUID = 1L;
    private static final DateTimeFormatter parser = ISODateTimeFormat.localDateParser();

    @Override
    public LocalDate deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (key.length() == 0) { // [JACKSON-360]
            return null;
        }
        return parser.parseLocalDate(key);
    }
}