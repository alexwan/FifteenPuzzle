package ua.bringoff.developer.fifteenpuzzle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AboutActivity extends Activity {
    public static int COLOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tvAbout = (TextView) findViewById(R.id.about_text_view);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        tvAbout.setTypeface(typeface);

        SharedPreferences sharedPreferences = getSharedPreferences(PrefsActivity.APP_PREFERENCES, MODE_PRIVATE);
        COLOR = sharedPreferences.getInt(PrefsActivity.KEY_GAME_COLOR, getResources().getColor(R.color.orange_cool));
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.about_layout);
        layout.setBackgroundColor(COLOR);
    }

}
