package interactionlab.launcher;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    protected boolean inAdminMode=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Add lines here for adding new activities, one extra activity has been commented, further can be done in the same manner
        //CREATING IMAGEBUTTONS
        ImageButton imagebutton1=(ImageButton) findViewById(R.id.activity1);
        ImageButton imagebutton2=(ImageButton) findViewById(R.id.activity2);
        ImageButton imagebutton3=(ImageButton) findViewById(R.id.activity3);
        ImageButton imagebutton4=(ImageButton) findViewById(R.id.activity4);
        ImageButton imagebutton5=(ImageButton) findViewById(R.id.activity5);
        ImageButton imagebutton6=(ImageButton) findViewById(R.id.activity6);
        //ImageButton imagebutton7=(ImageButton) findViewById(R.id.activity7);

        //CREATING ONCLICK_LISTENERS for each ImageButton
        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity1);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity2);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
        imagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity3);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity4);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
        imagebutton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity5);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
        imagebutton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity6);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
        /*
        imagebutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity7);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
         */


        //
        }
    public void onResume(){
        super.onResume();
        View decorView = this.getWindow().getDecorView();
        //To hide navigation bar in webview, uncomment the commented part in the line below and remove the semicolon.
        int uiOptions =  View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.adminMode) {
            inAdminMode=!inAdminMode;
            SpannableString sWhileON = new SpannableString("Turn Admin OFF");
            SpannableString sWhileOFF = new SpannableString("Turn Admin ON");
            if (inAdminMode) item.setTitle(sWhileON);
            else item.setTitle(sWhileOFF);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        // nothing to do here
        // … really
    }

    public void exit(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("Focus debug", "Focus changed !");
        if(!hasFocus) {
            Log.d("Focus debug", "Lost focus !");
            if (!inAdminMode) {
                Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
                sendBroadcast(closeDialog);
            }
        }

    }

}

