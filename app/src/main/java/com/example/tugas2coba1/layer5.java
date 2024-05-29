package com.example.tugas2coba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class layer5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer5);

        Button group_869 = findViewById(R.id.group_869);

        group_869.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer();
            }
        });
    }
    private void openDrawer() {
        DrawerLayout drawerLayout = findViewById(R.id.main);
        NavigationView navigationView = findViewById(R.id.hal_view);
        drawerLayout.openDrawer(GravityCompat.END);
    }

    public void pindahlayer5(View view) {
        Intent pindahlayer5 = new Intent(layer5.this, scan_tutupbotol.class);
        startActivity(pindahlayer5);
    }

    public void pindahlayer5ke2(View view) {
        Intent pindahlayer5ke2 = new Intent(layer5.this, scan_tutupbotol.class);
        startActivity(pindahlayer5ke2);
    }

//    public void travelokalayer5(View view) {
//        Intent travelokalayer5 = new Intent(layer5.this, redeem_vaganza_detail_page.class);
//        startActivity(travelokalayer5);
//    }

    public void redeemvaganza(View view) {
        Intent redeemvaganza = new Intent(layer5.this, redeem_vaganza_katalog_page.class);
        startActivity(redeemvaganza);
    }

    public void extravaganza(View view) {
        Intent extravaganza = new Intent(layer5.this, congrats_page.class);
        startActivity(extravaganza);
    }
}