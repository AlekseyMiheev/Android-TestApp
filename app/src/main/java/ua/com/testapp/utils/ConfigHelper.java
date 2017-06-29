package ua.com.testapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ua.com.testapp.R;

/**
 * Created by Aleksey on 27.06.2017.
 */

public abstract class ConfigHelper {

    private static String ip;
    private static String login;
    private static String password;

    public static void loadConfig(Context context) {
        ip = getPropertyByName(context, "ip");
        login = getPropertyByName(context, "login");
        password = getPropertyByName(context, "password");
    }

    public static String getPropertyByName(Context context, String name) {

        Resources resources = context.getResources();

        try {
            //File configFile = new File(FileHelper.getRoot(), FileHelper.CONFIG);
            //InputStream rawResource = new FileInputStream(configFile);
            InputStream rawResource = resources.openRawResource(R.raw.config);
            Properties properties = new Properties();
            properties.load(rawResource);
            return properties.getProperty(name);
        } catch (Resources.NotFoundException e) {
            Log.e("ConfigHelper", "Unable to find the config file: " + e.getMessage());
        } catch (IOException e) {
            Log.e("ConfigHelper", "Failed to open config file.");
        }

        return null;
    }

    public static String getIp() {
        return ip;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }


}
