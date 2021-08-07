package tech.hamid.android_internship_assessment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONObject;

public class DescImgActivity extends AppCompatActivity {
//Description_image Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_img);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Context context = getApplicationContext();

        Bundle bundle = getIntent().getExtras();

        ImageView main_img = findViewById(R.id.poster_image);
        TextView main_name = findViewById(R.id.desc);

        Glide.with(context).load(bundle.getString("main_img")).into(main_img);

        main_name.setText(bundle.getString("description", "No-Description"));

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}