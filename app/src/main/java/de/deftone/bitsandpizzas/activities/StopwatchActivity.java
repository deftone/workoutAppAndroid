package de.deftone.bitsandpizzas.activities;

import android.app.Activity;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import de.deftone.bitsandpizzas.R;

public class StopwatchActivity extends Activity {

    private int seconds;
    private int seconds_at_start;
    private boolean running;
    private boolean wasRunning;
    private Ringtone ringtone;

    public static final String INTENT_SECONDS = "seconds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        seconds_at_start = getIntent().getExtras().getInt(INTENT_SECONDS);
        seconds = seconds_at_start;
        runTimer();
    }

    //damit beim drehen die instanzvariabeln gespeichert werden und nicht alles zurueck gesetzt wird
    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putInt("seconds", seconds);
        saveInstanceState.putBoolean("running", running);
        saveInstanceState.putBoolean("wasRunning", wasRunning);
    }

    public void onClickStart(View view) {
        running = true;
    }

    public void onClickStop(View view) {
        running = false;
        if (ringtone != null)
            ringtone.stop();
    }

    public void onClickReset(View view) {
        running = false;
        seconds = seconds_at_start;
    }

    private void runTimer() {
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds--;
                    if (seconds == 0) {
                        //custom toast
                        Context context = getApplicationContext();
                        // Create layout inflator object to inflate toast.xml file
                        LayoutInflater inflater = getLayoutInflater();

                        // Call toast.xml file for toast layout
                        View toastview = inflater.inflate(R.layout.toast, null);

                        Toast toast = new Toast(context);

                        // Set layout to toast
                        toast.setView(toastview);
                        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL,
                                0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.show();

                        try {
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                            ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
                            ringtone.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        running = false;
                        seconds = seconds_at_start;
                    }
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
