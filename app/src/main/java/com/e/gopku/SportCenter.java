package com.e.gopku;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SportCenter extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        // buat variabel array untuk menampilkan list rumah sakit yang ada
        String [] rs = new String[] {"Gedung Olahraga Tribuana","Gelanggang Olahraga Remaja Pekanbaru","Gelanggang Olahraga Panam Raya Square","GOR Badminton Panam Jaya","Sport Center disekitar Saya","Exit"};
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
            Intent sc = null;

            if(pilihan.equals("Gedung Olahraga Tribuana")){

                sc = new Intent(this,SCtrib.class);

            }else if (pilihan.equals("Gelanggang Olahraga Remaja Pekanbaru")){

                sc = new Intent(this,SCrem.class);

            }else if (pilihan.equals("Gelanggang Olahraga Panam Raya Square")){

                sc = new Intent(this,SCraya.class);

            }else if (pilihan.equals("GOR Badminton Panam Jaya")){

                sc = new Intent(this,SCjaya.class);

            } else if (pilihan.equals("Sport Center disekitar Saya")){
                // search hospital nearby (baca gps) ..... Lokasi terdekat hospital yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=gedung olahraga");
                sc = new Intent(Intent.ACTION_VIEW,dekatsaya);
                sc.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(sc);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
