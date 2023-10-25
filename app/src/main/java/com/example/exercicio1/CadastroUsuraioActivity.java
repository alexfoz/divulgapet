package com.example.exercicio1;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseOptions;



import java.util.Calendar;

public class CadastroUsuraioActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtData;
    private Button btCadastro;

    FirebaseDatabase database = getInstance();
    DatabaseReference usuarioRef = database.getReference("usuarios");

    String key = usuarioRef.push().getKey();
    Usuario newUsuario = new Usuario(key, "123456789", "joao@email.com", 1);

    public DatabaseReference getUsuarioRef(int id) {
        return usuarioRef;
    }


    protected void onCreate(Bundle savedInstanceState) {

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setStorageBucket("/home/alexandre/StudioProjects/projeto_integrador_II/app/google-services.json") // Substitua pelo caminho do seu arquivo JSON de credenciais
                .setDatabaseUrl("https://exercicio-1-bd359-default-rtdb.firebaseio.com/") // Substitua pela URL do seu banco de dados Firebase
                .build();

        FirebaseApp.initializeApp(this, options);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("ALEXANDRE");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        txtData = findViewById(R.id.txtData);
        btCadastro = findViewById(R.id.btCadastro);

        txtData.setOnClickListener(this);
        btCadastro.setOnClickListener(this);


    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        txtData.setText(selectedDate);
                    }
                }, year, month, dayOfMonth);

        datePickerDialog.show();
    }

    @Override
    public void onClick(View view) {
        if (view == txtData) {
            showDatePickerDialog();

        } else if (view == btCadastro) {
            Intent intent = new Intent(CadastroUsuraioActivity.this, LoginActivity.class);

            startActivity(intent);
        }
    }
}
