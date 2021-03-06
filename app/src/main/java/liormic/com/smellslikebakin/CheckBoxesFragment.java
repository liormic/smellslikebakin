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
public abstract class CheckBoxesFragment extends Fragment {
    private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    private  CheckBox[] mCheckBoxes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
          View view = inflater.inflate(R.layout.fragment_checboxes,container,false);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.checkboxesLayout);
String[] contents =getContents(index);

 mCheckBoxes=new CheckBox[contents.length];
        boolean[] checkedBoxes= new boolean[mCheckBoxes.length];
        if(savedInstanceState!= null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES)!= null){
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }
setUpCheckBoxes(contents,linearLayout,checkedBoxes);
        return view;
    }

    public abstract String[] getContents(int index) ;

    private  void setUpCheckBoxes(String[] contents, ViewGroup container, boolean[] checkedBoxes){
        int i=0;
for(String content :contents){
     mCheckBoxes[i]= new CheckBox(getActivity());
    mCheckBoxes[i].setPadding(8,16,8,16);
    mCheckBoxes[i].setTextSize(20f);
    mCheckBoxes[i].setText(content);
       container.addView(mCheckBoxes[i]);
    if(checkedBoxes[i]){
        mCheckBoxes[i].toggle();
    }
    i++;
        }
        }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCcheckBoxes= new boolean[mCheckBoxes.length];
        int i=0;
        for(CheckBox checkBox:mCheckBoxes){
            stateOfCcheckBoxes[i]=  checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES,stateOfCcheckBoxes);
        super.onSaveInstanceState(outState);
    }
}