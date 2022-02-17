package main;

import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */
public class FizzBuzz {
	private List<PatternMatcher> patternMatchers;
	private NullResponse nullObjectPattern;
    public FizzBuzz(List<PatternMatcher> patternMatchers, NullResponse nullObjectPattern) {
		super();
		this.patternMatchers = patternMatchers;
		this.nullObjectPattern = nullObjectPattern;
	}

	public String say(int number) {
        String strReturn = nullObjectPattern.generateResponse();
        
        for (PatternMatcher patternMatcher : patternMatchers) {
        	if (patternMatcher.matches(number)) strReturn = patternMatcher.generateResponse();
		}
          
        return strReturn;
    }
}
