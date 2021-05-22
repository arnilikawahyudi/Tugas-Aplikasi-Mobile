package com.e.gopku;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Campus extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        // buat variabel array untuk menampilkan list rumah sakit yang ada
        String [] rs = new String[] {"Universitas Riau","Universitas Muhammadiyah Riau","Universitas Abdurrab (Univrab)","Universitas Islam Negeri Sultan Syarif Kasim Riau","Universitas disekitar Saya","Exit"};
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
            Intent bk = null;

            if(pilihan.equals("Universitas Riau")){

                bk = new Intent(this,Uunri.class);

            }else if (pilihan.equals("Universitas Muhammadiyah Riau")){

                bk = new Intent(this,Uumri.class);

            }else if (pilihan.equals("Universitas Abdurrab (Univrab)")){

                bk = new Intent(this,Uabdur.class);

            }else if (pilihan.equals("Universitas Islam Negeri Sultan Syarif Kasim Riau")){

                bk = new Intent(this,Ususka.class);

            } else if (pilihan.equals("Universitas disekitar Saya")){
                // search hospital nearby (baca gps) ..... Lokasi terdekat hospital yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=universitas");
                bk = new Intent(Intent.ACTION_VIEW,dekatsaya);
                bk.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(bk);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
