package tech.hamid.android_internship_assessment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProNameActivity extends AppCompatActivity {
//ProfileImage_Name Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_name);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Context context = getApplicationContext();

        Bundle bundle = getIntent().getExtras();

        ImageView pro_img = findViewById(R.id.profile_img);
        TextView pro_name = findViewById(R.id.profile_name);
        TextView pro_loc = findViewById(R.id.profile_location);
        TextView pro_bio = findViewById(R.id.profile_bio);


        Glide.with(context).load(bundle.getString("profile_img")).into(pro_img);

        pro_name.setText(bundle.getString("name", "No-Name"));
        pro_loc.setText(bundle.getString("location", "No-Location"));
        pro_bio.setText(bundle.getString("bio", "No-bio"));
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