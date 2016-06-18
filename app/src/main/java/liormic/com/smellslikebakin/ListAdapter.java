package liormic.com.smellslikebakin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PrivateKey;

/**
 * Created by Liorm on 6/17/2016.
 */
public class ListAdapter extends RecyclerView.Adapter {
    private final ListFragment.onReceipeSelectedInterface mListener;

    public ListAdapter(ListFragment.onReceipeSelectedInterface listner) {
        mListener = listner;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recpies.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private ImageView mImageView;
       private int mIndex;
        public ListViewHolder(View itemView) {

            super(itemView);
            mTextView  = (TextView) itemView.findViewById(R.id.itemText);
            mImageView  = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);

        }

        public void bindView(int position){
        mTextView.setText(Recpies.names[position]);
            mImageView.setImageResource(Recpies.resourceIds[position]);
            mIndex= position;
        }

        @Override
        public void onClick(View v) {
         mListener.onListRecipeSelected(mIndex);
        }
    }
}
