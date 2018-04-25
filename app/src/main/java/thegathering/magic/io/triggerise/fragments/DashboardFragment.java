package thegathering.magic.io.triggerise.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import thegathering.magic.io.triggerise.R;
import thegathering.magic.io.triggerise.log.L;
import thegathering.magic.io.triggerise.pojo.AnimationStyle;
import thegathering.magic.io.triggerise.pojo.Set;
import thegathering.magic.io.triggerise.tasks.TaskLoadFromApi;


public class DashboardFragment extends BaseFragment {

    private ArrayList<Set> setList = new ArrayList<>();

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_dashboard;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }


    @Override
    protected List<AnimationStyle> getAnimationItems() {
        List<AnimationStyle> theList = new ArrayList<>();
        theList.add(new AnimationStyle("Slide from bottom", R.anim.layout_animation_from_bottom));
        return theList;
    }

    @Override
    protected ArrayList<?> getObjectList() {
        return setList;
    }


    @Override
    public void onApiResponseLoaded(ArrayList listItems) {

    }

}
