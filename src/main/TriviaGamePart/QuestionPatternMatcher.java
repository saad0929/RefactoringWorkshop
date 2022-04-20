package main.TriviaGamePart;

public interface QuestionPatternMatcher {
    boolean match(int number);
    String generateResponse();
}