package bf.esmt.easytransport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bf.esmt.findtransport.R;

public class LoginActivity extends AppCompatActivity {
    //initialise
    EditText email, password;
    Button btnlogin;
    TextView tvsignin1;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Assign
        email = (EditText) findViewById(R.id.email1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        tvsignin1 = (TextView) findViewById(R.id.tvsignin1);
        DB = new DbHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if (mail.equals("") || pass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Renseigner tout les champs s'il vous plait", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkemailpass = DB.checkemailpassword(mail,pass);
                    if (checkemailpass==true) {
                        Toast.makeText(LoginActivity.this, "Connecte avec succes", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Donnees invalides", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvsignin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}