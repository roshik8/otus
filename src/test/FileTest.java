package test;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileTest {

    public static Map<String, Long> in = new HashMap<>();
    public static Map<String, Long> out = new HashMap<>();

    public static void checkAllTestFromFolder(String pathName) {
        File folder = new File(pathName);
        Stream
                .of(Objects.requireNonNull(folder.listFiles()))
                .filter(file -> !file.isDirectory())
                .filter(file -> file.getName().contains("in") || file.getName().contains("out"))
                .forEach(file -> {
                    var filename = file.getName();
                    if (file.getName().contains("in")) {
                        var testName = filename.substring(0, filename.indexOf(".in"));
                        try {
                            in.put(testName, Long.parseLong(Files.readString(file.toPath()).trim()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        var testName = filename.substring(0, filename.indexOf(".out"));

                        try {
                        out.put(testName, Long.parseLong(Files.readString(file.toPath())));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
