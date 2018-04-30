package thegathering.magic.io.triggerise.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;
import thegathering.magic.io.triggerise.R;
import thegathering.magic.io.triggerise.fragments.DashboardFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(new DashboardFragment(), "DashboardFragment");
    }


    public void showFragment(Fragment fragment, String name) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.container, fragment, name)
                .addToBackStack(name)
                .commit();
    }


}
