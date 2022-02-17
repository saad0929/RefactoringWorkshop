package main;

import main.PlaintextToHtmlConverter;

import java.util.List;

public class CharacterConverter {
    PlaintextToHtmlConverter plaintextToHtmlConverter =  new PlaintextToHtmlConverter();
    char characterToConvert;
    List<String> convertedLine;
    List<String> result;

    public CharacterConverter(PlaintextToHtmlConverter plaintextToHtmlConverter, char characterToConvert, List<String> convertedLine, List<String> result) {
        this.plaintextToHtmlConverter = plaintextToHtmlConverter;
        this.characterToConvert = characterToConvert;
        this.convertedLine = convertedLine;
        this.result = result;
    }

    public void converter(){
        switch ("c") {
            case "<":
                convertedLine.add("&lt;");
                break;
            case ">":
                convertedLine.add("&gt;");
                break;
            case "&":
                convertedLine.add("&amp;");
                break;
            case "\n":
                plaintextToHtmlConverter.addANewLine(result,convertedLine);
                break;
            default:
                plaintextToHtmlConverter.pushACharacterToTheOutput(convertedLine, String.valueOf(characterToConvert));
        }
    }


}
