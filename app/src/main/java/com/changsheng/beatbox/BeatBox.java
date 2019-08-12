package com.changsheng.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
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

    private AssetManager mAsset;

    public List<Sound> getSounds() {
        return mSounds;
    }

    private List<Sound> mSounds = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public BeatBox(Context context) {
        mAsset = context.getAssets();
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
                mSounds.add(sound);
            }
        } catch (IOException e) {
            Log.e(Tag, "could not list assets", e);
        }

    }
}
