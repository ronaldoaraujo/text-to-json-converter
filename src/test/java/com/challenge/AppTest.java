package com.challenge;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.After;
import org.junit.Test;

public class AppTest
{
    private String testDirectory = "src/test/resources";

    @After
    public void cleanUp() throws IOException {
        File directory = new File(testDirectory);
        File[] jsonFiles = directory.listFiles((dir, name) -> name.endsWith(".json"));

        if (jsonFiles != null) {
            for (File jsonFile : jsonFiles) {
                Files.delete(jsonFile.toPath());
            }
        }
    }

    @Test
    public void testConvertAllFilesInDirectoryToJson() {
        App.main(new String[]{testDirectory});

        File directory = new File(testDirectory);
        File[] jsonFiles = directory.listFiles((dir, name) -> name.endsWith(".json"));

        assertTrue(jsonFiles != null && jsonFiles.length > 0);

        for (File jsonFile : jsonFiles) {
            assertTrue(jsonFile.exists());
        }
    }
    @Test
    public void testConvertSpecificFileToJson() {
        String inputFilePath = "src/test/resources/data_1.txt";

        App.main(new String[]{inputFilePath});

        File jsonFile = new File(inputFilePath.replace(".txt", ".json"));

        assertTrue(jsonFile.exists());
    }
}
