package com.example.dovizkur;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    final List<User> users = new ArrayList<User>();

    CountDownTimer countDownTimer;
    int kart_sure=3000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);
        final ListView listView = (ListView) findViewById(R.id.listView);
        final CustomAdapter adapter = new CustomAdapter(this, users);
        listView.setAdapter(adapter);


        new arkaPlan().execute("https://www.doviz.gen.tr/doviz_json.asp?version=1.0.4");
        countDownTimer=new CountDownTimer(kart_sure,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);

            }
        }.start();
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);


            }

        });







    }



    class arkaPlan extends AsyncTask<String,String,String > {
    protected String doInBackground (String ... params){
        HttpURLConnection connection=null;
        BufferedReader br=null;
        try{

            URL url=new URL(params[0]);
            connection=(HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream is=connection.getInputStream();
            br= new BufferedReader(new InputStreamReader(is));

            String satir;
            String dosya="";
            while((satir=br.readLine())!=null){
                Log.d("satir",satir);
                dosya+=satir;
            }
            return dosya;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "hata";

    }
    protected void onPostExecute(String s){
        Log.d("postExecutetangelen",s);

        try{
            JSONObject jo=new JSONObject(s);

            users.add(new User("USD", "ALIŞ:\n"+(jo.getString("dolar")),"SATIŞ:\n"+(jo.getString("dolar2")),true));

            users.add(new User("EUR", "ALIŞ:\n"+(jo.getString("euro")),"SATIŞ:\n"+(jo.getString("euro2")),false));


        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}

}