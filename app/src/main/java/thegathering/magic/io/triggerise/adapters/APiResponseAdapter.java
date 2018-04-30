package thegathering.magic.io.triggerise.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;
import thegathering.magic.io.triggerise.R;
import thegathering.magic.io.triggerise.activities.MainActivity;
import thegathering.magic.io.triggerise.fragments.CardsFragment;
import thegathering.magic.io.triggerise.log.L;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class APiResponseAdapter<T> extends RecyclerView.Adapter<APiResponseAdapter.ViewHolder> {

    private ArrayList<T> objectList = new ArrayList<>();
    private Class currentClass;
    private Context context;
    private RecyclerView mRecyclerView;

    public APiResponseAdapter(ArrayList<T> setList, Context context, RecyclerView mRecyclerView, Class currentClass) {
        this.objectList = setList;
        this.currentClass = currentClass;
        this.context = context;
        this.mRecyclerView = mRecyclerView;
    }

    public void setObjectList(ArrayList<T> objectList) {
        this.objectList = objectList;
//        notifyItemRangeChanged(0, objectList.size());

    }

    public void addToObjectList(ArrayList<T> newCategoryList) {

        int previousSize = objectList.size();
        objectList.addAll(newCategoryList);// confirm this method, may produce duplicates
        notifyItemRangeChanged(previousSize, newCategoryList.size());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.row_empty_card, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (currentClass == MtgSet.class) {
            final MtgSet current = (MtgSet) objectList.get(position);

            holder.set_code.setText(current.getCode());
            holder.set_name.setText(current.getName());
            holder.set_mkm_id.setText(current.getMagicCardsInfoCode());
            holder.card_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    CardsFragment newFragment = new CardsFragment();
                    Bundle args = new Bundle();
                    args.putString("SETCODE",current.getCode());
                    newFragment.setArguments(args);
                    ((MainActivity) context).showFragment(newFragment, "CardsFragment");
                    L.m("Position onClick ");


                }
            });
        }else if (currentClass == Card.class){
            final Card current = (Card) objectList.get(position);
            L.m("in card");
            holder.set_code.setText(current.getText());
            holder.set_name.setText(current.getOriginalText());
            holder.set_mkm_id.setText(current.getImageName());
        }
    }

    @Override
    public int getItemCount() {
        if (objectList != null) {
            return objectList.size();
        }
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout card_item;
        TextView set_name, set_code, set_mkm_id;

        ViewHolder(View itemView) {
            super(itemView);

            card_item = itemView.findViewById(R.id.card_item);
            set_name = itemView.findViewById(R.id.set_name);
            set_code = itemView.findViewById(R.id.set_code);
            set_mkm_id = itemView.findViewById(R.id.set_mkm_id);
        }
    }
}
