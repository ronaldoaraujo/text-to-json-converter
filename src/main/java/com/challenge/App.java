package com.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.challenge.services.InputParser;
import com.challenge.services.InputParserFactory;
import com.challenge.services.TextToJsonConverter;
import com.challenge.services.InputParserFactory.Format;


public class App
{
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Usage: java App <file or directory path>");

        Path path = Paths.get(args[0]);

        if (!Files.exists(path))
            LOGGER.log(Level.SEVERE, "File or directory not found: {0}", args[0]);
        else
            processFiles(path);
    }

    private static void processFiles(Path path) {
        try (Stream<Path> paths = Files.walk(path)) {
            paths.filter(p -> Files.isRegularFile(p) && p.toString().endsWith(".txt"))
                    .forEach(App::processFile);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An IOException occurred while processing files:", e);
        }
    }

    private static void processFile(Path file) {
        InputParser parser = InputParserFactory.createParser(Format.TEXT);

        try {
            TextToJsonConverter converter = new TextToJsonConverter(parser);
            String json = converter.convertToJson(file.toString());

            Path outputPath = Paths.get(file.toString().replace(".txt", ".json"));
            Files.write(outputPath, json.getBytes());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An IOException occurred while processing files:", e);
        }
    }
}
