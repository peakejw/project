package e.wyattpeake.synonym;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by wyattpeake on 4/2/18.
 */

public class FindSynonym extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_synonym);

       String answer = getIntent().getStringExtra("answer");
        TextView tv = (TextView)findViewById(R.id.TVAnswer);
        tv.setText(answer);
    }
}
