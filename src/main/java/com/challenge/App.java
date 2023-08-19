package com.challenge;

import com.challenge.services.InputParser;
import com.challenge.services.InputParserFactory;
import com.challenge.services.TextToJsonConverter;
import com.challenge.services.InputParserFactory.Format;

public class App
{
    public static void main( String[] args )
    {
        InputParser parser = InputParserFactory.createParser(Format.TEXT);

        TextToJsonConverter converter = new TextToJsonConverter(parser);


        String inputFilePath = "src/test/resources/data_1.txt";
        String json = converter.convertToJson(inputFilePath);

        System.out.println( json );
    }
}
