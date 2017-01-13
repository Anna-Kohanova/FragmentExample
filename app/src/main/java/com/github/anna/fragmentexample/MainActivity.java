package com.github.anna.fragmentexample;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.anna.fragmentexample.fragments.WorkoutDetailFragment;
import com.github.anna.fragmentexample.fragments.WorkoutListFragment;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(final long id) {
        final WorkoutDetailFragment workoutDetailFragment = new WorkoutDetailFragment();
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        workoutDetailFragment.setWorkout(id);
        fragmentTransaction.replace(R.id.fragment_container, workoutDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}
