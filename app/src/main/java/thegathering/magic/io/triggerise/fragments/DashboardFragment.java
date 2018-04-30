package thegathering.magic.io.triggerise.fragments;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.Arrays;

import io.magicthegathering.javasdk.resource.MtgSet;
import thegathering.magic.io.triggerise.R;
import thegathering.magic.io.triggerise.adapters.APiResponseAdapter;
import thegathering.magic.io.triggerise.callbacks.ApiResponseLoadedListener;
import thegathering.magic.io.triggerise.log.L;
import thegathering.magic.io.triggerise.recyclerview.ItemOffsetDecoration;
import thegathering.magic.io.triggerise.tasks.TaskLoadFromApi;


public class DashboardFragment extends Fragment implements ApiResponseLoadedListener {

    private ArrayList<MtgSet> setList = new ArrayList<>();
    private final Handler mHandler = new Handler();

    private APiResponseAdapter<MtgSet> apiResponseAdaptor;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<MtgSet> objectList = new ArrayList<>();

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recycler_view);

        setupRecyclerView(savedInstanceState);

        runLayoutAnimation(mRecyclerView);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mHandler.removeCallbacksAndMessages(null);
    }

    private void refreshItems() {

        runLayoutAnimation(mRecyclerView);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void setupRecyclerView(Bundle savedInstanceState) {
        final Context context = mRecyclerView.getContext();
        final int spacing = getResources().getDimensionPixelOffset(R.dimen.default_spacing_small);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        apiResponseAdaptor = new APiResponseAdapter<>(setList, getActivity(), mRecyclerView, MtgSet.class);
        mRecyclerView.setAdapter(apiResponseAdaptor);
        mRecyclerView.addItemDecoration(new ItemOffsetDecoration(spacing));
        String setCode = " ";
        if (setList.isEmpty()) {
            mSwipeRefreshLayout.setRefreshing(true);
            new TaskLoadFromApi(this, setCode, true).execute();

        } else {
            //set up pagination here
            mSwipeRefreshLayout.setRefreshing(true);
            new TaskLoadFromApi(this, setCode, true).execute();
        }
        apiResponseAdaptor.setObjectList(setList);
    }

    public void onApiResponseLoaded(ArrayList listItems) {
        mSwipeRefreshLayout.setRefreshing(false);
        apiResponseAdaptor.addToObjectList(listItems);

    }


}
