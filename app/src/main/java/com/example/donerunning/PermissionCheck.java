/*package com.example.donerunning;

import android.Manifest;
import android.content.pm.PackageManager;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;

public abstract class PermissionCheck implements ActivityResultCaller {


    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {

                } else {

                }
            });

    if (ContextCompat.checkSelfPermission(
    CONTEXT, Manifest.permission.REQUESTED_PERMISSION) ==
    PackageManager.PERMISSION_GRANTED) {

        performAction(...);
    } else if (shouldShowRequestPermissionRationale(...)) {


        showInContextUI(...);
    } else {

        requestPermissionLauncher.launch(
                Manifest.permission.REQUESTED_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:

                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }  else {

                }
                return;
        }

    }
}
}*/