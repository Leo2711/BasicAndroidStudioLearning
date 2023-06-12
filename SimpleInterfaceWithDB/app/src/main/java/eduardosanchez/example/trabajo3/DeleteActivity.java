package eduardosanchez.example.trabajo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    private ArrayList<String> movie_title;
    AutoCompleteTextView actvTitles;
    ArrayAdapter<String> adapterItems;
    Button delete_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Intent intent = getIntent();
        movie_title = intent.getStringArrayListExtra("movie_title");

        actvTitles = findViewById(R.id.autoCompleteTitleDel);
        adapterItems = new ArrayAdapter<>(this,R.layout.list_item,movie_title);
        actvTitles.setAdapter(adapterItems);

        actvTitles.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(DeleteActivity.this,"Item: "+ item,Toast.LENGTH_SHORT).show();
            }
        });

        delete_button = findViewById(R.id.delete_button);

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(DeleteActivity.this);
                myDB.deleteMovie(actvTitles.getText().toString().trim());
                Intent intent = new Intent(DeleteActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}