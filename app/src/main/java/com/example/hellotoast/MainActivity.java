package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mZeroButton;
    private Button mCountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);
        mZeroButton = findViewById(R.id.button_zero);
        mCountButton = findViewById(R.id.button_count);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count_value");
            mShowCount.setText(String.valueOf(mCount));
            if (mCount > 0) {
                mZeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));
                if (mCount % 2 != 0) {
                    mCountButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                } else {
                    mCountButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_value", mCount);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }

        mZeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.pink));

        if (mCount % 2 != 0) {
            mCountButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        } else {
            mCountButton.setBackgroundColor(ContextCompat.getColor(this, R.color.blue));
        }
    }

    public void showZero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        mZeroButton.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
    }
}