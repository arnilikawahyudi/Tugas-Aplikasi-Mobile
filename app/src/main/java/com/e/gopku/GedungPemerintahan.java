package com.e.gopku;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GedungPemerintahan extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        // buat variabel array untuk menampilkan list rumah sakit yang ada
        String [] rs = new String[] {"Kantor Walikota Pekanbaru","Kantor Gubernur Riau","Gedung Dharma Wanita Provinsi Riau","Gedung BI Pekanbaru","Gedung Pemerintah disekitar Saya","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,rs));
    }

    //handle untuk mendengarkan apa yang dipilih dari list tersebut
    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    // seleksi pilihannya
    private void tampilkanpilihan(String pilihan) {
        try {
            // Kondisi Seleksi
            Intent gp = null;

            if(pilihan.equals("Kantor Walikota Pekanbaru")){

                gp = new Intent(this,GPWalkot.class);

            }else if (pilihan.equals("Kantor Gubernur Riau")){

                gp = new Intent(this,GPGuber.class);

            }else if (pilihan.equals("Gedung Dharma Wanita Provinsi Riau")){

                gp = new Intent(this,GPDharma.class);

            }else if (pilihan.equals("Gedung BI Pekanbaru")){

                gp = new Intent(this,GPBi.class);

            } else if (pilihan.equals("Gedung Pemerintah disekitar Saya")){
                // search hospital nearby (baca gps) ..... Lokasi terdekat hospital yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=gedung pemerintah pekanbaru");
                gp = new Intent(Intent.ACTION_VIEW,dekatsaya);
                gp.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(gp);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

