package com.example.ishitorigame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView win;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button Reset;
    int lastplayer = 0;
    private int screenNo = 0;

    int stone = 19;
    ImageView[] imageView = new ImageView[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Title();
    }

    private void Title() {
        setContentView(R.layout.title);
    }

    private void altScreen() {
        if (screenNo == 0) {
            screenNo = 1;
            game();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {    // タップ終了？
            altScreen();        // 画面切り替え実行
        }
        return true;
    }

    private void game() {
        SE se = new SE(getApplicationContext());
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.daimei);
        textView2 = findViewById(R.id.tv2);
        win = findViewById(R.id.Win);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        Reset = findViewById(R.id.ResetButton);
        Reset.setVisibility(View.INVISIBLE);
        win.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        stone = 20;
        lastplayer = 0;
        for (int i = 0; i < 20; i++) {
            imageView[i] = findViewById(R.id.stone0 + i);
            imageView[i].setVisibility(View.VISIBLE);
        }
        if (stone >= 0) {
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    se.play(2);
                    stone--;
                    lastplayer = 0;
                    for (int i = 19; i >= 0; i--) {
                        if (imageView[i].getVisibility() == View.VISIBLE) {
                            imageView[i].setVisibility(View.INVISIBLE);
                            gameover();
                            break;
                        }
                    }
                    if (stone <= 0){
                        se.play(0);
                    }
                    button1.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    se.play(2);
                    stone--;
                    lastplayer = 1;
                    for (int j = 19; j >= 0; j--) {
                        if (imageView[j].getVisibility() == View.VISIBLE) {
                            imageView[j].setVisibility(View.INVISIBLE);
                            gameover();
                            break;
                        }
                    }
                    if (stone <= 0){
                        se.play(0);
                    }
                    button2.setVisibility(View.INVISIBLE);
                    button4.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    se.play(2);
                    stone -= 2;
                    lastplayer = 0;
                    for (int j = 19; j >= 0; j--) {
                        if (imageView[j].getVisibility() == View.VISIBLE) {
                            imageView[j].setVisibility(View.INVISIBLE);
                            gameover();
                            break;
                        }
                    }
                    for (int j = 19; j >= 0; j--) {
                        if (imageView[j].getVisibility() == View.VISIBLE) {
                            imageView[j].setVisibility(View.INVISIBLE);
                            gameover();
                            break;
                        }
                    }
                    if (stone <= 0){
                        se.play(0);
                    }
                    button1.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                }

            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    se.play(2);
                    stone -= 2;
                    lastplayer = 1;
                    for (int j = 19; j >= 0; j--) {
                        if (imageView[j].getVisibility() == View.VISIBLE) {
                            imageView[j].setVisibility(View.INVISIBLE);
                            gameover();
                            break;
                        }
                    }
                    for (int j = 19; j >= 0; j--) {
                        if (imageView[j].getVisibility() == View.VISIBLE) {
                            imageView[j].setVisibility(View.INVISIBLE);
                            gameover();
                            break;
                        }
                    }
                    if (stone <= 0){
                        se.play(0);
                    }
                    button2.setVisibility(View.INVISIBLE);
                    button4.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                }
            });
        }
    }

    public void gameover() {
        if (stone <= 0) {
            Reset.setVisibility(View.VISIBLE);
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            if (lastplayer == 0) {
                win.setText("Player2 Win!");
                win.setVisibility(View.VISIBLE);
            }
            if (lastplayer == 1) {
                win.setText("Player1 Win!");
                win.setVisibility(View.VISIBLE);
            }
            Reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < 20; i++) {
                        imageView[i] = findViewById(R.id.stone0 + i);
                        imageView[i].setVisibility(View.VISIBLE);
                    }
                    Reset.setVisibility(View.INVISIBLE);
                    win.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    stone = 20;
                    lastplayer = 0;
                }
            });
        }
    }
}






