package ua.com.testapp.presenter;

import ua.com.testapp.model.Route;

/**
 * Created by Aleksey on 27.06.2017.
 */

public interface IMainViewPresenter {

    void loadFTP();
    void generateFile(Route route);
    void generateData();

}
