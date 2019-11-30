package com.ilbolzan.avrobenchmark.io;

import example.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AvroSlimDeserializer {

    private static Logger log = LoggerFactory.getLogger(AvroSlimDeserializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch deserialize() throws IOException {

        DatumReader<User> reader= new SpecificDatumReader<>(User.getClassSchema());

        stopWatch.reset();
        stopWatch.start();

        BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(new FileInputStream(new File("output/userSlim.avro")), null);

        User user = reader.read(null, decoder);

        stopWatch.stop();

//        log.info("AvroSlim - deserializing: {}", stopWatch.getNanoTime() / 1000);

//        log.info("{}", user);

        return stopWatch;

    }

}
