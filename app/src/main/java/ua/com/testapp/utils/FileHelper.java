package ua.com.testapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import ua.com.testapp.model.Route;

/**
 * Created by Aleksey on 27.06.2017.
 */

public class FileHelper {

    public static final String FILE_NAME = "number.txt";
    public static final String DIRECTORY = "ITInnovations test app";
    public static final String CONFIG = "config.txt";

    private static File routeFile;
    private static File root;

    /*public static void generateConfig() {
        try {
            root = new File(Environment.getExternalStorageDirectory(), DIRECTORY);
            if (!root.exists()) {
                root.mkdirs();
            }
            routeFile = new File(root, CONFIG);
            PrintStream writer = new PrintStream (routeFile);
            writer.println("ip=000.000.000.001");
            writer.println("login=admin");
            writer.println("password=pass");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void generateFile(Route route) {
        try {
            root = new File(Environment.getExternalStorageDirectory(), DIRECTORY);
            if (!root.exists()) {
                root.mkdirs();
            }
            routeFile = new File(root, FILE_NAME);
            FileWriter writer = new FileWriter(routeFile);
            writer.write(route.toString());
            writer.flush();
            writer.close();
            Log.i("FileHelper", "Generate file: " + FILE_NAME + " with text: " + route.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getRouteFile() {
        return routeFile;
    }

    public static File getRoot() {
        return root;
    }
}
