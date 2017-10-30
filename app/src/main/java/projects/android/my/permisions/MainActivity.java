package projects.android.my.permisions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Permission for camera
        String cameraPermission = Manifest.permission.CAMERA;

        //Check if permission is granted
        if(ContextCompat.checkSelfPermission(this,cameraPermission)!= PackageManager.PERMISSION_GRANTED)
        {
            //if permission is not granted ask for permission..
            //RequestCode is used for Callback funtion to check on which permission action was taken
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA},100);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100)
        {
            //If Permission was granted show msg
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"Permission Granted",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_LONG).show();
            }

        }
    }
}
