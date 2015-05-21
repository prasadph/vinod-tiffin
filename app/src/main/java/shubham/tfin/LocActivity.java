package shubham.tfin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shubham on 20/5/15.
 */
public class LocActivity extends ActionBarActivity{
    Toolbar actionBar;
    Spinner spView;
    List<String> locList;
    ImageButton btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc);

        actionBar = (Toolbar) findViewById(R.id.app_barL);
        setSupportActionBar(actionBar);
        spView = (Spinner) findViewById(R.id.idLocList);
        locList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.loc)));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, locList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spView.setAdapter(adapter);

//        spView.setOnItemClickListener(new );
        btnGo = (ImageButton) findViewById(R.id.idbtnGoL);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent L = new Intent(getBaseContext(), Confirmation.class);
                startActivity(L);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

//class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener
//{
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//}