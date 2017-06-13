package com.example.lusen.doctor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lusen.doctor.adapter.ChatAdapter;
import com.example.lusen.doctor.date.ChatDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lusen on 2017/6/11.
 */

public class ChatActivity extends AppCompatActivity {

    private List<ChatDate> chatList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView chatRecycle;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();
        initChat();

    }

    private void initView() {
        inputText = (EditText) findViewById(R.id.input_edit);
        send = (Button) findViewById(R.id.input_text);
        chatRecycle = (RecyclerView) findViewById(R.id.chat_recycle);
        chatRecycle.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(chatList);
        chatRecycle.setAdapter(chatAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    ChatDate data = new ChatDate(content,ChatDate.TYPE_SENT);
                    chatList.add(data);
                    chatAdapter.notifyItemInserted(chatList.size() - 1);
                    chatRecycle.scrollToPosition(chatList.size() - 1);
                    inputText.setText("");
                }if ("感冒药".equals(content)){
                    ChatDate date = new ChatDate("要想感冒好的快，就用999感冒灵颗粒！",ChatDate.TYPE_RECEIVED);
                    chatList.add(date);
                    chatAdapter.notifyItemInserted(chatList.size() - 1);
                    chatRecycle.scrollToPosition(chatList.size() - 1);
                }else {
                    ChatDate date = new ChatDate("您的问题太高深了，看来，小药还得继续学习学习才能解答。",ChatDate.TYPE_RECEIVED);
                    chatList.add(date);
                    chatAdapter.notifyItemInserted(chatList.size() - 1);
                    chatRecycle.scrollToPosition(chatList.size() - 1);
                }
            }
        });

    }

    private void initChat() {
        ChatDate data1 = new ChatDate("hello,你好！我是小药郎",ChatDate.TYPE_RECEIVED);
        chatList.add(data1);
        ChatDate data2 = new ChatDate("hello,再说一遍",ChatDate.TYPE_RECEIVED);
        chatList.add(data2);
        ChatDate data3 = new ChatDate("我是小药郎，你有什么需求都可以问我哦！",ChatDate.TYPE_RECEIVED);
        chatList.add(data3);
    }
}
