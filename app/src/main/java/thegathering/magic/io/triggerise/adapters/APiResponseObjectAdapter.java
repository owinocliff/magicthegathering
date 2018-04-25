package thegathering.magic.io.triggerise.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import thegathering.magic.io.triggerise.R;
import thegathering.magic.io.triggerise.log.L;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class APiResponseObjectAdapter<T> extends RecyclerView.Adapter<APiResponseObjectAdapter.ViewHolder>{

    private ArrayList<T> setList = new ArrayList<>();
    private Context context;
    private  RecyclerView mRecyclerView;

    public APiResponseObjectAdapter(ArrayList<T> setList, Context context, RecyclerView mRecyclerView) {
        this.setList = setList;
        this.context = context;
        this.mRecyclerView = mRecyclerView;
        L.m("categoryList "+ setList.toString()+" context"+context);
    }

    public void setSetList(ArrayList<T> setList) {
        this.setList = setList;
        notifyItemRangeChanged(0, setList.size());

    }

    public void addToSetsList(ArrayList<T> newCategoryList) {

        int previousSize = setList.size();
        setList.addAll(newCategoryList);// confirm this method, may produce duplicates
        notifyItemRangeChanged(previousSize, newCategoryList.size());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.row_empty_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final T current = setList.get(position);
        holder.card_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                L.m("Position onClick ");


            }
        });

    }

    @Override
    public int getItemCount() {
        if (setList != null) {
            return setList.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout card_item;

        ViewHolder(View itemView) {
            super(itemView);

            card_item =  itemView.findViewById(R.id.card_item);
        }
    }
}
