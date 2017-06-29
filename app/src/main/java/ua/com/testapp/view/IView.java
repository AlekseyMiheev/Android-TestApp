package ua.com.testapp.view;

import android.content.Context;

import java.util.List;

import ua.com.testapp.model.Route;

/**
 * Created by Aleksey on 27.06.2017.
 */

public interface IView {

    void setupSpinnerAdapter(List<Route> routes);
    Context getContext();
    void showToast(String text);
}
