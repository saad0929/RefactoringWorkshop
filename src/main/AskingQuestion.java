package main;

import java.util.ArrayList;
import java.util.LinkedList;

public class AskingQuestion {
    ArrayList<LinkedList> questionList;
    String currentCategory;
    public AskingQuestion(ArrayList<LinkedList> questionList, String currentCategory) {
        this.questionList = questionList;
        this.currentCategory = currentCategory;
    }

    void askQuestion() {
        if (currentCategory == "Pop")
            announce(questionList.get(0).removeFirst());
        if (currentCategory == "Science")
            announce(questionList.get(1).removeFirst());
        if (currentCategory == "Sports")
            announce(questionList.get(2).removeFirst());
        if (currentCategory == "Rock")
            announce(questionList.get(3).removeFirst());
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}
