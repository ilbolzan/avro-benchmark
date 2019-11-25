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
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis id nibh leo. Proin a imperdiet massa, vitae fringilla diam. Vestibulum tempus sem nunc, iaculis tincidunt magna pharetra nec. Praesent tristique ipsum metus, nec rutrum massa tincidunt nec. Nulla et felis auctor, pharetra nunc vitae, molestie urna. Nullam scelerisque consectetur suscipit. In vel sapien nisi. Phasellus vitae rutrum velit. Maecenas nunc odio, consectetur ut lectus eget, mattis faucibus sapien. In hac habitasse platea dictumst. Ut efficitur risus augue, non semper risus tempor eu. Nam eu nulla id tortor convallis porttitor vel eu lectus. Proin tellus ligula, ornare a nisl ut, fermentum volutpat tellus. Aliquam at sapien nisl. Sed tempor, est ac sollicitudin consectetur, elit urna pretium lacus, a dignissim nibh nibh ut tortor. Quisque tellus sapien, mollis sit amet convallis feugiat, maximus in mauris. Aliquam pellentesque ex rhoncus est molestie, at condimentum tortor accumsan. Duis dui sapien, malesuada eget maximus at, sagittis sed justo. Nullam sodales ipsum a sem tincidunt eleifend. Morbi in dui ut risus bibendum consectetur vitae id mauris. Ut semper libero ante, vitae fermentum arcu hendrerit eu. In sit amet mi erat.")
                .build();

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);

        stopWatch.reset();
        stopWatch.start();


        dataFileWriter.create(user.getSchema(), new File("output/users.avro"));
        dataFileWriter.append(user);
        dataFileWriter.close();

        stopWatch.stop();

        log.info("AvroFat - Serializing: {}", stopWatch.getNanoTime());

        return stopWatch;

    }

}
