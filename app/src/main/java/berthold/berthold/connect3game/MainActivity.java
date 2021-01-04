package berthold.berthold.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    boolean redsTurn = true;

    public void dropIn (View view) {


        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1500);


        if (redsTurn) {

            counter.setImageResource(R.drawable.red);
            redsTurn = false;

        } else {

            counter.setImageResource(R.drawable.yellow);
            redsTurn = true;

        }


        counter.animate().translationYBy(1500).setDuration(100);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
