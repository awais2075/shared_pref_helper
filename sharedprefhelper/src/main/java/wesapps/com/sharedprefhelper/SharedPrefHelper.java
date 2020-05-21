package wesapps.com.sharedprefhelper;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPrefHelper {

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedPrefHelper(Context context, String name, int mode) {
        sharedPreferences = context.getSharedPreferences(name, mode);
        gson = new Gson();
    }

    public void saveData(String key, Object object) {
        String value = gson.toJson(object);
        sharedPreferences.edit().putString(key, value).apply();
    }

    public Object getData(String key,Class className) {
        String value = sharedPreferences.getString(key, null);
        return gson.fromJson(value, className);
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}

