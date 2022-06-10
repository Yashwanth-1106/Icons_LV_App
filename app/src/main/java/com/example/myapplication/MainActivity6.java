package com.example.myapplication;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {
    public TextView tv1;
    public EditText ed1;
    public Button b1;

    private final String filter = "~#^|$%&*!./@()_-+={}[]',";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        tv1 = findViewById(R.id.textView);
        ed1 = findViewById(R.id.ed1);
        b1 = findViewById(R.id.button);


    }


    public void buttonCheckPalindrome(View view) {
        char[] charInput = ed1.getText().toString().toCharArray();
        int intLength = charInput.length;
        boolean isPalindrome = true;
        ed1.setFilters(new InputFilter[]
                {
                        (source, start, end, dest, dstart, dend) -> {
                            if (source != null && filter.contains(("" + source))) {
                                return "";
                            }
                            return null;
                        }
                });

        for (int i = 0; i < intLength / 2; i++) {
            if (charInput[i] != charInput[intLength - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            tv1.setText("Palindrome");
        } else {
            tv1.setText("NOT Palindrome");
        }
    }

}


