package liormic.com.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by Liorm on 6/19/2016.
 */
public class IngredientsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);

          View view = inflater.inflate(R.layout.fragment_ingridents,container,false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.ingridentsLayout);
String[] ingredients = Recpies.ingredients[index].split("`");

setUpCheckBoxes(ingredients,linearLayout);
        return view;
    }
    private  void setUpCheckBoxes(String[] ingredients,ViewGroup container){
for(String ingredient :ingredients){
        CheckBox checkBox = new CheckBox(getActivity());
        checkBox.setPadding(8,16,8,16);
        checkBox.setTextSize(20f);
        checkBox.setText(ingredient);
       container.addView(checkBox);
        }
        }
}