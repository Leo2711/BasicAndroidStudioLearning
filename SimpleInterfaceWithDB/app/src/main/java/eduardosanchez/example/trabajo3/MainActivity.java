package eduardosanchez.example.trabajo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageButton profile1;
    ImageButton profile2;
    ImageButton profile3;
    ImageButton profile4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView chooseP = (TextView) findViewById(R.id.textChoose);
        TextView title = (TextView) findViewById(R.id.textTitleMM);
        ImageView logo = (ImageView) findViewById(R.id.logo);
        profile1 = (ImageButton) findViewById(R.id.imageButton1);
        profile2 = (ImageButton) findViewById(R.id.imageButton2);
        profile3 = (ImageButton) findViewById(R.id.imageButton3);
        profile4 = (ImageButton) findViewById(R.id.imageButton4);
        profile1.setImageResource(R.drawable.avatar1);
        profile2.setImageResource(R.drawable.avatar2);
        profile3.setImageResource(R.drawable.avatar3);
        profile4.setImageResource(R.drawable.avatar4);
        logo.setImageResource(R.drawable.l_logos_transparent);
    }

    public void goToMenu(View view) {
        Intent menuActivity = new Intent(this, MenuActivity.class);
        startActivity(menuActivity);
    }

}