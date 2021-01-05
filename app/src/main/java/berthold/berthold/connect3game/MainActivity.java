package berthold.berthold.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int activePlayer = 1;

    public void dropIn (View view) {

        Log.i("Info:", view.getTag().toString());
        int i = Integer.parseInt(view.getTag().toString());

        int[] gameState [2,2,2,2,2,2,2,2,2]


        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1500);

        //array in if-Statements nicht möglich
        //Prüfung, ob Feld schon belegt ist, um nicht mehrfach auswählbar zu sein
        if (gameState[i]==2) {

        }
        if (activePlayer == 1 + gameState[i] = 2) {

            counter.setImageResource(R.drawable.red);
            activePlayer = 0;

        } else {

            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;

        }


        counter.animate().translationYBy(1500).setDuration(100);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
