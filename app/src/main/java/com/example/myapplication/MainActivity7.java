package com.example.myapplication;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {
    CheckBox Home_essentials, Fashion, Electronics;
    Button buttonOrder, buttonOrder2, buttonOrder3;
    RatingBar ratingbar;
    String[] Random = {"I", "the", "very", "totally", "really", "love", "like", "hate", "much", "this", "that", "product", "it", "is", "was", "awesome", "superb", "nice", "simply", "worthy"};
    RadioButton expradioButton;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        addListenerOnButtonClick1();
        addListenerOnButtonClick2();
        addListenerOnButtonClick3();
        setonCheckedChangeListener();
        ArrayAdapter<String> gen = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, Random);

        MultiAutoCompleteTextView simpleMultiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.mACTV);
        simpleMultiAutoCompleteTextView.setAdapter(gen);
        simpleMultiAutoCompleteTextView.setThreshold(1);
        simpleMultiAutoCompleteTextView.setTokenizer(new SpaceTokenizer());

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


    }

    private void setonCheckedChangeListener() {
        Switch sw= (Switch) findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(),"You'll receive the upcoming event updates",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Further updates are off",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void addListenerOnButtonClick1() {
        Home_essentials = (CheckBox) findViewById(R.id.checkBox5);
        Fashion = (CheckBox) findViewById(R.id.checkBox3);
        Electronics = (CheckBox) findViewById(R.id.checkBox4);
        buttonOrder = (Button) findViewById(R.id.button2);

        buttonOrder.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                if (Home_essentials.isChecked()) {
                    result.append("\nPurchased Home essentials");
                }
                if (Electronics.isChecked()) {
                    result.append("\nPurchased Electronics");

                }
                if (Fashion.isChecked()) {
                    result.append("\nPurchased suits");

                }
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();


            }

        });

    }


    public class SpaceTokenizer implements MultiAutoCompleteTextView.Tokenizer {
        private int i;

        public int findTokenStart(CharSequence inputText, int cursor) {
            int idx = cursor;

            while (idx > 0 && inputText.charAt(idx - 1) != ' ') {
                idx--;
            }
            while (idx < cursor && inputText.charAt(idx) == ' ') {
                idx++;
            }
            return idx;
        }

        public int findTokenEnd(CharSequence inputText, int cursor) {
            int idx = cursor;
            int length = inputText.length();

            while (idx < length) {
                if (inputText.charAt(i) == ' ') {
                    return idx;
                } else {
                    idx++;
                }
            }
            return length;
        }

        public CharSequence terminateToken(CharSequence inputText) {
            int idx = inputText.length();

            while (idx > 0 && inputText.charAt(idx - 1) == ' ') {
                idx--;
            }

            if (idx > 0 && inputText.charAt(idx - 1) == ' ') {
                return inputText;
            } else {
                if (inputText instanceof Spanned) {
                    SpannableString sp = new SpannableString(inputText + " ");
                    TextUtils.copySpansFrom((Spanned) inputText, 0, inputText.length(),
                            Object.class, sp, 0);
                    return sp;
                } else {
                    return inputText + " ";
                }
            }
        }
    }

    public void addListenerOnButtonClick2() {


        buttonOrder2 = (Button) findViewById(R.id.button2);

        buttonOrder2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                expradioButton = (RadioButton) findViewById(selectedId);


                if (selectedId == -1) {
                    Toast.makeText(getApplicationContext(),"Please rethink your moment with us🥺",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),expradioButton.getText(),Toast.LENGTH_LONG).show();
                }

            }


        });

    }

    public void addListenerOnButtonClick3() {
        ratingbar = (RatingBar) findViewById(R.id.ratingBar);
        buttonOrder3 = (Button) findViewById(R.id.button2);
        buttonOrder3.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                String rating = String.valueOf(ratingbar.getRating());
                Toast.makeText(getApplicationContext(),"You have rated " +rating+ " stars to us😊",Toast.LENGTH_LONG).show();
            }

        });


    }
}