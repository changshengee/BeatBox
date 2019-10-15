package com.changsheng.beatbox;

import android.content.Intent;

public class Sound {
    private String mAssetPath;
    private String mName;

    private Integer mSoundId;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav", "");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public void setAssetPath(String assetPath) {
        mAssetPath = assetPath;
    }


    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }


    public Integer getSoundId() {
        return mSoundId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
