package main.HtmlConverterPart;

public class GreaterThanSignChecker implements SignChecker{
    public boolean matches(char character) {

        return character=='>';
    }
    public String addHtmlSign(){
        return "&lt;";
    }
}
