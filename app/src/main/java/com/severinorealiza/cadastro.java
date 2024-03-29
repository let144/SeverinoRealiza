package com.severinorealiza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class cadastro extends AppCompatActivity {

    private EditText edit_nome,edit_email,edit_senha;
    private Button bt_cadastrar;
    String[] mensagens = {"Preencha seus dados corretamente","Cadastro realizado com sucesso"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String senha = edit_senha.getText().toString();

                if (nome.isEmpty()|| email.isEmpty()|| senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[0],Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }else{
                    CadastrarUsuario(v);
                }
            }
        });
    }
    private void CadastrarUsuario(View v){
        String email = edit_email.getText().toString();
        String senha = edit_senha.getText().toString();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(v,mensagens[1],Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.BLACK);
                    snackbar.setTextColor(Color.WHITE);
                    snackbar.show();
                }
            }
        });
    }
    private void IniciarComponentes(){
      edit_nome = findViewById(R.id.edit_nome);
      edit_email = findViewById(R.id.edit_email);
      edit_senha = findViewById(R.id.edit_senha);
      bt_cadastrar = findViewById(R.id.bt_cadastrar);

}

    }

