package liormic.com.smellslikebakin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Liorm on 6/19/2016.
 */
public class ViewPagerFragment extends Fragment {
     public static final String KEY_RECIPE_INDEX ="receipe index";


    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recpies.names[index]);
        View view = inflater.inflate(R.layout.fragmet_viewpager,container,false);
        final IngredientsFragment ingerdientsFragment = new IngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        ingerdientsFragment.setArguments(bundle);
        final DirectionsFragment directionsFragment = new DirectionsFragment();
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                    return position == 0 ? ingerdientsFragment : directionsFragment;

            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position ==0 ?"Ingridents": "Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        TabLayout tabLayout= (TabLayout) view.findViewById(R.id.tanLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
