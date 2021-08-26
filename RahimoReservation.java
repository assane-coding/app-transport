package bf.esmt.easytransport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import bf.esmt.findtransport.R;

public class RahimoReservation extends AppCompatActivity {
    //Initialise variable
    EditText email_input, date_input, depart_input, arrivee_input;
    Spinner compagnie_input, heure_input, tarif_input;
    Button btnreserver;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rahimo_reservation);

        //Assign


        email_input = (EditText) findViewById(R.id.rahimo_email_reserver);
        date_input = (EditText) findViewById(R.id.rahimo_date_reserver);
        depart_input = (EditText) findViewById(R.id.rahimo_depart_reserver);
        arrivee_input = (EditText) findViewById(R.id.rahimo_arrivee_reserver);
        compagnie_input = (Spinner) findViewById(R.id.rahimo_compagnies_reserver);
        heure_input = (Spinner) findViewById(R.id.rahimo_heuredepart_reserve);
        tarif_input = (Spinner) findViewById(R.id.rahimo_tarif_reserver);
        btnreserver = findViewById(R.id.bt_reserver_rahimo);
        DB = new DbHelper(this);

        btnreserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_input.getText().toString();
                String date = date_input.getText().toString();
                String depart = depart_input.getText().toString();
                String arrivee = arrivee_input.getText().toString();
                String compagnie = compagnie_input.getSelectedItem().toString();
                String heure = heure_input.getSelectedItem().toString();
                String tarif = tarif_input.getSelectedItem().toString();

                if (email.equals("") || date.equals("") || depart.equals("") || arrivee.equals("") || compagnie.equals("") || heure.equals("") || tarif.equals("")) {
                    Toast.makeText(RahimoReservation.this, "Veuillez renseigner tout les champs", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Boolean checkemail = DB.checkemail(email);
                    //Boolean checkemailpass = DB.checkemailpassword(email, password);
                    //if (checkemail == false) {
                        Boolean insert = DB.insertDataReservations(email, compagnie, date, depart, arrivee, heure, tarif);
                        if (insert == true) {
                            Toast.makeText(RahimoReservation.this, "Reservee avec succes", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Reservations.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RahimoReservation.this, "Echec de la reservation", Toast.LENGTH_SHORT).show();
                        }
                    //}
                    // else {
                      //  Toast.makeText(RahimoReservation.this, "Email invalide", Toast.LENGTH_SHORT).show();
                    //}
                }
            }

        });
    }

}