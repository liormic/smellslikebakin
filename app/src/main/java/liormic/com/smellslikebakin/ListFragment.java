package liormic.com.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Liorm on 6/14/2016.
 */
public class ListFragment extends Fragment {

 public interface onReceipeSelectedInterface {

        void onListRecipeSelected(int index);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onReceipeSelectedInterface listner = (onReceipeSelectedInterface) getActivity();
        View view= inflater.inflate(R.layout.fragment_list,container,false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.listRecyclerView);
        ListAdapter listAdapter = new ListAdapter(listner);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;


    }



}
