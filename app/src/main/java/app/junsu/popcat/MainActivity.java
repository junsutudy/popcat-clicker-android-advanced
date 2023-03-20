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

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    ImageView imgMainPopCat;
    TextView tvMainCounter;

    LottieAnimationView vMainAnimation1;
    LottieAnimationView vMainAnimation2;
    LottieAnimationView vMainAnimation3;
    LottieAnimationView vMainAnimation4;
    LottieAnimationView vMainAnimation5;
    LottieAnimationView vMainAnimation6;
    LottieAnimationView vMainAnimation7;
    LottieAnimationView vMainAnimation8;
    LottieAnimationView vMainAnimation9;
    LottieAnimationView vMainAnimation10;

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

        vMainAnimation1 = findViewById(R.id.v_main_animation_1);
        vMainAnimation2 = findViewById(R.id.v_main_animation_2);
        vMainAnimation3 = findViewById(R.id.v_main_animation_3);
        vMainAnimation4 = findViewById(R.id.v_main_animation_4);
        vMainAnimation5 = findViewById(R.id.v_main_animation_5);
        vMainAnimation6 = findViewById(R.id.v_main_animation_6);
        vMainAnimation7 = findViewById(R.id.v_main_animation_7);
        vMainAnimation8 = findViewById(R.id.v_main_animation_8);
        vMainAnimation9 = findViewById(R.id.v_main_animation_9);
        vMainAnimation10 = findViewById(R.id.v_main_animation_10);

        imgMainPopCat.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case (MotionEvent.ACTION_UP):
                    this.imgMainPopCat.setImageResource(R.drawable.img_popcat_default);
                    return true;
                case (MotionEvent.ACTION_DOWN):
                    this.imgMainPopCat.setImageResource(R.drawable.img_popcat_popped);

                    popSound.play(popSoundId, 1f, 1f, 0, 0, 1f);
                    vibrator.vibrate(50);

                    int digit = (int) (clickCount % 10);
                    switch (digit) {
                        case 0:
                            vMainAnimation1.playAnimation();
                        case 1:
                            vMainAnimation2.playAnimation();
                        case 2:
                            vMainAnimation3.playAnimation();
                        case 3:
                            vMainAnimation4.playAnimation();
                        case 4:
                            vMainAnimation5.playAnimation();
                        case 5:
                            vMainAnimation6.playAnimation();
                        case 6:
                            vMainAnimation7.playAnimation();
                        case 7:
                            vMainAnimation8.playAnimation();
                        case 8:
                            vMainAnimation9.playAnimation();
                        case 9:
                            vMainAnimation10.playAnimation();
                    }

                    clickCount++;
                    tvMainCounter.setText(clickCount.toString());
                    return true;
            }
            return false;
        });
    }
}