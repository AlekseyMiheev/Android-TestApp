package ua.com.testapp.utils;

import android.content.Context;
import android.util.Log;

/**
 * Created by Aleksey on 27.06.2017.
 */

public class FTPManager {

    private String ip;
    private String login;
    private String password;

    public FTPManager(Context context) {
        ConfigHelper.loadConfig(context);
        ip = ConfigHelper.getIp();
        login = ConfigHelper.getLogin();
        password = ConfigHelper.getPassword();
    }

    public void loadFile() {
        Log.i("FTP", ip);
        Log.i("FTP", login);
        Log.i("FTP", password);

       /* FTPClient connection;

        try
        {
            connection = new FTPClient();
            connection.connect(ip);

            if (connection.login(login, password))
            {
                connection.enterLocalPassiveMode();
                connection.setFileType(FTP.ASCII_FILE_TYPE);
                File file = FileHelper.getRouteFile();
                FileInputStream in = new FileInputStream(file);
                boolean result = connection.storeFile(FileHelper.FILE_NAME, in);
                in.close();
                if (result) Log.v("upload result", "succeeded");
                connection.logout();
                connection.disconnect();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }
}
