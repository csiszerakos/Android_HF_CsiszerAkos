package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView moneyList;
    String currencyshortList[]= {"AUD","CAD","DKK","EUR","HUF","RUB","GBP","USD"};
    String currencynameList[] = {"Australian dollar","Canadian dollar","Danish Krone","Euro","Hungarian forint","Russian rubel","British pound sterling","United States dollar"};
    int currencyImage[] = {R.drawable.australia,R.drawable.canada,R.drawable.denmark,R.drawable.european,R.drawable.hungary,R.drawable.russia,R.drawable.unitedkingdom,R.drawable.unitedstates};
    String buyprice[] = {"2,960 RON","3,095 RON","0,585 RON","4,410 RON","0,013 RON","0,050 RON","6,125 RON","3,975 RON"};
    String sellprice[] = {"3,060 RON","3,265 RON","4,330 RON","4,550 RON","0,014 RON","0,058 RON","6,355 RON","4,145 RON"};


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        moneyList = findViewById(R.id.moneyList);
        MainActivity2 adapter = new MainActivity2(this,currencyImage,currencynameList,currencyshortList,buyprice,sellprice);
        moneyList.setAdapter(adapter);

        moneyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            TextView buypriceText = view.findViewById(R.id.buyprice);
            TextView sellpriceText = view.findViewById(R.id.sellprice);
            TextView buyText = view.findViewById(R.id.buyText);
            TextView sellText = view.findViewById(R.id.sellText);
            TextView shortText = view.findViewById(R.id.currencyshort);
            TextView nameText = view.findViewById(R.id.currencyname);

            shortText.setText(currencyshortList[position]);
            nameText.setText(currencynameList[position]);
            buyText.setText("Buy: ");
            sellText.setText("Sell: ");
            buypriceText.setText(buyprice[position]);
            sellpriceText.setText(sellprice[position]);

            }
        });

    }
}