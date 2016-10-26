// Brenna Pavlinchak
// MDF3 - 1605
// Media Player Fragment

package com.example.ravenmargret.exercise05;


import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

public class MediaPlayerFragment extends Fragment
{
    private MediaPlayer player = null;
    private MusicService musicService;
    private Intent playIntent;
    private boolean musicIsBound = false;

    public MediaPlayerFragment()
    {
        // Required empty public constructor
    }

    private ServiceConnection musicConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            MusicService musicBind = (MusicService)service;
            musicService = musicBind.getService();
            musicIsBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            musicIsBound = false;
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_media_player, container, false);
    }
}
