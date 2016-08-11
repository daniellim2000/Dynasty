package com.example.danie.teamdynasty;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.danie.teamdynasty.Choice.ChoiceOptions;
import com.example.danie.teamdynasty.Choice.ChoiceOptions.*;

/**
 * Created by shihern on 11/8/2016.
 */
public class Reaction {

    public enum ReactionOptions {
        A1BottleUp, B1TellCher, C1ConfrontOnline, D1ConfrontIRL, E1TellClassFriend, F1TellBestFriend, A2Depressed, B2Revenge, C2Ignore, D2TellCherAgain
    }

    public static ArrayList<ChoiceOptions> generateChoices(Choice lastChoice) {
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
            case C2:
                possibleChoiceOptions.add(ChoiceOptions.A2);
                possibleChoiceOptions.add(ChoiceOptions.B2);
                break;
            default:
                possibleChoiceOptions.add(ChoiceOptions.NoChoice);
        }

        return possibleChoiceOptions;
    }

    public ReactionOptions generateReactions(Choice choice) {
        switch (choice.getChoice()) {
            case A1:
                return ReactionOptions.A1BottleUp;
            case B1:
                return ReactionOptions.B1TellCher;
            case C1:
                return ReactionOptions.C1ConfrontOnline;
            case D1:
                return ReactionOptions.D1ConfrontIRL;
            case E1:
                return ReactionOptions.E1TellClassFriend;
            case F1:
                return ReactionOptions.F1TellBestFriend;
            case A2:
                return ReactionOptions.A2Depressed;
            case B2:
                return ReactionOptions.B2Revenge;
            case C2:
                return ReactionOptions.C2Ignore;
            case D2:
                return ReactionOptions.D2TellCherAgain;
            default:
                return null;
        }
    }
}
