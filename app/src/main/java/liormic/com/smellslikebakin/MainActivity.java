package liormic.com.smellslikebakin;

import android.app.Fragment;

import android.app.ListActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.onReceipeSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      if(savedInstanceState == null) {
          ListFragment fragment = new ListFragment();
          FragmentManager fragmentManager = getSupportFragmentManager();
          FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
          fragmentTransaction.add(R.id.placeHolder, fragment);
          fragmentTransaction.commit();
      }
    }

    @Override
    public void onListRecipeSelected(int index) {
        Toast.makeText(MainActivity.this,Recpies.names[index],Toast.LENGTH_SHORT).show();

          ViewPagerFragment fragment = new ViewPagerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment);
      fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
