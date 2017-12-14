package com.example.shivani.customdrawer;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyDashboardFragment extends Fragment {
    ImageView imageViewIcon;
    TextView textViewItemName;
    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    public MyDashboardFragment() {
        // Required empty public constructor
    }
    
    public static MyDashboardFragment newInstance() {
        MyDashboardFragment fragment = new MyDashboardFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_dashboard, container,
                false);

        imageViewIcon = (ImageView) view.findViewById(R.id.frag1_icon);
        textViewItemName = (TextView) view.findViewById(R.id.frag1_text);

        textViewItemName.setText(getArguments().getString(ITEM_NAME));
        imageViewIcon.setImageDrawable(view.getResources().getDrawable(
                getArguments().getInt(IMAGE_RESOURCE_ID)));
        return view;
    }

    
}
