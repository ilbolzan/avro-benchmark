package com.ilbolzan.avrobenchmark.io;

import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class AvroSlimDeserializer {

    private static Logger log = LoggerFactory.getLogger(AvroSlimDeserializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch deserialize() throws IOException {

        stopWatch.reset();
        stopWatch.start();

        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(new File("output/users.avro"), userDatumReader);
        User user = null;
        dataFileReader.hasNext();
        user = dataFileReader.next(user);

        stopWatch.stop();

        log.info("AvroSlim - deserializing: {}", stopWatch.getNanoTime());

        return stopWatch;

    }

}
