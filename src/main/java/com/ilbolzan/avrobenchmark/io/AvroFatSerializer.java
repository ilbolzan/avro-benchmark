package com.ilbolzan.avrobenchmark.io;

import example.avro.User;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class AvroFatSerializer {

    private static Logger log = LoggerFactory.getLogger(AvroFatSerializer.class);
    private static StopWatch stopWatch = new StopWatch();

    public static StopWatch serialize() throws IOException {

        User user = User.newBuilder()
                .setName("Charlie")
                .setFavoriteColor("blue")
                .setFavoriteNumber(12345678)
                .setDescription("description")
                .build();

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);

        stopWatch.reset();
        stopWatch.start();


        dataFileWriter.create(user.getSchema(), new File("output/users.avro"));
        dataFileWriter.append(user);
        dataFileWriter.close();

        stopWatch.stop();

//        log.info("AvroFat - Serializing: {}", stopWatch.getNanoTime()/ 1000);

        return stopWatch;

    }

}
