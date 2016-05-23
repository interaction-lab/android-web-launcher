package interactionlab.launcher;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

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
        //ImageButton imagebutton4=(ImageButton) findViewById(R.id.activity4);

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
        /*
        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, WebViewPage.class);
                String mystring = getResources().getString(R.string.url_activity4);
                intent1.putExtra("activityurl",mystring);
                startActivity(intent1);
            }
        });
         */
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
        if (id == R.id.exit) {
            exit();
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

}
