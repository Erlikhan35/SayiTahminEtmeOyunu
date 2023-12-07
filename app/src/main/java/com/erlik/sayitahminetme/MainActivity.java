package com.erlik.sayitahminetme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText sayigir;
    private TextView txtkalanhak, txtsonuc;
    private String Gelenhak;
    private int KalanHak = 3, Randomsayi;
    private Random rdr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtkalanhak = (TextView) findViewById(R.id.Txt_kalanhak);
        txtsonuc = (TextView) findViewById(R.id.textView2);
        sayigir = (EditText) findViewById(R.id.Edt_sayigir);
        rdr = new Random();
        Randomsayi = rdr.nextInt(10);
        System.out.println("Random sayiar" + Randomsayi);
        System.out.println(Randomsayi);

    }

    public void Btn_tahminet(View v) {
        Gelenhak = sayigir.getText().toString();
        if (!TextUtils.isEmpty(Gelenhak)) {
            if (KalanHak >= 0 ) {
                if (Gelenhak.equals(String.valueOf(Randomsayi))) {
                    SonucuGoster("Tebrikler dogru sayi"+" "+Randomsayi);
                } else {
                    txtsonuc.setText("Yanlış tahmin");

                }
                KalanHak--;
                txtkalanhak.setText("kalan hak:" + KalanHak);
                if (KalanHak == 0) {
                    SonucuGoster("Hakkınız tükendi");

                }
            } else
                txtkalanhak.setText("Oyun bitti");

        } else
            txtkalanhak.setText("deger gir");
    }

    private void SonucuGoster(String mesaj) {

        sayigir.setEnabled(false);
        txtsonuc.setText(mesaj);
    }
}