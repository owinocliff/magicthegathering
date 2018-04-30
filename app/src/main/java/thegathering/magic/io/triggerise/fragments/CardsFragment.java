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
import java.util.List;

import io.magicthegathering.javasdk.resource.Card;
import thegathering.magic.io.triggerise.R;
import thegathering.magic.io.triggerise.activities.MainActivity;
import thegathering.magic.io.triggerise.adapters.APiResponseAdapter;
import thegathering.magic.io.triggerise.callbacks.ApiResponseLoadedListener;
import thegathering.magic.io.triggerise.log.L;
import thegathering.magic.io.triggerise.recyclerview.ItemOffsetDecoration;
import thegathering.magic.io.triggerise.tasks.TaskLoadFromApi;

public class CardsFragment extends Fragment implements ApiResponseLoadedListener {
    List<Card> cardList = new ArrayList<>();
    String setCode;
    private final Handler mHandler = new Handler();
    private APiResponseAdapter<Card> apiResponseAdaptor;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;


    public CardsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cards, container, false);
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
        apiResponseAdaptor = new APiResponseAdapter<>((ArrayList<Card>) cardList, getActivity(), mRecyclerView, Card.class);
        mRecyclerView.setAdapter(apiResponseAdaptor);
        mRecyclerView.addItemDecoration(new ItemOffsetDecoration(spacing));
        String setCode = "";
        Bundle args = getArguments();
        if (args != null) {
            setCode = args.getString("SETCODE");
        }
        if (cardList.isEmpty()) {
            mSwipeRefreshLayout.setRefreshing(true);
            new TaskLoadFromApi(this, setCode, false).execute();

        } else {
            //set up pagination here
            mSwipeRefreshLayout.setRefreshing(true);
            new TaskLoadFromApi(this, setCode, false).execute();
        }
        apiResponseAdaptor.setObjectList((ArrayList<Card>) cardList);
    }

    @Override
    public void onApiResponseLoaded(ArrayList listItems) {
        L.m("onApiResponseLoaded " + Arrays.asList(listItems));
        mSwipeRefreshLayout.setRefreshing(false);
        apiResponseAdaptor.addToObjectList(listItems);
    }
}
