package edu.umkc.smhgyf.storybuilder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button novelButton;
    String novelStorage;
    int savedNovels;
    String novelOneStorage;
    String novelTwoStorage;
    String novelThreeStorage;
    String novelFourStorage;
    String novelFiveStorage;
    String novelSixStorage;
    String novelSevenStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        novelButton = (Button) findViewById(R.id.loadNovelButton);
        savedNovels = checkSavedNovels();

        if (savedNovels > 0){
            novelButton.setVisibility(View.VISIBLE);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogue();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void openDialogue(){
        AlertDialog.Builder novelDialog = new AlertDialog.Builder(this);
        novelDialog.setTitle("New Novel");

        novelDialog
                .setMessage("Do you want to build a novel using the Snowflake Method?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        NovelController novelController = new NovelController();
                        novelController.saveNovel();
                        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
                        novel.putExtra("novelStorageContext", "");
                        startActivity(novel);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = novelDialog.create();
        alertDialog.show();
        }

    public void openSavedNovel(View view){
        LayoutInflater inflater = this.getLayoutInflater();
        View inflatedView = inflater.inflate(R.layout.saved_novels, null);
        int novelCount = 0;
        SharedPreferences novelCountFile = getSharedPreferences("novelCount", Context.MODE_PRIVATE);
        novelCount = novelCountFile.getInt("count",0);

        for(int i=0; i<=novelCount; i++){
            String novelTitle = "";
            if (i > 0) {
                novelStorage = "Novel " + String.valueOf(i);
                SharedPreferences novelFile = getSharedPreferences(novelStorage, Context.MODE_PRIVATE);
                novelTitle = novelFile.getString("novelTitleString", "");
            }

            if (i == 1) {
                novelButton = (Button) inflatedView.findViewById(R.id.novel1);
                novelButton.setText(novelTitle);
                novelButton.setVisibility(View.VISIBLE);
                novelOneStorage = novelStorage;
            }
            if (i == 2) {
                novelButton = (Button) inflatedView.findViewById(R.id.novel2);
                novelButton.setText(novelTitle);
                novelButton.setVisibility(View.VISIBLE);
                novelTwoStorage = novelStorage;
            }
            if (i == 3) {
                novelButton = (Button) inflatedView.findViewById(R.id.novel3);
                novelButton.setText(novelTitle);
                novelButton.setVisibility(View.VISIBLE);
                novelThreeStorage = novelStorage;
            }
            if (i == 4) {
                novelButton = (Button) inflatedView.findViewById(R.id.novel4);
                novelButton.setText(novelTitle);
                novelButton.setVisibility(View.VISIBLE);
                novelFourStorage = novelStorage;
            }
            if (i == 5) {
                novelButton = (Button) inflatedView.findViewById(R.id.novel5);
                novelButton.setText(novelTitle);
                novelButton.setVisibility(View.VISIBLE);
                novelFiveStorage = novelStorage;
            }
            if (i == 6) {
                novelButton = (Button) inflatedView.findViewById(R.id.novel6);
                novelButton.setText(novelTitle);
                novelButton.setVisibility(View.VISIBLE);
                novelSixStorage = novelStorage;
            }
            if (i == 7) {
                novelButton = (Button) inflatedView.findViewById(R.id.novel7);
                novelButton.setText(novelTitle);
                novelButton.setVisibility(View.VISIBLE);
                novelSevenStorage = novelStorage;
            }
        }

        AlertDialog.Builder savedNovelsDialog = new AlertDialog.Builder(this);
        savedNovelsDialog.setTitle("Saved Novels");
        savedNovelsDialog.setMessage("Please Choose a Saved Novel:");

        savedNovelsDialog.setView(inflatedView)
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = savedNovelsDialog.create();
        alertDialog.show();
    }

    public void openNovelOneActivity(View view) {
        NovelController novelController = new NovelController();
        novelController.saveNovel();
        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
        novel.putExtra("novelStorageContext", novelOneStorage);
        startActivity(novel);
    }
    public void openNovelTwoActivity(View view) {
        NovelController novelController = new NovelController();
        novelController.saveNovel();
        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
        novel.putExtra("novelStorageContext", novelTwoStorage);
        startActivity(novel);
    }
    public void openNovelThreeActivity(View view) {
        NovelController novelController = new NovelController();
        novelController.saveNovel();
        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
        novel.putExtra("novelStorageContext", novelThreeStorage);
        startActivity(novel);
    }
    public void openNovelFourActivity(View view) {
        NovelController novelController = new NovelController();
        novelController.saveNovel();
        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
        novel.putExtra("novelStorageContext", novelFourStorage);
        startActivity(novel);
    }
    public void openNovelFiveActivity(View view) {
        NovelController novelController = new NovelController();
        novelController.saveNovel();
        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
        novel.putExtra("novelStorageContext", novelFiveStorage);
        startActivity(novel);
    }
    public void openNovelSixActivity(View view) {
        NovelController novelController = new NovelController();
        novelController.saveNovel();
        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
        novel.putExtra("novelStorageContext", novelSixStorage);
        startActivity(novel);
    }
    public void openNovelSevenActivity(View view) {
        NovelController novelController = new NovelController();
        novelController.saveNovel();
        Intent novel = new Intent(MainActivity.this, DialogueOpener.class);
        novel.putExtra("novelStorageContext", novelSevenStorage);
        startActivity(novel);
    }
    public int checkSavedNovels(){
        SharedPreferences novelCountFile = getSharedPreferences("novelCount", Context.MODE_PRIVATE);
        return novelCountFile.getInt("count",0);
    }
}
