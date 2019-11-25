package com.ilbolzan.avrobenchmark.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ilbolzan.avrobenchmark.model.User;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GsonDeserializer {

    private static Logger log = LoggerFactory.getLogger(GsonDeserializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch deserialize() throws IOException {


        Gson gson = new Gson();

        stopWatch.reset();
        stopWatch.start();

        User user = gson.fromJson(new FileReader("userGson.json"), User.class);

        stopWatch.stop();

        log.info("Jackson - deserializing: {}", stopWatch.getNanoTime());

        return stopWatch;

    }

}
