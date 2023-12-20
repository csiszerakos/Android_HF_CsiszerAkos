package com.example.hf6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {
    ListView myList;
    Integer[] currencyImage = {R.drawable.european, R.drawable.unitedstates, R.drawable.unitedkingdom, R.drawable.australia, R.drawable.canada, R.drawable.russia, R.drawable.denmark, R.drawable.hungary};

    String[] currencyShort = {"EUR", "USD", "GBP", "AUD", "CAD", "RUB", "DFF", "HUF"};

    String[] currencyLong = {"Euro", "Dollar American", "Liria sterlina", "Dollar Australian", "Dollar canadian", "Rubbel Russian", "Corona Daneza", "Forint Maghiar",};

    String[] buyPrice = {"4,4100 RON", "3,9750 RON", "6,1250 RON", "2,9600 RON", "3,0950 RON", "4,2300 RON", "0,5850 RON", "0,0136 RON",};

    String[] sellPrice = {"4,5500 RON", "4,1450 RON", "6,3550 RON", "3,0600 RON", "3,2650 RON", "4,3300 RON", "0,6150 RON", "0,0146 RON",};


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blank1, container, false);
        myList = rootView.findViewById(R.id.list_view); // Find the ListView in the inflated view

        CustomListViewAdapter adapter = new CustomListViewAdapter(getActivity(), currencyImage, currencyShort, currencyLong, buyPrice, sellPrice);
        myList.setAdapter(adapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedShort = currencyShort[position];
                int selectedImage = currencyImage[position];
                String selectedBuyPrice = buyPrice[position];
                String selectedSellPrice = sellPrice[position];
                String selectedLong = currencyLong[position];

                navigateToFragment2(selectedShort, selectedImage, selectedBuyPrice, selectedSellPrice, selectedLong);
            }
        });
        return rootView;
    }

    private void navigateToFragment2(String selectedShort, int selectedImage, String selectedBuyPrice, String selectedSellPrice, String selectedLong) {
        BlankFragment2 fragment2 = BlankFragment2.newInstance(selectedShort, selectedImage, selectedBuyPrice, selectedSellPrice, selectedLong);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment2)
                .addToBackStack(null)
                .commit();
    }
}



