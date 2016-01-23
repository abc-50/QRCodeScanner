package com.infusion.mye.qrcodereader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.gson.Gson;
import com.google.zxing.Result;
import com.infusion.mye.qrcodereader.model.Product;
import com.infusion.mye.qrcodereader.model.TestProducts;

import java.net.URL;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends Activity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new Gson();
        String json;
        for (Product p: TestProducts.getTestProducts()) {
            json = gson.toJson(p);
        }

            Product p = new Product("Garbage", 1.23, "https://robobinding.github" +
                    ".io/RoboBinding/images/robobinding_logo.png");


        MainActivityFragment fragment = new MainActivityFragment(p);

        getFragmentManager().beginTransaction().replace(R.id.bottom_container, fragment,
                "MainActivityFragment")
                .commit();


        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p2 = new Product("some other garbage", 222, "https://financialpostcom.files.wordpress.com/2016/01/0122cauliflower.jpg");

                MainActivityFragment fragment = (MainActivityFragment) getFragmentManager().findFragmentByTag
                        ("MainActivityFragment");

                Gson g = new Gson();
                String gstr = g.toJson(p2);

                fragment.updateProduct(p2);
            }
        });

        FrameLayout topContainer = (FrameLayout) findViewById(R.id.top_container);
        scannerView = new ZXingScannerView(this);
        topContainer.addView(scannerView);


    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        scannerView.stopCamera();
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void handleResult(Result result) {

        Gson gson = new Gson();

        Product myProduct = gson.fromJson(result.toString(), Product.class);

        MainActivityFragment fragment = (MainActivityFragment) getFragmentManager().findFragmentByTag
                ("MainActivityFragment");


        fragment.updateProduct(myProduct);

        scannerView = new ZXingScannerView(this);
    }
}
