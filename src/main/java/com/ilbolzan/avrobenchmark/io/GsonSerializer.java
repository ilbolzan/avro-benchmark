package com.ilbolzan.avrobenchmark.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ilbolzan.avrobenchmark.model.User;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GsonSerializer {

    private static Logger log = LoggerFactory.getLogger(GsonSerializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch serialize() throws IOException {

        User user = new User("Charlie", "blue", 12345678,
                "description");

        Gson gson = new Gson();

        stopWatch.reset();
        stopWatch.start();

        Writer writer = new FileWriter("output/userGson.json");
        gson.toJson(user, writer);
        writer.flush();

        stopWatch.stop();

//        log.info("Gson - Serializing: {}", stopWatch.getNanoTime()/ 1000);

        return stopWatch;

    }

}
