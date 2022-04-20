package main.TriviaGamePart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TriviaGame {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    List<QuestionPatternMatcher> questionPatternMatcherList;
    Question currentQuestion;
    Player currentPlayerObj;
    int currentPlayer = 0;

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    ArrayList<Question> questionList ;
    MergedQuestionList mergedQuestionList;
    boolean isGettingOutOfPenaltyBox;
    AskingQuestion askingQuestion = new AskingQuestion(questionList,currentCategory());

    public TriviaGame() {
        addQuestionType("Rock");
        addQuestionType("Sports");
        addQuestionType("Science");
        addQuestionType("Pop");
        questionPatternMatcherList = Arrays.asList(
                new PopQuestionPatternMatcher(),
                new ScienceQuestionPatternMatcher(),
                new SportsQuestionPatternMatcher(),
                new RockQuestionPatternMatcher()
        );
    }
    public void addQuestionType(String questionType) {
        questionList.add(new Question(questionType));
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean add(String playerName) {


        players.add(playerName);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        announce(playerName + " was added");
        announce("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        announce(players.get(currentPlayer) + " is the current player");
        announce("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                announce(players.get(currentPlayer) + " is getting out of the penalty box");
                places[currentPlayer] = places[currentPlayer] + roll;
                if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

                announce(players.get(currentPlayer)
                        + "'s new location is "
                        + places[currentPlayer]);
                announce("The category is " + currentCategory());
                //askingQuestion.askQuestion();
            } else {
                announce(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {

            places[currentPlayer] = places[currentPlayer] + roll;
            if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

            announce(players.get(currentPlayer)
                    + "'s new location is "
                    + places[currentPlayer]);
            announce("The category is " + currentCategory());
           // askingQuestion.askQuestion();
        }

    }

    private void getCurrentQuestion() {
        for (Question question : questionList) {
            for (QuestionPatternMatcher questionPatternMatcher : questionPatternMatcherList) {
                if (questionPatternMatcher.match(currentPlayerObj.getPlace())) {
                    if (questionPatternMatcher.generateResponse().equals(question.getQuestion_type())) {
                        currentQuestion = question;
                        break;
                    }
                }
            }
        }
    }




    private String currentCategory() {
        if (places[currentPlayer] == 0) return "Pop";
        if (places[currentPlayer] == 4) return "Pop";
        if (places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1) return "Science";
        if (places[currentPlayer] == 5) return "Science";
        if (places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2) return "Sports";
        if (places[currentPlayer] == 6) return "Sports";
        if (places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

    public boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                announce("Answer was correct!!!!");
                purses[currentPlayer]++;
                announce(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }


        } else {

            announce("Answer was correct!!!!");
            purses[currentPlayer]++;
            announce(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }


    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}