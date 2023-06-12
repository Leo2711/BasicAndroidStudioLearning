package eduardosanchez.example.simpleinterfaz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {
    private Button button2;
    private TextInputEditText tied1;
    private TextInputEditText tied2;
    private TextView tvn1;
    private TextView tvn2;
    private CheckBox checkBox;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_create);
        button2 = (Button) findViewById(R.id.button2);
        tied1 = (TextInputEditText) findViewById(R.id.tied1);
        tied2 = (TextInputEditText) findViewById(R.id.tied2);
        tvn1 = (TextView) findViewById(R.id.tvn1);
        tvn2 = (TextView) findViewById(R.id.tvn2);
        checkBox = (CheckBox) findViewById(R.id.cb1);
    }
}
