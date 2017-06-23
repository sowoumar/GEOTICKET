package geoticket.com.geoticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void testDatabase(View view) {
        Intent intent =  new Intent(this, ComptabilityActivity.class);
        startActivity(intent);
    }
	
	public void gotoselectiontarif (View view) {
		Intent intent = new Intent(this,SelectionTarifActivity.class);
		startActivity(intent);
	}
}
