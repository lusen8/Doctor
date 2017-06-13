package com.example.lusen.doctor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lusen.doctor.R;
import com.example.lusen.doctor.date.ChatDate;

import java.util.List;

/**
 * Created by lusen on 2017/6/11.
 */

public class ChatAdapter extends RecyclerView.Adapter <ChatAdapter.ViewHolder> {

    private List<ChatDate> mChatList;

    public ChatAdapter(List<ChatDate> mChatList) {
        this.mChatList = mChatList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChatDate chatDate = mChatList.get(position);
        if (chatDate.getType() == ChatDate.TYPE_RECEIVED){
            holder.leftChat.setVisibility(View.VISIBLE);
            holder.righeChat.setVisibility(View.GONE);
            holder.leftText.setText(chatDate.getContent());
        }else if (chatDate.getType() == ChatDate.TYPE_SENT){
            holder.righeChat.setVisibility(View.VISIBLE);
            holder.leftChat.setVisibility(View.GONE);
            holder.rightText.setText(chatDate.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mChatList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,parent,false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftChat;
        LinearLayout righeChat;
        TextView leftText;
        TextView rightText;

        public ViewHolder(View itemView) {
            super(itemView);
            leftChat = (LinearLayout) itemView.findViewById(R.id.left_chat);
            righeChat = (LinearLayout) itemView.findViewById(R.id.right_chat);
            leftText = (TextView) itemView.findViewById(R.id.left_text);
            rightText = (TextView) itemView.findViewById(R.id.right_text);
        }
    }


}
