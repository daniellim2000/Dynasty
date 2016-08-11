package com.example.danie.teamdynasty;

import java.util.ArrayList;

/**
 * Created by shihern on 11/8/2016.
 */
public class Choice {

    public static ArrayList<ChoiceOptions> chosenChoiceOptions;

    private ChoiceOptions currentChoice;

    public enum ChoiceOptions {
        A1, B1, C1, D1, E1, F1, A2, B2, C2, D2
    }

    public Choice(ChoiceOptions choice) {
        currentChoice = choice;
    }

    public ChoiceOptions getChoice() {
        return currentChoice;
    }
}
