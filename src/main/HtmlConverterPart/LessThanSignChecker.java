package main.HtmlConverterPart;

public class LessThanSignChecker implements SignChecker{
    public boolean matches(char character) {

        return character=='<';
    }
    public String addHtmlSign(){
        return "&gt;";
    }
}
