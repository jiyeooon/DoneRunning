/*package com.example.donerunning;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


@RequiresApi(api = Build.VERSION_CODES.M)
public class GPSService{

    final LocationManager lm = (LocationManager) getSystemService(GPSService.LOCATION_SERVICE);

    Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

    if (PermissionCheck.checkSelfPermission( this,android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED )
    {
        ActivityCompat.requestPermissions(
                this,
                new String [] { android.Manifest.permission.ACCESS_COARSE_LOCATION },
                LocationService.MY_PERMISSION_ACCESS_COURSE_LOCATION
        );
    }


    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            String provider = location.getProvider();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            double altitude = location.getAltitude();
        }
    };

    public void onStatusChanged(String provider, int status, Bundle extras) { }
    public void onProviderEnabled(String provider) { }
    public void onProviderDisabled(String provider) { }
};
*/
