package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnGenerate;
    TextView tv_otvet, tvMainAnswer;

    int otvetInt, genOtvetInt;

    LottieAnimationView lotty_sun, lotty_one, lotty_two;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lotty_sun = findViewById(R.id.lotty_sun);
        lotty_one = findViewById(R.id.lotty_one);
        lotty_two = findViewById(R.id.lotty_two);
        tv_otvet = findViewById(R.id.tv_otvet);
        tvMainAnswer = findViewById(R.id.tvMainAnswer);
        btnGenerate = findViewById(R.id.btn_generate);

        lotty_two.setAnimation(R.raw.fun_time);
        lotty_sun.setAnimation(R.raw.sunshine);
        lotty_one.setAnimation(R.raw.animation_fire);


        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                genOtvetInt = random.nextInt(100);
                otvetInt = genOtvetInt;
                if ((otvetInt != 0) && (otvetInt > 0)) {

                    tv_otvet.setText(String.valueOf(otvetInt) + " %");
                    printAnswer();
                    btnGenerate.setVisibility(View.INVISIBLE);
                } else
                    Toast.makeText(MainActivity.this, "Нажми еще раз", Toast.LENGTH_SHORT).show();
                btnGenerate.setVisibility(View.VISIBLE);
            }
        });

    }

    private void printAnswer() {

        if (otvetInt >= 1 && otvetInt <= 48) {
            tvMainAnswer.setText("Завтра может повезти!");
            lotty_two.setVisibility(View.VISIBLE);
        } else {
            if (otvetInt > 48 && otvetInt <= 65) {
                tvMainAnswer.setText("Мы рады за тебя!");
                lotty_two.setVisibility(View.VISIBLE);

            } else {
                if (otvetInt > 65 && otvetInt <= 100) {
                    tvMainAnswer.setText("Все Супер!");
                    lotty_two.setVisibility(View.VISIBLE);
                }
            }
        }
    }


}