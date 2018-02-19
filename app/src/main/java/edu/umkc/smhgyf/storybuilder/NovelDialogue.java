package edu.umkc.smhgyf.storybuilder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;




/**
 * Created by Sean on 2/14/2018.
 */

public class NovelDialogue extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("New Novel");
        builder.setMessage("Do you want to build a novel using the snowflake method?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Will open an idea dialogue.
                        DialogFragment firstStepDialog = new StepDialogue();
                        firstStepDialog.show(getActivity().getSupportFragmentManager(),"firstStepDialogue");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}