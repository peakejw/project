package e.wyattpeake.synonym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by wyattpeake on 4/2/18.
 */

public class EnterValues extends Activity{

    Words w = new Words();
    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);


        String a = getIntent().getStringExtra("word 1");
        TextView tv = (TextView) findViewById(R.id.TVword1);
        tv.setText(a);
        w.setWord1(a);
    }


    public void onButtonClick(View v) {
        if (v.getId() == R.id.BenterSynonym) {

            EditText b = (EditText) findViewById(R.id.TFenterSynonym);

            String word2 = b.getText().toString();
            w.setWord2(word2);

           helper.insertContact(w);


            Intent i = new Intent(EnterValues.this, MainActivity.class);

            startActivity(i);




        }
    }
}

