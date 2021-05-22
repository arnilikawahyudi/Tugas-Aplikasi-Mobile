package com.e.gopku;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RumahSakit extends ListActivity {
    public void onCreate (Bundle icecle){
        super.onCreate(icecle);
        // buat variabel array untuk menampilkan list rumah sakit yang ada
        String [] rs = new String[] {"Rumah Sakit Eka Hospital","Rumah Sakit Awal Bross","Rumah Sakit Jiwa Tampan","Rumah Sakit Aulia Hospital","RSUD Arifin Achmad","Rumah Sakit disekitar Saya","Exit"};
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
            Intent rs = null;

            if(pilihan.equals("Rumah Sakit Eka Hospital")){

                rs = new Intent(this,RSEkaHospital.class);

            }else if (pilihan.equals("Rumah Sakit Awal Bross")){

                rs = new Intent(this,RSawalbross.class);

            }else if (pilihan.equals("Rumah Sakit Jiwa Tampan")){

                rs = new Intent(this,RSJiwaTampan.class);

            }else if (pilihan.equals("Rumah Sakit Aulia Hospital")){

                rs = new Intent(this,RSAuliaHospital.class);

            }else if (pilihan.equals("RSUD Arifin Achmad")){

                rs = new Intent(this,RSArifinAchmad.class);

            } else if (pilihan.equals("Rumah Sakit disekitar Saya")){
                // search hospital nearby (baca gps) ..... Lokasi terdekat hospital yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=hospital");
                rs = new Intent(Intent.ACTION_VIEW,dekatsaya);
                rs.setPackage("com.google.android.apps.maps");
            }
            else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(rs);


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
