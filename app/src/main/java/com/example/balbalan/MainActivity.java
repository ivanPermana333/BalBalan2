package com.example.balbalan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ScheduleAdapter adapter;
    private ArrayList<ModelJadwal> JadwalList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        JadwalList=new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        AndroidNetworking.get("https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray datajadwal = response.getJSONArray("events");
                            ModelJadwal jadwal;
                            for (int i = 0; i < datajadwal.length(); i++ ){
                                jadwal = new ModelJadwal();
                                JSONObject dataku = datajadwal.getJSONObject(i);
                                jadwal.setStrHomeTeam(dataku.getString("strHomeTeam"));
                                jadwal.setStrAwayTeam(dataku.getString("strAwayTeam"));
                                jadwal.setStrDate(dataku.getString("strDate"));
                                jadwal.setStrTime(dataku.getString("strTime"));
                                JadwalList.add(jadwal);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        adapter = new ScheduleAdapter(JadwalList);

                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

                        recyclerView.setLayoutManager(layoutManager);

                        recyclerView.setAdapter(adapter);
                        Log.d("hasil","jumlahdata:"+JadwalList.size());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("hasil","onError:"+anError.toString());
                    }
                });

    }




}
