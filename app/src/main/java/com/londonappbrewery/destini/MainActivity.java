package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mTextViewStory;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextViewStory = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mStoryIndex) {
                    case 1:
                    case 2:
                        mTextViewStory.setText(R.string.T3_Story);
                        mButtonTop.setText(R.string.T3_Ans1);
                        mButtonBottom.setText(R.string.T3_Ans2);
                        mStoryIndex = 3;
                        break;
                    case 3:
                        mTextViewStory.setText(R.string.T6_End);
                        restartOrQuit();
                        mStoryIndex = 0;
                        break;
                    default:
                        mTextViewStory.setText(R.string.T1_Story);
                        mButtonTop.setText(R.string.T1_Ans1);
                        mButtonBottom.setText(R.string.T1_Ans2);
                        mStoryIndex = 1;
                        break;
                }
            }
        });
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mTextViewStory.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    mTextViewStory.setText(R.string.T4_End);
                    restartOrQuit();
                    mStoryIndex = 0;
                } else if (mStoryIndex == 3) {
                    mTextViewStory.setText(R.string.T5_End);
                    restartOrQuit();
                    mStoryIndex = 0;
                } else {
                    quitApp();
                }
            }
        });
    }

    private void restartOrQuit() {
        mButtonTop.setText(R.string.Start_Again);
        mButtonBottom.setText(R.string.Quit);
    }
    private void quitApp() {
        Log.d("BH","quit app");
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);
        alert.setTitle("Thaat's all folks!");
        alert.setMessage("See you next time");
        alert.setPositiveButton("Close app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }
}
