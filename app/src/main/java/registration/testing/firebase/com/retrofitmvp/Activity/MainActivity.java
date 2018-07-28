package registration.testing.firebase.com.retrofitmvp.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import registration.testing.firebase.com.retrofitmvp.R;

public class MainActivity extends AppCompatActivity {
    final static String TAG = "FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction();
            fragmentTransaction.add(R.id.container, new MainFragment(), TAG);
            fragmentTransaction.commit();
        }
    }
}
