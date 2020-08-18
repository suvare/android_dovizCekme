package com.example.dovizkur;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;






public class CustomAdapter extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<User> userList;

    public CustomAdapter(Activity activity, List<User> userList) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lineView;
        lineView = userInflater.inflate(R.layout.activity_custom_listview, null);
        TextView textViewParaBirimi = (TextView) lineView.findViewById(R.id.tvParaBirimi);
        TextView textViewParaAlis = (TextView) lineView.findViewById(R.id.tvParaAlis);
        TextView textViewParaSatis = (TextView) lineView.findViewById(R.id.tvParaSatis);
        ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imvParaArtis);

        User user = userList.get(i);
        textViewParaBirimi.setText(user.getParaBirimi());
        textViewParaAlis.setText(user.getParaBirimiAlis());
        textViewParaSatis.setText(user.getParaBirimiSatis());



        if (user.isParaArtis()) {
            imageViewUserPicture.setImageResource(R.mipmap.up_icon);
        } else {
            imageViewUserPicture.setImageResource(R.mipmap.down_icon);
        }

        return lineView;
    }
}