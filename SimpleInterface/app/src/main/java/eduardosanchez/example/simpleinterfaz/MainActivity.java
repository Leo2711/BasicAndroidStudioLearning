package eduardosanchez.example.simpleinterfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private ListView lv1;
    private Button button1;

    private String nombres [] = {"Tareas","Poemas","Cancion1","ListaCompras","Calificaciones","NotasDeTrabajo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_menu);
        tv1 = (TextView) findViewById(R.id.tv1);
        lv1 = (ListView) findViewById(R.id.lv1);
        button1 = (Button) findViewById(R.id.button1);
        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.list_item_notes,nombres);
        lv1.setAdapter(adapter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}