package com.pallab.androidpipmode;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.PictureInPictureParams;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button enter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getActionBar();
        enter = findViewById(R.id.button);
        enter.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Display d = getWindowManager().getDefaultDisplay();
                Point p = new Point();
                d.getSize(p);
                int width = p.x;
                int height = p.y;

                Rational ratio = new Rational(width, height);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    PictureInPictureParams.Builder pip_Builder = new PictureInPictureParams.Builder();
                    pip_Builder.setAspectRatio(ratio).build();
                    enterPictureInPictureMode(pip_Builder.build());
                }

            }
        });
    }
}