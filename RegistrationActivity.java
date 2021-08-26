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

public class RegistrationActivity extends AppCompatActivity {
    //Initialise
    EditText email, nom, prenoms, password, repassword;
    Button signup;
    TextView signin;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //Assign
        email = (EditText) findViewById(R.id.email);
        nom = (EditText) findViewById(R.id.nomregister);
        prenoms = (EditText) findViewById(R.id.prenomregister);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (TextView) findViewById(R.id.tvsignin);
        DB = new DbHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String name = nom.getText().toString();
                String prename = prenoms.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (mail.equals("") || name.equals("") || prename.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(RegistrationActivity.this, "Veuillez renseigner tout les champs", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(repass)) {
                        Boolean checkemail = DB.checkemail(mail);
                        if (checkemail==false) {
                            Boolean insert = DB.insertDataUsers(mail, name, prename, pass);
                            if (insert==true) {
                                Toast.makeText(RegistrationActivity.this, "Inscription reussie", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(RegistrationActivity.this, "Echec de l'inscription", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this, "Ce email existe deja, connectez vous", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this, "Les mot de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}