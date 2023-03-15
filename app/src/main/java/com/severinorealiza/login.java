package com.severinorealiza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private TextView text_tela_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        IniciarComponentes();
        text_tela_cadastro.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,cadastro.class);
                startActivity(intent);
            }
        });
    }
    private void IniciarComponentes(){
        text_tela_cadastro = findViewById(R.id.text_cadastrar);
}
}