package shubham.tfin;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by shubham on 20/5/15.
 */
public class Confirmation extends ActionBarActivity{
    Toolbar toolbar;
    ImageButton btnGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        toolbar = (Toolbar) findViewById(R.id.app_barC);
        setSupportActionBar(toolbar);

        btnGo = (ImageButton) findViewById(R.id.idbtnGoC);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
            }
        });
    }
}
