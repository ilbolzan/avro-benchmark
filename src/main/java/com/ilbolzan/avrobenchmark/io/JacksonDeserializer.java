package com.ilbolzan.avrobenchmark.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilbolzan.avrobenchmark.model.User;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class JacksonDeserializer {

    private static Logger log = LoggerFactory.getLogger(JacksonDeserializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch deserialize() throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();

        stopWatch.reset();
        stopWatch.start();

        User user = objectMapper.readValue(new File("userJackson.json"), User.class);

        stopWatch.stop();

        log.info("Jackson - deserializing: {}", stopWatch.getNanoTime());

        return stopWatch;

    }

}
