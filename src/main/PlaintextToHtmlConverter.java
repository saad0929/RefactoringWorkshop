package main;

import main.CharacterConverter;

import javax.management.StringValueExp;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
  
    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    private String read() throws IOException {
    	Path filePath = Paths.get("sample.txt");
    	byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        
        int i = 0;
        List<String> result = new ArrayList<>();
        PlaintextToHtmlConverter plaintextToHtmlConverter =  new PlaintextToHtmlConverter();
        List<String> convertedLine = new ArrayList<>();
        CharacterConverter characterConverter;
       // String characterToConvert = stashNextCharacterAndAdvanceThePointer(source);
        for (char characterToConvert : source.toCharArray()) {
            characterConverter = new CharacterConverter(plaintextToHtmlConverter,characterToConvert,convertedLine,result);

        }
        addANewLine(result,convertedLine);
        String finalResult = String.join("<br />", result);
        return finalResult;
    }


    public void addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    public void pushACharacterToTheOutput(List<String> convertedLine, String characterToConvert) {
        convertedLine.add(characterToConvert);
    }
}
