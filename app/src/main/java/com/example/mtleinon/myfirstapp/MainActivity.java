package com.example.mtleinon.myfirstapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    static final String OWN_VARIABLE = "OWN_VARIABLE";
    private int ownVariable;

    private void DEBUG () {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String className = Thread.currentThread().getStackTrace()[3].getFileName();
        className = className.substring(0, className.indexOf("."));
        Log.d("MIKA", className + "." + methodName + " : called");
    }

    private void DEBUG (String msg) {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String className = Thread.currentThread().getStackTrace()[3].getFileName();
        className = className.substring(0, className.indexOf("."));
        Log.d("MIKA", className + "." + methodName + " : " + msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MIKA", "Build.VERSION.SDK_INT="
                + Build.VERSION.SDK_INT
                + ", Build.VERSION.RELEASE=" + Build.VERSION.RELEASE);
        ownVariable = 1;
        DEBUG("ownVariable=" + ownVariable);
    }

    @Override
    protected void onStart() {
        super.onStart();
        DEBUG ();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ownVariable++;
        DEBUG("ownVariable=" + ownVariable);
    }

    @Override
    protected void onPause() {
        super.onPause();
        DEBUG();
    }

    @Override
    protected void onStop() {
        super.onStop();
        DEBUG();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DEBUG();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        DEBUG("ownVariable=" + ownVariable);
        outState.putInt(OWN_VARIABLE, ownVariable);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ownVariable = savedInstanceState.getInt(OWN_VARIABLE);
        DEBUG("ownVariable=" + ownVariable);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
