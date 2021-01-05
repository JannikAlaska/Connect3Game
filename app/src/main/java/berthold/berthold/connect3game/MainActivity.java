package berthold.berthold.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int activePlayer = 1;

    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    boolean gameActive = true;

    public void dropIn (View view) {

        //ImageView "counter" erstellen und mit dem in der dropIn übergebenen View initialisieren
        ImageView counter = (ImageView) view;

        //der Tag beschreibt, an welcher Position wir uns befinden (0-8)
        Log.i("Feld:", view.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());


        //Prüfung, ob Feld schon belegt ist, um nicht mehrfach auswählbar zu sein
        if (gameState[tappedCounter]==2 && gameActive) {
            animation(counter, activePlayer);
            Log.i("gameStateBefore:", Arrays.toString(gameState));
            gameState[tappedCounter] = activePlayer;

            //wenn Player1 aktiv ist, setze rot, sonst gelb
            if (activePlayer == 1) {
                animation(counter, activePlayer);
                Log.i("gameStateAfter:", Arrays.toString(gameState));
                activePlayer = 0;

            } else {

                counter.setImageResource(R.drawable.yellow);
                Log.i("gameStateAfter:", Arrays.toString(gameState));
                activePlayer = 1;

            }

        } else {
            Toast.makeText(this, "Feld bereits belegt", Toast.LENGTH_SHORT).show();
        }



        //Für jede Option des winningPositions-Arrays wird folgendes geprüft:
        //Ist die 1. Stelle der Option identisch zur 2. Stelle und die 2. Stelle identisch zur 3. Stelle im gameState belegt?
        //Und ist die erste Stelle nicht mit 2, also leer belegt? Denn dann sind es die anderen beiden Stellen ebenfalls nicht, da sie identisch sein müssen.
        //Danach wird die zweite Option des winningPositions-Arrays geprüft.
        //for (int[] winningPosition: winningPositions) sagt "durchlaufe alle Arrays, die wir winningPosition nennen des Arrays winningPositions" (zweidimensionale Arrays mit for-Schleife)

        for (int[] winningPosition: winningPositions){
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2){
                String winner = "";

                if (activePlayer == 1) {
                    winner = "Gelb";
                } else if (activePlayer == 0){
                    winner = "Rot";
                }

                gameActive = false;

                Toast.makeText(this, "Der Gewinner ist " + winner , Toast.LENGTH_SHORT).show();

             }
        }
    }

    public void animation(ImageView counter, int activePlayer) {

        if (activePlayer == 1) {
            counter.setImageResource(R.drawable.red);
        } else if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow);
        }

        //"Herunterfallen" des Spielsteins animieren
        counter.setTranslationY(-1500);
        counter.animate().translationYBy(1500).setDuration(100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
