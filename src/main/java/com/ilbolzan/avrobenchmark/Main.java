package com.ilbolzan.avrobenchmark;

import com.ilbolzan.avrobenchmark.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Long microsecondsSpent = 0L;

            for (int i = 0; i < 100; i++) {
                microsecondsSpent += JacksonSerializer.serialize().getNanoTime() / 1000;
            }
            log.info("Jackson-Serialize avg {}", microsecondsSpent / 100);

            microsecondsSpent = 0L;
            for (int i = 0; i < 100; i++) {
                microsecondsSpent += JacksonDeserializer.deserialize().getNanoTime() / 1000;
            }
            log.info("Jackson-Deserialize avg {}", microsecondsSpent / 100);

            microsecondsSpent = 0L;
            for (int i = 0; i < 100; i++) {
                microsecondsSpent += GsonSerializer.serialize().getNanoTime() / 1000;
            }
            log.info("Gson-Serialize avg {}", microsecondsSpent / 100);
            microsecondsSpent = 0L;
            for (int i = 0; i < 100; i++) {
                microsecondsSpent += GsonDeserializer.deserialize().getNanoTime() / 1000;
            }
            log.info("Gson-Deserialize avg {}", microsecondsSpent / 100);

            microsecondsSpent = 0L;
            for (int i = 0; i < 100; i++) {
                microsecondsSpent += AvroFatSerializer.serialize().getNanoTime() / 1000;
            }
            log.info("Avro-WithSchema-Serialize avg {}", microsecondsSpent / 100);
            microsecondsSpent = 0L;
            for (int i = 0; i < 100; i++) {
                microsecondsSpent += AvroFatDeserializer.deserialize().getNanoTime() / 1000;
            }
            log.info("Avro-WithSchema-Deserialize avg {}", microsecondsSpent / 100);

            microsecondsSpent = 0L;
            for (int i = 0; i < 100; i++) {
                microsecondsSpent += AvroSlimSerializer.serialize().getNanoTime() / 1000;
            }
            log.info("Avro-OnlyData-Serialize avg {}", microsecondsSpent / 100);
            microsecondsSpent = 0L;
            for (int i = 0; i < 100; i++) {
                microsecondsSpent += AvroSlimDeserializer.deserialize().getNanoTime() / 1000;
            }
            log.info("Avro-OnlyData-Deserialize avg {}", microsecondsSpent / 100);

        } catch (Exception e) {
            log.error("Untreated exception", e);
        }

    }
}
