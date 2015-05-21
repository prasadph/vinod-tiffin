package shubham.tfin;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;
    private FoodClassAdapter adapter;
    private RecyclerView recyclerView;
    TextView total;
    ImageButton btnGo;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        total = (TextView) findViewById(R.id.idTotal);


        recyclerView = (RecyclerView) findViewById(R.id.foodList);
        adapter = new FoodClassAdapter(this, getData(), total);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnGo = (ImageButton) findViewById(R.id.idbtnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), LocActivity.class);
                startActivity(i);
            }
        });
    }

    private List<FoodListData> getData(){
        List<FoodListData> list = new ArrayList<>();
        int[] icons = {R.drawable.goa100x100, R.drawable.maharas100x100, R.drawable.south100x100, R.drawable.rajasthani100x100};
        String[] titles = getResources().getStringArray(R.array.titles);
        double[] rates = {100.0, 200.0, 249.0, 200.0};

        for(int i = 0; i< 14; i++)
        {
            FoodListData data = new FoodListData();
            data.FImgID = icons[i%4];
            data.FTitle = titles[i%4];
            data.FPrice = rates[i%4];
            data.FQuantity = 0;
            list.add(data);
        }
        return list;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
