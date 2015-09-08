package com.example.stone.designsupportdemo;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<LinearItem> Ldatalist;
    LinearAdapter LmAdapter;
    bigAdapter BmAdapter;
    ArrayList<bigItem> Bdatalist;
    dragdropAdapter DmAdapter;
    ArrayList<LinearItem> Ddatalist;
    expandableAdapter EmAdapter;
    ArrayList<Object> Edatalist;
    int imageid = R.drawable.ie;
    int type = 0;

    public static RecyclerFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        RecyclerFragment fragment = new RecyclerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getInt("type");
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.linear_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.ItemAnimator ia = new DefaultItemAnimator();
        ia.setAddDuration(200);
        ia.setRemoveDuration(200);
        recyclerView.setItemAnimator(ia);
        System.out.println("type:" + type);
        switch(type){
            case(1):{
                Ldatalist = new ArrayList<LinearItem>();
                LmAdapter = new LinearAdapter(Ldatalist,recyclerView.getContext(),(Activity)recyclerView.getContext());
                recyclerView.setAdapter(LmAdapter);
                break;
            }
            case(2):{
                Bdatalist = new ArrayList<bigItem>();
                BmAdapter = new bigAdapter(Bdatalist,recyclerView.getContext(),(Activity)recyclerView.getContext());
                recyclerView.setAdapter(BmAdapter);
                break;
            }
            case(3):{
                Ddatalist = new ArrayList<LinearItem>();
                DmAdapter = new dragdropAdapter(Ddatalist,recyclerView.getContext(),(Activity)recyclerView.getContext());
                recyclerView.setAdapter(DmAdapter);
                SimpleItemTouchHelperCallback callback = new SimpleItemTouchHelperCallback(DmAdapter);
                ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
                touchHelper.attachToRecyclerView(recyclerView);
                break;
            }
            case(4):{
                Edatalist = new ArrayList<Object>();
                EmAdapter = new expandableAdapter(Edatalist);
                recyclerView.setAdapter(EmAdapter);
                break;
            }
        }

        return v;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
    public void removeAll(){
        switch (type){
            case(1):{
                LmAdapter.removeAll();
                break;
            }
            case(2):{
                BmAdapter.removeAll();
                break;
            }
            case(3):{
                DmAdapter.removeAll();
                break;
            }
            case(4):{
                EmAdapter.removeAll();
                break;
            }
        }
    }
    public void add(){
        switch (type){
            case(1):{
                String msg = "";
                int i = (int)(Math.random()*5);
                switch(i){
                    case(0):{
                        msg = "dasdasdsada";
                        break;
                    }
                    case(1):{
                        msg = "asdawdnqownwoiefnwiuofen";
                        break;
                    }
                    case(2):{
                        msg = "ekjfnwjfn wpoficwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(3):{
                        msg = "ekjfnwjfasdasfmwgn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(4):{
                        msg = "ekjfnsdf wkjefbnwiuewenoifnweiofnwrgioewnrgioengn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(5):{
                        msg = "ekjfnsasldmnqwoiefnbweiubfg3784gbf83474bf7834frf234f3df wkjefbnwiuefbweuifv bwouibviwfvwerfvwjfasdasfmwenoifnweiofnwrgioewnrgioengn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                }
                LmAdapter.additem(new LinearItem(imageid,"編號:"+LmAdapter.getItemCount(),msg));
                recyclerView.smoothScrollToPosition(LmAdapter.getItemCount());
                break;
            }
            case(2):{
                String msg = "";
                int i = (int)(Math.random()*5);
                switch(i){
                    case(0):{
                        msg = "dasdasdsada";
                        break;
                    }
                    case(1):{
                        msg = "asdawdnqownwoiefnwiuofen";
                        break;
                    }
                    case(2):{
                        msg = "ekjfnwjfn wpoficwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(3):{
                        msg = "ekjfnwjfasdasfmwgn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(4):{
                        msg = "ekjfnsdf wkjefbnwiuewenoifnweiofnwrgioewnrgioengn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(5):{
                        msg = "ekjfnsasldmnqwoiefnbweiubfg3784gbf83474bf7834frf234f3df wkjefbnwiuefbweuifv bwouibviwfvwerfvwjfasdasfmwenoifnweiofnwrgioewnrgioengn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                }
                BmAdapter.additem(new bigItem(imageid,"編號:"+BmAdapter.getItemCount(),msg,"隱藏"+BmAdapter.getItemCount()));
                recyclerView.smoothScrollToPosition(BmAdapter.getItemCount());
                break;
            }
            case(3):{
                String msg = "";
                int i = (int)(Math.random()*5);
                switch(i){
                    case(0):{
                        msg = "dasdasdsada";
                        break;
                    }
                    case(1):{
                        msg = "asdawdnqownwoiefnwiuofen";
                        break;
                    }
                    case(2):{
                        msg = "ekjfnwjfn wpoficwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(3):{
                        msg = "ekjfnwjfasdasfmwgn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(4):{
                        msg = "ekjfnsdf wkjefbnwiuewenoifnweiofnwrgioewnrgioengn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                    case(5):{
                        msg = "ekjfnsasldmnqwoiefnbweiubfg3784gbf83474bf7834frf234f3df wkjefbnwiuefbweuifv bwouibviwfvwerfvwjfasdasfmwenoifnweiofnwrgioewnrgioengn wpoficnwoiefnwoiepfcnwoiefnwoif3oiurhn2oiefwfwe";
                        break;
                    }
                }
                DmAdapter.additem(new LinearItem(imageid,"編號:"+DmAdapter.getItemCount(),msg));
                recyclerView.smoothScrollToPosition(DmAdapter.getItemCount());
                break;
            }
            case(4):{
                String msg = "";
                ArrayList<childItem> child = new ArrayList<childItem>();
                int i = (int)(Math.random()*5);
                switch(i){
                    case(0):{
                        msg = "eee4";
                        child.add(new childItem("qqqq"));
                        child.add(new childItem("qwwqqq"));
                        child.add(new childItem("qqqweqqq"));
                        child.add(new childItem("ccq"));
                        break;
                    }
                    case(1):{
                        msg = "eesdfsfewe2";
                        child.add(new childItem("qqqq"));
                        child.add(new childItem("qwwawrqwrqqq"));
                        break;
                    }
                    case(2):{
                        msg = "eee2";
                        child.add(new childItem("qqqq"));
                        child.add(new childItem("qwwqqq"));
                        break;
                    }
                    case(3):{
                        msg = "eee4";
                        child.add(new childItem("qqqq"));
                        child.add(new childItem("qwwqqq"));
                        child.add(new childItem("qwwqqq"));
                        child.add(new childItem("qwwqqq"));
                        break;
                    }
                    case(4):{
                        msg = "no0";
                        break;
                    }
                    case(5):{
                        msg = "eeasde1";
                        child.add(new childItem("qaaaqqq"));
                        break;
                    }
                }
                EmAdapter.additem(new parentItem(child,msg));
                recyclerView.smoothScrollToPosition(EmAdapter.getItemCount());
                break;
            }
        }
    }
}
