package com.laacompany.colouringproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextRed;
    private TextView mTextBlue;
    private TextView mTextGreen;

    private SeekBar mSeekBarRed;
    private SeekBar mSeekBarGreen;
    private SeekBar mSeekBarBlue;



    private TextView mTextViewResult;
//    private Button mButtonGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.id_tv_result);
        mTextRed = findViewById(R.id.id_tv_red);
        mTextBlue = findViewById(R.id.id_tv_blue);
        mTextGreen = findViewById(R.id.id_tv_green);

        mSeekBarRed = findViewById(R.id.id_sb_red);
        mSeekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int r,g,b;
                r = desToRGB(progress);
                g = desToRGB(mSeekBarGreen.getProgress());
                b = desToRGB(mSeekBarBlue.getProgress());
                mTextViewResult.setBackgroundColor(Color.rgb(r,g,b));
                mTextRed.setText(String.valueOf(r));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSeekBarGreen = findViewById(R.id.id_sb_green);
        mSeekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int r,g,b;
                r = desToRGB(mSeekBarRed.getProgress());
                g = desToRGB(progress);
                b = desToRGB(mSeekBarBlue.getProgress());
                mTextViewResult.setBackgroundColor(Color.rgb(r,g,b));
                mTextGreen.setText(String.valueOf(g));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mSeekBarBlue = findViewById(R.id.id_sb_blue);
        mSeekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int r,g,b;
                r = desToRGB(mSeekBarRed.getProgress());
                g = desToRGB(mSeekBarGreen.getProgress());
                b = desToRGB(progress);
                mTextViewResult.setBackgroundColor(Color.rgb(r,g,b));
                mTextBlue.setText(String.valueOf(b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mTextViewResult.setBackgroundColor(Color.rgb(0,0,0));
        mTextRed.setText("0");
        mTextBlue.setText("0");
        mTextGreen.setText("0");
    }

    private int desToRGB (int a){
        return (int) (a * ((float)255/100));
    }
}
