package com.example.forexjapan.activity.customerDetail.tabs.customerDetail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.forexjapan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerDetailFragment extends Fragment {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button btnDisplay;

    public CustomerDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_detail, container, false);


        //hide the soft keyboard from inside a fragment
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        radioGroup = (RadioGroup) view.findViewById(R.id.radio);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radioMale:
                        // switch to fragment 1
                        break;
                    case R.id.radioFemale:
                        // Fragment 2
                        break;
                }
            }
        });

        return view;
    }

}
