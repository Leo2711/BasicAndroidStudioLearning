package eduardosanchez.example.trabajo3;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    List<ListElement> elements;
    ImageView profileImage;
    ImageView logoImage;

    DrawerLayout layout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    MyDatabaseHelper myDB;
    ArrayList<String> movie_id, movie_title, movie_type, movie_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.main_menu);

         profileImage = (ImageView) findViewById(R.id.imageViewProfile);
         profileImage.setImageResource(R.drawable.avatar1);
         logoImage = (ImageView) findViewById(R.id.logo2);
         logoImage.setImageResource(R.drawable.l_logos_transparent);

         myDB = new MyDatabaseHelper(MenuActivity.this);
         movie_id = new ArrayList<>();
         movie_title = new ArrayList<>();
         movie_type = new ArrayList<>();
         movie_status = new ArrayList<>();
         storeDataInArrays();
         initListView();

         layout = (DrawerLayout) findViewById(R.id.drawer_layout);
         navigationView = (NavigationView) findViewById(R.id.nav_view);
         drawerToggle = new ActionBarDrawerToggle(this, layout,R.string.open,R.string.close);
         layout.addDrawerListener(drawerToggle);
         drawerToggle.syncState();
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()) {
                     case R.id.home:
                         Toast.makeText(MenuActivity.this, "Go to home page", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.account:
                         Toast.makeText(MenuActivity.this, "Go to account page", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.exit:
                         Toast.makeText(MenuActivity.this, "Exit account app", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.avatar1:
                         Toast.makeText(MenuActivity.this, "Changing to AvatarX", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.avatar2:
                         Toast.makeText(MenuActivity.this, "Changing to AvatarY", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.avatar3:
                         Toast.makeText(MenuActivity.this, "Changing to AvatarZ", Toast.LENGTH_SHORT).show();
                         break;
                     default:
                         throw new IllegalStateException("Unexpected value: " + item.getItemId());
                 }
                 return false;
             }
         });


    }
    public void initListView() {
        ListAdapter listAdapter = new ListAdapter(this,movie_id,movie_title,movie_type,movie_status);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item1){
            Intent intent = new Intent(MenuActivity.this, AddActivity.class);
            startActivity(intent);
        } else if (id == R.id.item2) {
            Intent intent = new Intent(MenuActivity.this, DeleteActivity.class);
            intent.putStringArrayListExtra("movie_title",movie_title);
            startActivity(intent);
        }
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        if(layout.isDrawerOpen(GravityCompat.START)) {
             layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                movie_id.add(cursor.getString(0));
                movie_title.add(cursor.getString(1));
                movie_type.add(cursor.getString(2));
                movie_status.add(cursor.getString(3));
            }
        }
    }
}
