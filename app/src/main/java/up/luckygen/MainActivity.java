package up.luckygen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private Button luckyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTitle = findViewById(R.id.textView);
        luckyBtn = findViewById(R.id.luckyBtn);

        luckyBtn.setText(R.string.txtBtn);

        List<String> luckyMessages = Arrays.asList("Your shoes will make you happy today.\n",
                "A very attractive person has a message for you.",
                "A new voyage will fill your life with untold memories.\n",
                "You will be called in to fulfill a position of high honor and responsibility.\n");

        Random randomNum = new Random();

        View.OnClickListener listener2 = view -> {
            textViewTitle.setText(R.string.loadingTxt);
            String luckyMessage = luckyMessages.get(randomNum.nextInt(luckyMessages.size()));
                    new android.os.Handler(Looper.getMainLooper()).postDelayed(
                    () -> textViewTitle.setText(luckyMessage),2000
            );
        };
        luckyBtn.setOnClickListener(listener2);

}}