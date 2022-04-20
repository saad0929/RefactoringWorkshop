package main.FizzBuzzPart;

import java.util.ArrayList;
import java.util.List;

public class TestFizzBuzz {
    public static void main(String[] args) {
        FizzPatternMatcher fizzPatternMatcher = new FizzPatternMatcher();
        BuzzPatternMatcher buzzPatternMatcher = new BuzzPatternMatcher();

        List<PatternMatcher> patternMatcherList = new ArrayList<>();
        patternMatcherList.add(fizzPatternMatcher);
        patternMatcherList.add(buzzPatternMatcher);

        NullResponse nullResponse = new NullResponse();

        FizzBuzz fizzBuzz = new FizzBuzz(patternMatcherList,nullResponse);

        String result = fizzBuzz.say(30);
        System.out.println("Result = "+result);
    }
}
