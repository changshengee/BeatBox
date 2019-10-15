package com.changsheng.beatbox;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BeatBox {
    public static final String Tag = "BeatBox";

    public static final String SOUNDS_FOLDER = "sample_sounds";

    public static final int MAX_SOUNDS =5;



    private AssetManager mAsset;

    private SoundPool mSoundPool;

    public List<Sound> getSounds() {
        return mSounds;
    }

    private List<Sound> mSounds = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public BeatBox(Context context) {
        mAsset = context.getAssets();
        mSoundPool=new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);

        listSounds();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void listSounds() {
        String[] soundNames;
        try {
            soundNames = mAsset.list(SOUNDS_FOLDER);
            Log.i(Tag, "Found " + Objects.requireNonNull(soundNames).length + " sounds");
            for (String filename : soundNames) {
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            }
        } catch (IOException e) {
            Log.e(Tag, "could not list assets", e);
        }

    }


    private void load(Sound sound) throws IOException {
        AssetFileDescriptor descriptor=mAsset.openFd(sound.getAssetPath());
        int soundId=mSoundPool.load(descriptor,1);
        sound.setSoundId(soundId);
    }

    public void play(Sound sound){
        Integer soundId=sound.getSoundId();
        if(soundId==null){
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }

    public void release(){
        mSoundPool.release();
    }


}
