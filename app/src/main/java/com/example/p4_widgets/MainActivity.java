package com.example.p4_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    SharedPreferences prefs;
    ToggleButton toggleButton;
    CheckBox checkBox;
    CheckedTextView checkedTextView;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getPreferences(MODE_PRIVATE);

        aSwitch = findViewById(R.id.switch1);

        aSwitch.setChecked(prefs.getBoolean("Switch",false));

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                prefs.edit().putBoolean("Switch", isChecked).apply();

            }
        });


        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setChecked(prefs.getBoolean("ToggleButton", false));

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                prefs.edit().putBoolean("ToogleButton", isChecked).apply();

            }
        });


        checkBox = findViewById(R.id.checkBox);

        checkBox.setChecked(prefs.getBoolean("CheckBox",false));

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                prefs.edit().putBoolean("CheckBox", isChecked).apply();
            }
        });

        checkedTextView = findViewById(R.id.checkedTextView);

        checkedTextView.setChecked(prefs.getBoolean("CheckedTextView", true));

        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkedTextView.toggle();
                prefs.edit().putBoolean("CheckedTextView", checkedTextView.isChecked()).apply();
            }
        });

        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.check(prefs.getInt("RadioGroup", radioGroup.getCheckedRadioButtonId()));

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                prefs.edit().putInt("RadioGroup", checkedId).apply();
            }
        });



    }
}
