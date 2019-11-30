package com.ilbolzan.avrobenchmark.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilbolzan.avrobenchmark.model.User;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class JacksonSerializer {

    private static Logger log = LoggerFactory.getLogger(JacksonSerializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch serialize() throws IOException {

        User user = new User("Charlie", "blue", 12345678,
                "description");

        ObjectMapper objectMapper = new ObjectMapper();

        stopWatch.reset();
        stopWatch.start();

        objectMapper.writeValue(new File("output/userJackson.json"), user);

        stopWatch.stop();

//        log.info("Jackson - Serializing: {}", stopWatch.getNanoTime()/ 1000);
        return stopWatch;

    }

}
