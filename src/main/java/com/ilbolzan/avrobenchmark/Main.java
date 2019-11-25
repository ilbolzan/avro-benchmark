package com.ilbolzan.avrobenchmark;

import com.ilbolzan.avrobenchmark.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            JacksonSerializer.serialize();
            JacksonDeserializer.deserialize();

            GsonSerializer.serialize();
            GsonDeserializer.deserialize();

            AvroFatSerializer.serialize();
            AvroFatDeserializer.deserialize();


        } catch (Exception e) {
            log.error("Untreated exception", e);
        }

    }
}
