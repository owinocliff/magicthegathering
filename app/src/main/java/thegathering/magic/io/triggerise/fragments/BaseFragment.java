package thegathering.magic.io.triggerise.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;


import io.magicthegathering.javasdk.resource.MtgSet;
import thegathering.magic.io.triggerise.R;
import thegathering.magic.io.triggerise.adapters.APiResponseAdapter;
import thegathering.magic.io.triggerise.callbacks.ApiResponseLoadedListener;
import thegathering.magic.io.triggerise.log.L;
import thegathering.magic.io.triggerise.pojo.AnimationStyle;
import thegathering.magic.io.triggerise.recyclerview.ItemOffsetDecoration;
import thegathering.magic.io.triggerise.tasks.TaskLoadFromApi;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public abstract class BaseFragment<T> extends Fragment implements ApiResponseLoadedListener {
    private final Handler mHandler = new Handler();
    private static final String STATE_CATEGORIES = "state_data";

    private AnimationStyle mSelectedStyle;
    private APiResponseAdapter<T> apiResponseAdaptor;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<T> objectList = new ArrayList<>();

    /**
     * Get the layout to use
     *
     * @return the resource id
     */
    protected abstract int getLayoutResId();

    /**
     * Get the layout manager
     *
     * @param context the context
     * @return the layout manager
     */
    protected abstract RecyclerView.LayoutManager getLayoutManager(Context context);

    /**
     * Get the array of animations to choose from
     *
     * @return the array
     */
    protected abstract List<AnimationStyle> getAnimationItems();

    /**
     * Get the array of animations to choose from
     *
     * @return the category type id
     */
    protected abstract ArrayList<T> getObjectList();

    protected abstract ArrayList<T> addToObjectList();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
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

        List<AnimationStyle> mAnimationStyles = getAnimationItems();

        mSelectedStyle = mAnimationStyles.get(0);

        mRecyclerView = view.findViewById(R.id.recycler_view);

        setupRecyclerView(savedInstanceState);

        runLayoutAnimation(mRecyclerView, mSelectedStyle);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mHandler.removeCallbacksAndMessages(null);
    }

    private void refreshItems() {

        runLayoutAnimation(mRecyclerView, mSelectedStyle);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    private void runLayoutAnimation(final RecyclerView recyclerView, final AnimationStyle item) {
        final Context context = recyclerView.getContext();

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, item.getResourceId());

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }


    private void setupRecyclerView(Bundle savedInstanceState) {
        final Context context = mRecyclerView.getContext();
        final int spacing = getResources().getDimensionPixelOffset(R.dimen.default_spacing_small);


        mRecyclerView.setLayoutManager(getLayoutManager(context));
        apiResponseAdaptor = new APiResponseAdapter<>(getObjectList(), getActivity(), mRecyclerView, MtgSet.class);
        mRecyclerView.setAdapter(apiResponseAdaptor);
        L.m("categoryList " + getObjectList().toString());
        mRecyclerView.addItemDecoration(new ItemOffsetDecoration(spacing));
//        if (savedInstanceState != null) {
            //if this fragment starts after a rotation or configuration change, load the existing list from a parcelable
//            getObjectList() = (ArrayList<T>) savedInstanceState.getParcelableArrayList(STATE_CATEGORIES);
//        } else {
            //testing
//            for (int i = 0; i <= 10; i++) {
//                getObjectList().add((T) new Card());
//            }

//            if (getObjectList().isEmpty()) {
//                // last parameter should be request type i.e top level or next level
//
//                mSwipeRefreshLayout.setRefreshing(true);
//                new TaskLoadFromApi(this).execute();
//
//            } else {
//                mSwipeRefreshLayout.setRefreshing(true);
//                new TaskLoadFromApi(this).execute();
//            }
//        }

        apiResponseAdaptor.setObjectList(getObjectList());
    }

    public void addToList(ArrayList<T> newList){
        mSwipeRefreshLayout.setRefreshing(false);
        apiResponseAdaptor.addToObjectList(newList);

    }


}
