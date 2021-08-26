package bf.esmt.easytransport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import bf.esmt.findtransport.R;

public class MainActivity extends AppCompatActivity {
    //Initialise variable
    DrawerLayout drawerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        drawerlayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view) {
        //Open drawer
        openDrawer(drawerlayout);
    }

    public static void openDrawer(DrawerLayout drawerlayout) {
        //Open drawer layout
        drawerlayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        //Close drawer
        closeDrawer(drawerlayout);
    }

    public static void closeDrawer(DrawerLayout drawerlayout) {
        //Close drawer layout
        //Check condition
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            //When drawer is open
            drawerlayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view) {
        //Recreate activity
        recreate();
    }

    public void ClickTrajets(View view) {
        //Redirect activity to my account
        redirectActivity(this,Trajets.class);
    }

    public void ClickTarifs(View view) {
        //Redirect activity to my account
        redirectActivity(this,Tarifs.class);
    }

    public void ClickHoraires(View view) {
        //Redirect activity to my account
        redirectActivity(this,Horaires.class);
    }

    public void ClickReservationsBus(View view) {
        //Redirect activity to my account
        redirectActivity(this,Reservations.class);
    }

    public void ClickAccount(View view) {
        //Redirect activity to my account
        redirectActivity(this,Account.class);
    }

    public void ClickInformations(View view) {
        //Redirect activity to my account
        redirectActivity(this,Informations.class);
    }

    public void ClickReclamations(View view) {
        //Redirect activity to my account
        redirectActivity(this,Reclamations.class);
    }

    public void ClickAboutUs(View view) {
        //Redirect activity to about us
        redirectActivity(this,AboutUs.class);
    }

    public void ClickLogout(View view) {
        //Close app
        logout(this);
    }

    public static void logout(Activity activity) {
        //Initialise alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Se deconnecter");
        //set message
        builder.setMessage("Etes vous sur de vouloir vous deconnecter?");
        //Positive yes button
        builder.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);
            }
        });
        //Negative no button
        builder.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //Show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity,Class aClass) {
        //Initialize intent
        Intent intent = new Intent(activity,aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerlayout);
    }

    public void ClickElitis(View view) {
        //Redirect activity to reservation elitis
        redirectActivity(this,ElitisReservation.class);
    }

    public void ClickTCV(View view) {
        //Redirect activity to reservation TCV
        redirectActivity(this,TcvReservation.class);
    }

    public void ClickRahimo(View view) {
        //Redirect activity to reservation Rahimo
        redirectActivity(this,RahimoReservation.class);
    }

    public void ClickSBTA(View view) {
        //Redirect activity to reservation SBTA
        redirectActivity(this,SbtaReservation.class);
    }

    public void ClickSTAF(View view) {
        //Redirect activity to reservation STAF
        redirectActivity(this,StafReservation.class);
    }

    public void ClickSaramaya(View view) {
        //Redirect activity to reservation Saramaya
        redirectActivity(this,SaramayaReservation.class);
    }

    public void ClickUTB(View view) {
        //Redirect activity to reservation UTB
        redirectActivity(this,UtbResrvation.class);
    }

    public void ClickTSR(View view) {
        //Redirect activity to reservation TSR
        redirectActivity(this,TsrReservation.class);
    }

    public void ClickRakieta(View view) {
        //Redirect activity to reservation Rakieta
        redirectActivity(this,RakietaReservation.class);
    }
}