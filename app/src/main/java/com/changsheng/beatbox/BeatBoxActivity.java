package com.changsheng.beatbox;

import androidx.fragment.app.Fragment;

/**
 * @author changsheng
 */
public class BeatBoxActivity extends BaseSingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return BeatboxFragment.newInstance();
    }
}
