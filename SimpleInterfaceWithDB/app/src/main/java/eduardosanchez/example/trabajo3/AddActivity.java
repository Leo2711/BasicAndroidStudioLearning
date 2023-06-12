package eduardosanchez.example.trabajo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    String[] items_types = {"Movie","Serie"};
    String[] items_status = {"Rentable", "Disponible"};
    AutoCompleteTextView autoCompleteTextViewTypes;
    AutoCompleteTextView autoCompleteTextViewStatus;
    ArrayAdapter<String> adapterItemsTypes;
    ArrayAdapter<String> adapterItemsStatus;

    EditText title_input;

    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        autoCompleteTextViewTypes = findViewById(R.id.autoCompleteTypes);
        autoCompleteTextViewStatus = findViewById(R.id.autoCompleteStatus);
        title_input = findViewById(R.id.title_input);
        add_button = findViewById(R.id.add_button);

        adapterItemsTypes = new ArrayAdapter<>(this,R.layout.list_item,items_types);
        adapterItemsStatus = new ArrayAdapter<>(this, R.layout.list_item,items_status);

        autoCompleteTextViewTypes.setAdapter(adapterItemsTypes);
        autoCompleteTextViewStatus.setAdapter(adapterItemsStatus);

        autoCompleteTextViewTypes.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(AddActivity.this,"Item: "+ item,Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteTextViewStatus.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(AddActivity.this,"Item: "+ item,Toast.LENGTH_SHORT).show();
            }
        });

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addMovie(title_input.getText().toString().trim(),
                        autoCompleteTextViewTypes.getText().toString().trim(),
                        autoCompleteTextViewStatus.getText().toString().trim());
                Intent intent = new Intent(AddActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}