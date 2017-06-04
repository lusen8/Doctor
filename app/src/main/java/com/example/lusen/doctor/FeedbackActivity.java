package com.example.lusen.doctor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    private EditText input;
    private Button sendMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Toolbar toolbar = (Toolbar) findViewById(R.id.feedbackToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        input = (EditText) findViewById(R.id.input);
        sendMsg = (Button) findViewById(R.id.sendMsg);

        sendMsg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String msg = input.getText().toString();
                if (TextUtils.isEmpty(msg)){
                    Toast.makeText(FeedbackActivity.this, getResources().getString(R.string.emptyTips), Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(FeedbackActivity.this, getResources().getString(R.string.back), Toast.LENGTH_LONG).show();
                    input.setText("");
                    // TODO: 17-5-14  子线程提交反馈
                    //send()
                }
            }
        });
    }
}
