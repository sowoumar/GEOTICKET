package geoticket.com.geoticket;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mLoginView;
    private EditText mPasswordView;
    BluetoothAdapter bluetoothAdapter;
    private int REQUEST_CODE_ENABLE_BLUETOOTH = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Set up the login form.
        mLoginView = (EditText) findViewById(R.id.login);

        // set up the password form;
        mPasswordView = (EditText) findViewById(R.id.password);

        activateBluetooth();
    }

    /**
     * permet d'activer le bluetooth
     */
    private void activateBluetooth() {

        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBlueTooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBlueTooth, REQUEST_CODE_ENABLE_BLUETOOTH);

        }
    }

    public void connect(View view) {
        String login = mLoginView.getText().toString();
        String password = mPasswordView.getText().toString();
        Boolean canConnect = verifyConnection(login, password);

        if (canConnect && bluetoothAdapter.isEnabled()) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Erreur mot de passe ou login", Toast.LENGTH_SHORT).show();
        }

    }

    private Boolean verifyConnection(String login, String password) {
        Boolean result = false;
        if (login.equals("admin") && password.equals("admin")) {
            result = true;
        }
        return result;
    }
}
