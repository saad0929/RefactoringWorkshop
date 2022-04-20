package main.TriviaGamePart;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergedQuestionList {
    String playerName;
    ArrayList<LinkedList> questionList = new ArrayList<>(4);
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public MergedQuestionList(LinkedList popQuestions, LinkedList scienceQuestions, LinkedList sportsQuestions, LinkedList rockQuestions) {
        this.popQuestions = popQuestions;
        this.scienceQuestions = scienceQuestions;
        this.sportsQuestions = sportsQuestions;
        this.rockQuestions = rockQuestions;
    }

    public ArrayList<LinkedList> mergeQuestions(){
        questionList.add(popQuestions);
        questionList.add(scienceQuestions);
        questionList.add(sportsQuestions);
        questionList.add(rockQuestions);

        return questionList;
    }
}
