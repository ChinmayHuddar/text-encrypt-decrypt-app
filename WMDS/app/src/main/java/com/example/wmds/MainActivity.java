package com.example.wmds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    EditText key, txt;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = findViewById(R.id.btn1);
        Button bt2 = findViewById(R.id.btn2);

        key = findViewById(R.id.key_et);
        txt = findViewById(R.id.txt_et);

        msg = findViewById(R.id.msg_tv);
    }

    public void Encrypt(View view) {

        try {
            String encrypt = AESCrypt.encrypt(key.getText().toString(),txt.getText().toString());
            key.setText("");
            txt.setText("");
            msg.setText(encrypt);
            ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("label", encrypt);
            clipboardManager.setPrimaryClip(clipData);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

    }

    public void Decrypt(View view) {

        try {
            String encrypt = AESCrypt.decrypt(key.getText().toString(),txt.getText().toString());
            key.setText("");
            txt.setText("");
            msg.setText(encrypt);
            ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("label", encrypt);
            clipboardManager.setPrimaryClip(clipData);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

    }
}