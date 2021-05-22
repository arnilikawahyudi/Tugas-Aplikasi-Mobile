package com.e.gopku;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Restoran extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        // buat variabel array untuk menampilkan list rumah sakit yang ada
        String [] rs = new String[] {"Sushi Tei Pekanbaru Resto","Kayu Manis Resto","Sarang Kepiting Resto","Kanso Family Resto Pekanbaru","Restoran disekitar Saya","Exit"};
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
            Intent to = null;

            if(pilihan.equals("Sushi Tei Pekanbaru Resto")){

                to = new Intent(this,Sushi.class);

            }else if (pilihan.equals("Kayu Manis Resto")){

                to = new Intent(this,Manis.class);

            }else if (pilihan.equals("Sarang Kepiting Resto")){

                to = new Intent(this,ToKepiting.class);

            }else if (pilihan.equals("Kanso Family Resto Pekanbaru")){

                to = new Intent(this,ToKanso.class);

            } else if (pilihan.equals("Restoran disekitar Saya")){
                // search hospital nearby (baca gps) ..... Lokasi terdekat hospital yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=restoran");
                to = new Intent(Intent.ACTION_VIEW,dekatsaya);
                to.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(to);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

