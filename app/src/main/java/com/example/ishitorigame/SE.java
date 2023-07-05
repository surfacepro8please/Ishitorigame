package com.example.ishitorigame;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SE {
    private SoundPool soundPool;

    private int soundFiles[] = {
            R.raw.se,R.raw.dummy,R.raw.select
    };

    public SE(Context context){
        soundPool = new SoundPool(soundFiles.length, AudioManager.STREAM_MUSIC,0);
        for (int i = 0; i < soundFiles.length; i++) {
            soundPool.load(context,soundFiles[i],1);
        }

    }
    public void play(int soundId){
        soundPool.play(soundId+1,1.0f,1.0f,0,0,1.0f);

    }
}
