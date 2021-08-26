package bf.esmt.easytransport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bf.esmt.findtransport.R;

import static bf.esmt.easytransport.MainActivity.redirectActivity;

public class Trajets extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerlayout;
    EditText villeDepart,villeArrivee;
    Button btTrajet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trajets);

        //Assign variable
        //Assign variable
        drawerlayout = findViewById(R.id.drawer_layout);
        villeDepart = findViewById(R.id.ville_depart);
        villeArrivee = findViewById(R.id.ville_arrivee);
        btTrajet = findViewById(R.id.bt_trajet);

        btTrajet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get value from edit text
                String sDepart = villeDepart.getText().toString().trim();
                String sArrivee = villeArrivee.getText().toString().trim();

                //Check condition
                if (sDepart.equals("") && sArrivee.equals("")){
                    //When both value blank
                    Toast.makeText(getApplicationContext(),"Veuillez entrer deux villes",Toast.LENGTH_SHORT).show();

                }else {
                    //When both value fill
                    //Display track
                    DisplayTrack(sDepart,sArrivee);
                }
            }
        });
    }

    public void ClickMenu(View view) {
        //Open drawer
        MainActivity.openDrawer(drawerlayout);
    }

    public void ClickLogo(View view) {
        //Close drawer
        MainActivity.closeDrawer(drawerlayout);
    }

    public void ClickHome(View view) {
        //Redirect activity to home
        redirectActivity(this,MainActivity.class);
    }

    public void ClickTrajets(View view) {
        //Recreate activity
        recreate();
    }

    public void ClickTarifs(View view) {
        //Redirect activity to tarifs
        redirectActivity(this,Tarifs.class);
    }

    public void ClickHoraires(View view) {
        //Redirect activity to horaires
        redirectActivity(this,Horaires.class);
    }

    public void ClickReservationsBus(View view) {
        //Redirect activity to reservation de bus
        redirectActivity(this,Reservations.class);
    }

    public void ClickAccount(View view) {
        //Redirect activity to account
        redirectActivity(this,Account.class);
    }

    public void ClickInformations(View view) {
        //Redirect activity to informations
        redirectActivity(this,Informations.class);
    }

    public void ClickReclamations(View view) {
        //Redirect activity to reclamations
        redirectActivity(this,Reclamations.class);
    }

    public void ClickAboutUs(View view) {
        //Redirect activity to About us
        redirectActivity(this,AboutUs.class);
    }

    public void ClickLogout(View view) {
        //Close app
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        MainActivity.closeDrawer(drawerlayout);
    }

    private void DisplayTrack(String sSource, String sDestination) {
        //If the device does not have a map installed, then redirect it to playsyore
        try {
            //When google map is installed
            //Initialize uri
            Uri uri = Uri.parse("https://wwww.google.co.in/maps/dir/" + sSource + "/" + sDestination);
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //Set package
            intent.setPackage("com.google.android.apps.maps");
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);
        }
        catch (ActivityNotFoundException exception){
            //When google map is not installed
            //Initialize uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.maps");
            //Initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //Set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);
        }
    }
}