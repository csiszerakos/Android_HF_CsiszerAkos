package com.example.activitystatesavetwo;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activitystatesavetwo.R;

public class ActivityStateSaveTwo extends AppCompatActivity {

    private EditText editText;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_save_two);

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("editTextValue", editText.getText().toString());
        outState.putBoolean("checkBoxChecked", checkBox.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String editTextValue = savedInstanceState.getString("editTextValue");
        boolean checkBoxChecked = savedInstanceState.getBoolean("checkBoxChecked");

        editText.setText(editTextValue);
        checkBox.setChecked(checkBoxChecked);
    }
}
