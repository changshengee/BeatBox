package com.changsheng.beatbox;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * @author changsheng
 */
public class BeatboxFragment extends Fragment {

    public static BeatboxFragment newInstance() {
        return new BeatboxFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_beat_box, container);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_beat_box_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(new SoundAdapter());
        return view;
    }

    private class SoundHolder extends RecyclerView.ViewHolder {
        private Button mButton;

        public SoundHolder(LayoutInflater inflater, @NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.list_item_sound_button);
        }


    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new SoundHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
