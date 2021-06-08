package com.ishra.video_view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final VideoView videoView = findViewById(R.id.videoview);
        final VideoView videoView2 = findViewById(R.id.videoview2);
        if (videoView != null) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.a;
            videoView.setVideoURI(Uri.parse(path));
        }
        if (videoView2 != null) {
            String path = "android.resource://" + getPackageName() + "/" + R.raw.b;
            videoView2.setVideoURI(Uri.parse(path));
        }
        final Button button = findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (videoView != null) {
                        boolean isPlaying = videoView.isPlaying();
                        button.setText(isPlaying ? R.string.play : R.string.pause);

                        String msg = getString(isPlaying ? R.string.paused : R.string.playing);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        if (isPlaying) {
                            videoView.pause();
                        } else {
                            videoView.start();
                        }
                    }
                    if (videoView == null) {
                        boolean isPlaying = videoView2.isPlaying();
                        button.setText(isPlaying ? R.string.play : R.string.pause);

                        String msg = getString(isPlaying ? R.string.paused : R.string.playing);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                        if (isPlaying) {
                            videoView2.pause();
                        } else {
                            videoView2.start();
                        }
                    }
                    //}
                }
            });
        }
    }
}
