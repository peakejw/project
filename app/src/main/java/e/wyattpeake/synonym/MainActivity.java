package e.wyattpeake.synonym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public  DataBaseHelper helper = new DataBaseHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.BfindSynonym){
            DataBaseHelper helper = new DataBaseHelper(this);

           EditText b = (EditText) findViewById(R.id.TFfind);

            String word1 = b.getText().toString();

           String answer = helper.search(word1);


            Intent i = new Intent(MainActivity.this, FindSynonym.class);
            i.putExtra("answer", answer);
            startActivity(i);



        }

        else if(v.getId() == R.id.BenterPair){


            EditText a = (EditText)findViewById(R.id.TFfind);
            String word1 = a.getText().toString();

            Intent i = new Intent(MainActivity.this, EnterValues.class);
            i.putExtra("word 1", word1);
            startActivity(i);
        }
    }
}
