package com.tayloryan.andfixsimpledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button mResultButton;
    private Button mCalculateButton;
    private Button mFixButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultButton = (Button) findViewById(R.id.result);
        mCalculateButton = (Button) findViewById(R.id.calculate);
        mFixButton = (Button) findViewById(R.id.fix);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calculate:
                Calculator calculator = new Calculator();
                mResultButton.setText(calculator.calculate() + "");
                break;
            case R.id.fix:
                doFix();
                break;
            default:
                break;
        }
    }

    private void doFix() {

    }
}
