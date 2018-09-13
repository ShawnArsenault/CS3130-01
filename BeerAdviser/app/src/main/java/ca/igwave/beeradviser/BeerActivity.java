package ca.igwave.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BeerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
    }

    public void findBeerList(View view){
        Spinner spinner = findViewById(R.id.spnType);
        Button button = findViewById(R.id.btnFindBeer);
        TextView text = findViewById(R.id.txtBeerList);

        ArrayList<String> currentBrands = getBrands(String.valueOf(spinner.getSelectedItem()));
        StringBuilder brands = new StringBuilder();

        for(String b : currentBrands){
            brands.append(b).append("\n");
        }
        text.setText(brands);
    }

    public ArrayList<String> getBrands(String color){
        Log.d("testing", color);
        ArrayList<String> brands = new ArrayList<String>();
        if(color.equalsIgnoreCase("AMBER")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }else if(color.equalsIgnoreCase("LIGHT")){
            brands.add("Coors Light");
            brands.add("Moose Light");
        }else if(color.equalsIgnoreCase("BROWN")){
            brands.add("Brown Buggy");
            brands.add("Brown Betty");
        }else{
            brands.add("Guiness");
        }

        return brands;
    }


}
