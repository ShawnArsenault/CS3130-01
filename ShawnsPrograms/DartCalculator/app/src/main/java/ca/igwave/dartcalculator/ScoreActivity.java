package ca.igwave.dartcalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends Activity {
    public static final String PASS_SCORE = "passScore";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent intent = getIntent();
        TextView curScore = (TextView) findViewById(R.id.txtCurrentScore);
        curScore.setText(intent.getStringExtra(PASS_SCORE));
    }

    public void addScore(View view){
        TextView dart1 = findViewById(R.id.txtDart1);
        TextView dart2 = findViewById(R.id.txtDart2);
        TextView dart3 = findViewById(R.id.txtDart3);

        TextView thrownScore = findViewById(R.id.txtThrownScore);
        TextView currentScore = findViewById(R.id.txtCurrentScore);
        TextView newScore = findViewById(R.id.txtNewScore);

        int threedarts = Integer.parseInt(dart1.getText().toString()) + Integer.parseInt(dart2.getText().toString()) + Integer.parseInt(dart3.getText().toString());
        thrownScore.setText("" + threedarts);

        int intNewScore =  Integer.parseInt(currentScore.getText().toString()) - threedarts;
        newScore.setText("" + intNewScore);
    }

    public void calcAndReturn(View view){
        Intent intent = new Intent(this,MainActivity.class);
        TextView newScore = findViewById(R.id.txtNewScore);
        Log.d("ScoreTestBefore",newScore.getText().toString());
        intent.putExtra("newScore",newScore.getText().toString());
        startActivityForResult(intent,1);
    }
}
