package com.example.kaio.testesfirebase.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.kaio.testesfirebase.Activity.Acesso.ResActivity;
import com.example.kaio.testesfirebase.R;
import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Splash extends AppCompatActivity {


    private GifImageView gifImageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


            gifImageView = (GifImageView)findViewById(R.id.gifimageview);
            progressBar = (ProgressBar)findViewById(R.id.progressbar);
            progressBar.setVisibility(progressBar.VISIBLE);

            //vamos obter imagem gif de ativos e convertê-lo em array de bytes

            //definir recurso gifimaview
            try {
                InputStream inputStream = getAssets().open("giphy.gif");//nome do gif da pasta assets
                byte[] bytes = IOUtils.toByteArray(inputStream);
                gifImageView.setBytes(bytes);
                gifImageView.startAnimation();
            }
            catch (IOException ex){

            }
            //agora vamos pular actity por 3 segundos
            //espere por segundos e comece activity main

            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Splash.this.startActivity(new Intent(Splash.this,ResActivity.class));
                    Splash.this.finish();
                }
            },10000); //tempo de carregamento do gif

        }

    }
