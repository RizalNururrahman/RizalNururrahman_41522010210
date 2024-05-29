package com.example.tugas2coba1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class scan_tutupbotol extends AppCompatActivity {

    private static final String PREFS_NAME = "ScanKTPPrefs";
    private static final String KEY_FIRST_SCAN_RESULT = "FirstScanResult";

    Button btn_scan;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.scan_tutupbotol);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        btn_scan = findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(v -> scanCode());
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to flash on");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        Launcher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> Launcher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            String previousScanResult = sharedPreferences.getString(KEY_FIRST_SCAN_RESULT, null);

            if (previousScanResult != null && previousScanResult.equals(result.getContents())) {
                showInfoDialog("Tutup botol Anda\nsudah ada yang klaim");
                navigateToScanTutupBotolMerah();
            } else {
                sharedPreferences.edit().putString(KEY_FIRST_SCAN_RESULT, result.getContents()).apply();
                navigateToScanTutupBotolHijau();
            }
        }
    });

    private void showResultDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(scan_tutupbotol.this);
        builder.setTitle("Result");
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void showInfoDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(scan_tutupbotol.this);
        builder.setTitle("Info");
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void navigateToScanTutupBotolMerah() {
        Intent intent = new Intent(scan_tutupbotol.this, scan_tutupbotol_merah.class);
        startActivity(intent);
    }

    private void navigateToScanTutupBotolHijau() {
        Intent intent = new Intent(scan_tutupbotol.this, scan_tutupbotol_hijau.class);
        startActivity(intent);
    }

    public void panahkembalikelayer5(View view) {
        Intent panahkembalikelayer5 = new Intent(scan_tutupbotol.this, layer5.class);
        startActivity(panahkembalikelayer5);
    }

    public void submit(View view) {
        // Handle submit button click
    }

    public void cancel(View view) {
        // Handle cancel button click
    }
}
