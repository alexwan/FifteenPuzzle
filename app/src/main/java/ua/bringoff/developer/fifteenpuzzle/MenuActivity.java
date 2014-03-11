package ua.bringoff.developer.fifteenpuzzle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuActivity extends Activity {

    public static int COLOR = 0;

    Button btnNewGame;
    Button btnPreferences;
    Button btnAbout;

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        layout = (LinearLayout) findViewById(R.id.menu_layout);
        Display display = getWindowManager().getDefaultDisplay();
        Point screenSize = new Point();
        display.getSize(screenSize);

        Typeface fontFace = Typeface.createFromAsset(getAssets(), "fonts/DROID.TTF");

        btnNewGame = (Button) findViewById(R.id.button_new_game);
        btnNewGame.setWidth((int) Math.round(screenSize.x / 1.5));
        btnNewGame.setTypeface(fontFace);

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, GameBoardActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnPreferences = (Button) findViewById(R.id.button_preferences);
        btnPreferences.setWidth((int) Math.round(screenSize.x / 1.5));
        btnPreferences.setTypeface(fontFace);
        btnPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, PrefsActivity.class);
                startActivity(intent);
            }
        });

        btnAbout = (Button) findViewById(R.id.button_about);
        btnAbout.setWidth((int) Math.round(screenSize.x / 1.5));
        btnAbout.setTypeface(fontFace);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences(PrefsActivity.APP_PREFERENCES, MODE_PRIVATE);
        int color = sharedPreferences.getInt(PrefsActivity.KEY_GAME_COLOR, getResources().getColor(R.color.orange_cool));
        if (COLOR != color) {
            COLOR = color;
        }
        layout.setBackgroundColor(COLOR);
        btnNewGame.setBackgroundColor(COLOR);
        btnPreferences.setBackgroundColor(COLOR);
        btnAbout.setBackgroundColor(COLOR);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);

        btnNewGame.startAnimation(animation);
        btnPreferences.startAnimation(animation);
        btnAbout.startAnimation(animation);
    }
}
