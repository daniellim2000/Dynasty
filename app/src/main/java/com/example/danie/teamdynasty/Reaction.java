package com.example.danie.teamdynasty;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.danie.teamdynasty.Choice.ChoiceOptions;
import com.example.danie.teamdynasty.Choice.ChoiceOptions.*;

/**
 * Created by shihern on 11/8/2016.
 */
public final class Reaction {

    public static ArrayList<ChoiceOptions> GenerateChoices(Choice lastChoice) {
        ArrayList<ChoiceOptions> possibleChoiceOptions = new ArrayList<ChoiceOptions>();

        Choice.chosenChoiceOptions.add(lastChoice.getChoice());

        switch (lastChoice.getChoice()) {
            case A1:
                possibleChoiceOptions.add(ChoiceOptions.A2);
                possibleChoiceOptions.add(ChoiceOptions.B2);
                possibleChoiceOptions.add(ChoiceOptions.C2);
                possibleChoiceOptions.add(ChoiceOptions.E1);
                possibleChoiceOptions.add(ChoiceOptions.F1);
                possibleChoiceOptions.add(ChoiceOptions.B1);
                possibleChoiceOptions.add(ChoiceOptions.C1);
                possibleChoiceOptions.add(ChoiceOptions.D1);
                break;
            case B1:
                possibleChoiceOptions.add(ChoiceOptions.A2);
                possibleChoiceOptions.add(ChoiceOptions.B2);
                possibleChoiceOptions.add(ChoiceOptions.C2);
                possibleChoiceOptions.add(ChoiceOptions.D2);
                possibleChoiceOptions.add(ChoiceOptions.B1);
                possibleChoiceOptions.add(ChoiceOptions.C1);
                possibleChoiceOptions.add(ChoiceOptions.D1);
                break;
            case C1:
            case D1:
                possibleChoiceOptions.add(ChoiceOptions.A2);
                possibleChoiceOptions.add(ChoiceOptions.B2);
                possibleChoiceOptions.add(ChoiceOptions.C2);
                possibleChoiceOptions.add(ChoiceOptions.E1);
                possibleChoiceOptions.add(ChoiceOptions.F1);
                if(Choice.chosenChoiceOptions.contains(ChoiceOptions.B1)) {
                    possibleChoiceOptions.add(ChoiceOptions.D2);
                } else {
                    possibleChoiceOptions.add(ChoiceOptions.B1);
                }
                break;
            case E1:
                possibleChoiceOptions.add(ChoiceOptions.A2);
                possibleChoiceOptions.add(ChoiceOptions.B2);
                possibleChoiceOptions.add(ChoiceOptions.C2);
                if(Choice.chosenChoiceOptions.contains(ChoiceOptions.B1)) {
                    possibleChoiceOptions.add(ChoiceOptions.D2);
                } else {
                    possibleChoiceOptions.add(ChoiceOptions.B1);
                }
                break;
            case F1:
                possibleChoiceOptions.add(ChoiceOptions.B1);
                break;
            case C2:
                possibleChoiceOptions.add(ChoiceOptions.A2);
                possibleChoiceOptions.add(ChoiceOptions.B2);
        }

        return possibleChoiceOptions;
    }
}
