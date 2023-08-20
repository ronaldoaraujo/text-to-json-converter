package com.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.challenge.services.InputParser;
import com.challenge.services.InputParserFactory;
import com.challenge.services.TextToJsonConverter;
import com.challenge.services.InputParserFactory.Format;

public class App
{
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Application <file or directory path>");
            System.exit(1);
        }

        String inputPath = args[0];
        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.err.println("File or directory not found: " + inputPath);
            System.exit(1);
        }

        processFiles(inputFile);
    }

    private static void processFiles(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            File[] files = fileOrDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    processFiles(file);
                }
            }
        } else if (fileOrDirectory.isFile() && fileOrDirectory.getName().endsWith(".txt")) {
            processFile(fileOrDirectory);
        }
    }

    private static void processFile(File file) {
        String filePath = file.getPath();
        InputParser parser = InputParserFactory.createParser(Format.TEXT);

        try {
            TextToJsonConverter converter = new TextToJsonConverter(parser);
            String json = converter.convertToJson(filePath);

            String outputPath = filePath.replace(".txt", ".json");
            Files.write(Paths.get(outputPath), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
