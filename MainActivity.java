import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView timeTextView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView = findViewById(R.id.timeTextView);

        // Create a runnable to update the time every second
        Runnable updateTimeRunnable = new Runnable() {
            @Override
            public void run() {
                updateTime();
                // Run this code every second (1000 milliseconds)
                handler.postDelayed(this, 1000);
            }
        };

        // Start the time update runnable
        handler.post(updateTimeRunnable);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
        String currentTime = sdf.format(new Date());
        timeTextView.setText(currentTime);
    }
}
