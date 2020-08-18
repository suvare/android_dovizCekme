package com.example.dovizkur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class deneme extends AppCompatActivity {

    final List<User> users = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);
        MainActivity my=new MainActivity();

        //SimpleDateFormat clockFormat = new SimpleDateFormat("hh:mm:ss");
        //GregorianCalendar gcalender = new GregorianCalendar();
        //String currentTime = clockFormat.format(gcalender.getTime());

      // users.add(new User("Dolar", true, currentTime));
//        users.add(new User("Hüseyin Coşkun", false, currentTime));
//        users.add(new User("Seda Karataş", true, currentTime));
//        users.add(new User("Fatih Keskin", false, currentTime));
//        users.add(new User("Betül Çiçek", true, currentTime));
//        users.add(new User("Fatih Ballı", false, currentTime));
//        users.add(new User("Hanife Bakal", true, currentTime));


        final ListView listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, users);
        listView.setAdapter(adapter);
    }
}