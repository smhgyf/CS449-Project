package edu.umkc.smhgyf.storybuilder;

import android.content.DialogInterface;
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
    String stepOneString = "";
    String stepTwoString = "";
    String stepThreeString = "";
    String stepFourString = "";
    String stepFiveString = "";
    String stepSixString = "";
    int context = 1;
    boolean contextSwitched = false;
    boolean firstStepInitialized = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snowflake_novel);
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
            ideaText.setText(stepOneString);
        }
        else if (context == 2){
            builder.setMessage("Step " + Integer.toString(context) + ": Idea Expansion");
            builder.setTitle("Snowflake Method");
            ideaText.setText(stepTwoString);
        }
        else if (context == 3){
            builder.setMessage("Step " + Integer.toString(context) + ": Character Sheet");
            builder.setTitle("Snowflake Method");
            ideaText.setText(stepThreeString);
        }
        else if (context == 4){
            builder.setMessage("Step " + Integer.toString(context) + ": Novel Summary");
            builder.setTitle("Snowflake Method");
            ideaText.setText(stepFourString);
        }
        else if (context == 5){
            builder.setMessage("Step " + Integer.toString(context) + ": Character Synopsis");
            builder.setTitle("Snowflake Method");
            ideaText.setText(stepFiveString);
        }
        else if (context == 6) {
            builder.setMessage("Step " + Integer.toString(context) + ": Novel Summary Expansion");
            builder.setTitle("Snowflake Method");
            ideaText.setText(stepSixString);
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
        firstStepInitialized = true;
        stepOneButton = (Button) findViewById(R.id.step_idea);
        stepOneButton.setVisibility(View.VISIBLE);
        stepOneString = ideaText.getText().toString();
        ideaText.setText("");
    }
    public void displaySteps(){
        if (contextSwitched == false) {
            if (context == 1) {
                contextSwitched = true;
                stepTwoButton = (Button) findViewById(R.id.step_idea_expansion);
                stepTwoButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 2){
                stepTwoString = ideaText.getText().toString();
                ideaText.setText("");
                contextSwitched = true;
                stepThreeButton = (Button) findViewById(R.id.step_character_sheet);
                stepThreeButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 3){
                stepThreeString = ideaText.getText().toString();
                ideaText.setText("");
                contextSwitched = true;
                stepFourButton = (Button) findViewById(R.id.step_novel_summary);
                stepFourButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 4){
                stepFourString = ideaText.getText().toString();
                ideaText.setText("");
                contextSwitched = true;
                stepFiveButton = (Button) findViewById(R.id.step_character_summary);
                stepFiveButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context == 5){
                stepFiveString = ideaText.getText().toString();
                ideaText.setText("");
                contextSwitched = true;
                stepSixButton = (Button) findViewById(R.id.step_novel_summary_expansion);
                stepSixButton.setVisibility(View.VISIBLE);
            }
        }
        if (contextSwitched == false) {
            if (context ==  6){
                stepSixString = ideaText.getText().toString();
                ideaText.setText("");
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
}
