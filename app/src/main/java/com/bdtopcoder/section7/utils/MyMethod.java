package com.bdtopcoder.section7.utils;

import android.app.Activity;

import androidx.appcompat.app.AlertDialog;

public class MyMethod {
    public static void dialog (Activity activity, String message){
        new AlertDialog.Builder(activity)
                .setTitle("My Spp")
                .setMessage(message)
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
