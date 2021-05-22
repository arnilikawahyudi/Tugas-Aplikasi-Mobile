package com.e.gopku;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Bank extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        // buat variabel array untuk menampilkan list rumah sakit yang ada
        String [] rs = new String[] {"Bank Indonesia Pekanbaru","Bank Riau Kepri Cabang Pekanbaru","Bank BJB KC Pekanbaru","Bank Muamalat Indonesia","Bank disekitar Saya","Exit"};
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

            if(pilihan.equals("Bank Indonesia Pekanbaru")){

                bk = new Intent(this,BKindo.class);

            }else if (pilihan.equals("Bank Riau Kepri Cabang Pekanbaru")){

                bk = new Intent(this,BKKepri.class);

            }else if (pilihan.equals("Bank BJB KC Pekanbaru")){

                bk = new Intent(this,BKbjb.class);

            }else if (pilihan.equals("Bank Muamalat Indonesia")){

                bk = new Intent(this,BKmuamalat.class);

            } else if (pilihan.equals("Bank disekitar Saya")){
                // search hospital nearby (baca gps) ..... Lokasi terdekat hospital yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=bank");
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
