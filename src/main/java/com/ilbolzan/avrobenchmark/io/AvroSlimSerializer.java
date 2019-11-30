package com.ilbolzan.avrobenchmark.io;

import example.avro.User;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AvroSlimSerializer {

    private static Logger log = LoggerFactory.getLogger(AvroSlimSerializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch serialize() throws IOException {

        User user = User.newBuilder()
                .setName("Charlie")
                .setFavoriteColor("blue")
                .setFavoriteNumber(12345678)
                .setDescription("description")
                .build();

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(new FileOutputStream(new File("output/userSlim.avro")), null);

        stopWatch.reset();
        stopWatch.start();

        userDatumWriter.write(user, encoder);
        encoder.flush();

        stopWatch.stop();

//        log.info("AvroSlim - Serializing: {}", stopWatch.getNanoTime()/ 1000);

        return stopWatch;

    }

}
