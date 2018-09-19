package ca.igwave.dartcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void resetScore(View view){
        TextView v = view.findViewById(R.id.txtScore);
        String def = "@string/defaultScore";
        //v.setText(def);
    }

    public void scoreDarts(View view){
        Intent intent = new Intent(this,ScoreActivity.class);
        TextView score = findViewById(R.id.txtScore);


        String stringScore = score.getText().toString();

        Log.d("ScoreCheck", stringScore);

        intent.putExtra("passScore",stringScore);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
        String updatedScore = data.getStringExtra("newScore");
        Log.d("ScoreTest",updatedScore);
        TextView score = findViewById(R.id.txtNewScore);
        score.setText("" + updatedScore);
        }

    }
}
