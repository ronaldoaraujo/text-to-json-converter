package com.challenge;

import com.challenge.services.InputParser;
import com.challenge.services.InputParserFactory;
import com.challenge.services.TextParserFactory;
import com.challenge.services.TextToJsonConverter;

public class App
{
    public static void main( String[] args )
    {

        InputParserFactory parserFactory = new TextParserFactory();
        InputParser parser = parserFactory.createParser();

        TextToJsonConverter converter = new TextToJsonConverter(parser);


        String inputFilePath = "src/test/resources/data_1.txt";
        String json = converter.convertToJson(inputFilePath);

        System.out.println( json );
    }
}
