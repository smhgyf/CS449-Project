package edu.umkc.smhgyf.storybuilder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AlertDialog;
import java.lang.String;

/**
 * Created by Sean on 2/26/2018.
 * Made to for the purpose of
 * Opening the various dialogue boxes
 * We'll need throughout the app.
 * Felt a little smelly to have main
 * opening dialogues and dialogues
 * opening dialogues, etc.
 */

public class DialogueOpener extends AppCompatActivity {
    EditText ideaText;
    Button stepOneButton;
    Button stepTwoButton;
    Button stepThreeButton;
    Button stepFourButton;
    Button stepFiveButton;
    Button stepSixButton;
    Button stepSevenButton;
    Button stepEightButton;
    Button stepNineButton;
    Button stepTenButton;
    String stepOneString = "";
    String stepTwoString = "";
    String stepThreeString = "";
    String stepFourString = "";
    String stepFiveString = "";
    String stepSixString = "";
    String stepSevenString = "";
    String stepEightString = "";
    String stepNineString = "";
    String stepTenString = "";
    int context = 1;
    int novelContext = 0;
    boolean contextSwitched = false;
    boolean firstStepInitialized = false;
    boolean isSavedInstance = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowflake_novel);
        novelContext = getContext();
        if (novelContext > 0){
            isSavedInstance = true;
        }
        if (isSavedInstance == true){
            loadNovel();
        }
        openStepDialogue();
    }
    public void openStepDialogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_step, null);
        ideaText = (EditText) view.findViewById(R.id.idea_text);

        if (context == 1){
            builder.setMessage("Step " + Integer.toString(context) + ": Idea");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 2){
            builder.setMessage("Step " + Integer.toString(context) + ": Idea Expansion");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 3){
            builder.setMessage("Step " + Integer.toString(context) + ": Character Sheet");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 4){
            builder.setMessage("Step " + Integer.toString(context) + ": Novel Summary");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 5){
            builder.setMessage("Step " + Integer.toString(context) + ": Character Synopsis");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 6) {
            builder.setMessage("Step " + Integer.toString(context) + ": Novel Summary Expansion");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 7) {
            builder.setMessage("Step " + Integer.toString(context) + ": Character Summary Expansion");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 8) {
            builder.setMessage("Step " + Integer.toString(context) + ": Scene Layout");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 9) {
            builder.setMessage("Step " + Integer.toString(context) + ": Scene Expansion");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        else if (context == 10) {
            builder.setMessage("Step " + Integer.toString(context) + ": First Draft");
            builder.setTitle("Snowflake Method");
            ideaText.setText(getStepText());
        }
        builder.setView(view)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (firstStepInitialized == false){
                            initializeFirstStep();
                            displaySteps();
                        }
                        else {
                            displaySteps();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    public void initializeFirstStep() {
        stepOneButton = (Button) findViewById(R.id.step_idea);
        stepOneButton.setVisibility(View.VISIBLE);
        stepOneString = ideaText.getText().toString();
        ideaText.setText("");
        saveStepText();
    }
    public void displaySteps(){
        if (contextSwitched == false) {
            if (context == 1) {
                if (firstStepInitialized == true){
                    stepOneString = ideaText.getText().toString();
                    ideaText.setText("");
                    saveStepText();
                }
                else {
                    firstStepInitialized = true;
                }
                contextSwitched = true;
                stepTwoButton = (Button) findViewById(R.id.step_idea_expansion);
                stepTwoButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 2){
                stepTwoString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepThreeButton = (Button) findViewById(R.id.step_character_sheet);
                stepThreeButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 3){
                stepThreeString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepFourButton = (Button) findViewById(R.id.step_novel_summary);
                stepFourButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 4){
                stepFourString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepFiveButton = (Button) findViewById(R.id.step_character_summary);
                stepFiveButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 5){
                stepFiveString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepSixButton = (Button) findViewById(R.id.step_novel_summary_expansion);
                stepSixButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context ==  6){
                stepSixString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepSevenButton = (Button) findViewById(R.id.step_character_summary_expansion);
                stepSevenButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context ==  7){
                stepSevenString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepEightButton = (Button) findViewById(R.id.step_scene_layout);
                stepEightButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context ==  8){
                stepEightString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepNineButton = (Button) findViewById(R.id.step_scene_expansion);
                stepNineButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context ==  9){
                stepNineString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
                stepTenButton = (Button) findViewById(R.id.step_first_draft);
                stepTenButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context ==  10){
                stepTenString = ideaText.getText().toString();
                ideaText.setText("");
                saveStepText();
                contextSwitched = true;
            }
        }
    }
    public void updateStepOne(View view){
        context = 1;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepTwo(View view){
        context = 2;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepThree(View view){
        context = 3;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepFour(View view){
        context = 4;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepFive(View view){
        context = 5;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepSix(View view){
        context = 6;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepSeven(View view){
        context = 7;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepEight(View view){
        context = 8;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepNine(View view){
        context = 9;
        contextSwitched = false;
        openStepDialogue();
    }
    public void updateStepTen(View view){
        context = 10;
        contextSwitched = false;
        openStepDialogue();
    }
    public void saveStepText(){
        if (context == 1) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepOneString", stepOneString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 2) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepTwoString", stepTwoString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 3) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepThreeString", stepThreeString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 4) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepFourString", stepFourString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 5) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepFiveString", stepFiveString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 6) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepSixString", stepSixString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 7) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepSevenString", stepSevenString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 8) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepEightString", stepEightString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 9) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepNineString", stepNineString);
            fileEditor.apply();
            saveContext(context);
        }
        if (context == 10) {
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            SharedPreferences.Editor fileEditor = stepsFile.edit();
            fileEditor.putString("stepTenString", stepTenString);
            fileEditor.apply();
            saveContext(context);
        }

    }
    public String getStepText(){
        if (context == 1){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepOneString", "");
        }
        if (context == 2){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepTwoString", "");
        }
        if (context == 3){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepThreeString", "");
        }
        if (context == 4){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepFourString", "");
        }
        if (context == 5){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepFiveString", "");
        }
        if (context == 6){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepSixString", "");
        }
        if (context == 7){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepSevenString", "");
        }
        if (context == 8){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepEightString", "");
        }
        if (context == 9){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepNineString", "");
        }
        if (context == 10){
            SharedPreferences stepsFile = getSharedPreferences("steps", Context.MODE_PRIVATE);
            return stepsFile.getString("stepTenString", "");
        }
        return "";
    }
    public void saveContext(int novelContext) {
        SharedPreferences contextFile = getSharedPreferences("context", Context.MODE_PRIVATE);
        SharedPreferences.Editor fileEditor = contextFile.edit();
        fileEditor.putInt("novelContext", novelContext);
        fileEditor.apply();
    }
    public int getContext(){
        SharedPreferences contextFile = getSharedPreferences("context", Context.MODE_PRIVATE);
        return contextFile.getInt("novelContext", 0);
    }
    public void loadNovel(){
        stepOneButton = (Button) findViewById(R.id.step_idea);
        stepTwoButton = (Button) findViewById(R.id.step_idea_expansion);
        stepThreeButton = (Button) findViewById(R.id.step_character_sheet);
        stepFourButton = (Button) findViewById(R.id.step_novel_summary);
        stepFiveButton = (Button) findViewById(R.id.step_character_summary);
        stepSixButton = (Button) findViewById(R.id.step_novel_summary_expansion);
        stepSevenButton = (Button) findViewById(R.id.step_character_summary_expansion);
        stepEightButton = (Button) findViewById(R.id.step_scene_layout);
        stepNineButton = (Button) findViewById(R.id.step_scene_expansion);
        stepTenButton = (Button) findViewById(R.id.step_first_draft);
        if (novelContext > 0) {
            stepOneButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 1) {
            stepTwoButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 2) {
            stepThreeButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 3) {
            stepFourButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 4) {
            stepFiveButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 5) {
            stepSixButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 6) {
            stepSevenButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 7) {
            stepEightButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 8) {
            stepNineButton.setVisibility(View.VISIBLE);
        }
        if (novelContext > 9) {
            stepTenButton.setVisibility(View.VISIBLE);
        }
    }
}
