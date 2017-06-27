package com.happyhamster.soft.gotodream.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.happyhamster.soft.gotodream.GoToDream;
import com.happyhamster.soft.gotodream.R;
import com.happyhamster.soft.gotodream.domain.entity.Dream;
import com.happyhamster.soft.gotodream.domain.entity.Plan;
import com.happyhamster.soft.gotodream.domain.interactor.DreamInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;

public class StartActivity extends AppCompatActivity {

    @Inject
    DreamInteractor dreamInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
        GoToDream.getInteractorComponent().inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Dream dream = new Dream();
        dream.setName("Тест");
        Plan plan = new Plan();
        plan.setComplete(true);
        dream.setPlan(plan);
        dreamInteractor.persist(dream);
        Observable<Dream> all = dreamInteractor.getAll();
        System.out.println("The End");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
