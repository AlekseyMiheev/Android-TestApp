package ua.com.testapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import ua.com.testapp.model.Route;
import ua.com.testapp.presenter.MainViewPresenter;
import ua.com.testapp.presenter.IMainViewPresenter;
import ua.com.testapp.utils.FileHelper;
import ua.com.testapp.view.IView;

public class MainActivity extends AppCompatActivity implements IView {

    private Spinner routeSpinner;
    private IMainViewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        routeSpinner = (Spinner) findViewById(R.id.routeSpinner);
        presenter = new MainViewPresenter(this);
        presenter.generateData();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.loadFTP();
            }
        });

        routeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Route route = (Route) parent.getAdapter().getItem(position);
                presenter.generateFile(route);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupSpinnerAdapter(List<Route> routes) {
        routeSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, routes));
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
