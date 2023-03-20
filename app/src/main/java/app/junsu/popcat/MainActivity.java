package app.junsu.popcat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgMainPopCat;
    TextView tvMainCounter;

    Long clickCount = 0L;

    SoundPool popSound;
    int popSoundId;

    Vibrator vibrator;

    @SuppressWarnings("deprecation")
    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popSound = new SoundPool.Builder().build();
        popSoundId = popSound.load(this, R.raw.raw_pop, 1);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        imgMainPopCat = findViewById(R.id.img_main_popcat);
        tvMainCounter = findViewById(R.id.tv_main_counter);

        imgMainPopCat.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case (MotionEvent.ACTION_UP):
                    this.imgMainPopCat.setImageResource(R.drawable.img_popcat_default);
                    return true;
                case (MotionEvent.ACTION_DOWN):
                    this.imgMainPopCat.setImageResource(R.drawable.img_popcat_popped);

                    popSound.play(popSoundId, 1f, 1f, 0, 0, 1f);
                    vibrator.vibrate(50);

                    clickCount++;
                    tvMainCounter.setText(clickCount.toString());
                    return true;
            }
            return false;
        });
    }
}