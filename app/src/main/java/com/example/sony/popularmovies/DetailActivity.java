package com.example.sony.popularmovies;

/**
 * Created by SONY on 7/4/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private Movie movieData;
    private TextView movieTextView;
    private ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movieTextView = (TextView) findViewById(R.id.tv_display_weather);
        poster=(ImageView)findViewById(R.id.detail_poster) ;

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra("movie")) {
                movieData = (Movie) intentThatStartedThisActivity.getSerializableExtra("movie");
                Picasso.with(getApplicationContext()).load(movieData.getUrl()).into(poster);
                movieTextView.setText(getString(com.example.sony.popularmovies.R.string.original_title)+ movieData.getOriginalTitle()+getString(com.example.sony.popularmovies.R.string.synopsis)+ movieData.getOverview()+getString(com.example.sony.popularmovies.R.string.rating)+ movieData.getRating()+getString(com.example.sony.popularmovies.R.string.release_date)+ movieData.getReleaseDate());
            }
        }
    }

}