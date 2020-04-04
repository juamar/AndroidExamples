package solutions.lhdev.carddemo.singletons;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import solutions.lhdev.carddemo.R;

public class AppData {
    private final String NEW_ALUMNO_CHANNEL_ID = "1";
    //¿Where else can we set this constant?
    private final int NEW_ALUMNO_NOTIFICATION_ID = 1;
    private final String NEW_ALUMNO_KEY_FOR_INTENT = "NEW_ALUMNO_KEY_FOR_INTENT";
    private static AppData ourInstance;

    public static AppData getInstance(Context context) {
        if (ourInstance == null)
            ourInstance = new AppData(context);
        return ourInstance;
    }

    private AppData(Context c) {
        createNotificationChannel(c);
    }

    //¿What's the main advantage of having this here?
    private void createNotificationChannel(Context context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = context.getString(R.string.channel_name);
            String description = context.getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(NEW_ALUMNO_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public String getAlumnoChannelId() {
        return NEW_ALUMNO_CHANNEL_ID;
    }

    public int getAlumnoNotificationId() {
        return NEW_ALUMNO_NOTIFICATION_ID;
    }

    public String getNewAlumnoKeyForIntent() {
        return NEW_ALUMNO_KEY_FOR_INTENT;
    }
}
