package com.e.gopku;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SCraya extends ListActivity {
    public void onCreate (Bundle icecle)
    {
        super.onCreate(icecle);
        // buat variabel untuk list layanan
        String [] layanan = new String[] {"Call Center","Info Maps","Driving Direction","Website","Search Info","Sport Center nearme","Seach Mesjid nearme","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,layanan));
    }

    // heandle apa yang di click
    protected void onListItemClick (ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }
    // seleksi apa yang dipilih
    private void tampilkanpilihan(String pilihan){
        // handle pilihan
        try {
            Intent re = null;
            if (pilihan.equals("Call Center")){
                String tel = "tel:0761562223";
                re = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));

            }else if (pilihan.equals("Info Maps")){
                String geo = "geo:0.465856,101.386156";
                re = new Intent(Intent.ACTION_VIEW,Uri.parse(geo));
                // set app defualt untuk buka intent ini apabila ada beberapa aplikasi yang dapat membuka
                re.setPackage("com.google.android.apps.maps");

            }else if (pilihan.equals("Driving Direction")){
                String geo ="google.navigation:q=0.465856,101.386156";
                re = new Intent(Intent.ACTION_VIEW,Uri.parse(geo));

            }else if (pilihan.equals("Website")){
                String web = "http://remaja.com";
                re = new Intent(Intent.ACTION_VIEW,Uri.parse(web));

            }else if (pilihan.equals("Search Info")){
                re = new Intent(Intent.ACTION_WEB_SEARCH);
                re.putExtra(SearchManager.QUERY,("Gelanggang Olah Raga Panam Raya Square"));

            }else if (pilihan.equals("Sport Center nearme")){
                // search restoran nearby (baca gps) ..... Lokasi terdekat resto yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=gedung olahraga");
                re = new Intent(Intent.ACTION_VIEW,dekatsaya);
                re.setPackage("com.google.android.apps.maps");

            }else if (pilihan.equals("Seach Mesjid nearme")){
                // search hospital nearby (baca gps) ..... Lokasi terdekat hospital yang ada
                Uri dekatsaya = Uri.parse("geo:0,0?q=mesjid");
                re = new Intent(Intent.ACTION_VIEW,dekatsaya);
                re.setPackage("com.google.android.apps.maps");

            }else if (pilihan.equals("Exit")){
                finish();
            }
            startActivity(re);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
