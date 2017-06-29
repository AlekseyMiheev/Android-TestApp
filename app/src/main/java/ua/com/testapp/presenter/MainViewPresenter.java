package ua.com.testapp.presenter;

import java.util.ArrayList;
import java.util.List;

import ua.com.testapp.model.Route;
import ua.com.testapp.utils.FTPManager;
import ua.com.testapp.utils.FileHelper;
import ua.com.testapp.view.IView;

/**
 * Created by Aleksey on 27.06.2017.
 */

public class MainViewPresenter implements IMainViewPresenter {

    private IView view;
    private List<Route> routes;
    private FTPManager ftpManager;

    public MainViewPresenter(IView view) {
        this.view = view;
        routes = new ArrayList<>(10);
        ftpManager = new FTPManager(view.getContext());
    }

    @Override
    public void loadFTP() {
        ftpManager.loadFile();
        view.showToast("File loaded");
    }

    @Override
    public void generateFile(Route route) {
        FileHelper.generateFile(route);
    }

    @Override
    public void generateData() {
        routes = new ArrayList<>(10);
        routes.add(new Route(313, "BusStation", "ExpositionCenter"));
        routes.add(new Route(101, "A", "B"));
        routes.add(new Route(102, "C", "D"));
        routes.add(new Route(103, "E", "F"));
        routes.add(new Route(104, "G", "H"));
        routes.add(new Route(105, "I", "J"));
        routes.add(new Route(106, "K", "L"));
        routes.add(new Route(107, "M", "N"));
        routes.add(new Route(108, "O", "P"));
        routes.add(new Route(109, "Q", "R"));
        view.setupSpinnerAdapter(routes);
    }
}
