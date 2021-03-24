package uk.lgl.modmenu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class StaticActivity {

    private static final String TAG = "Mod Menu";
    public static String cacheDir;

    public static void Start(final Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(context)) {
            context.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION",
                    Uri.parse("package:" + context.getPackageName())));
            Process.killProcess(Process.myPid());
        } else {

            // Delay starting service to prevent function pointer issue
            // Arcording to Guided Hacking:
            // https://guidedhacking.com/threads/android-function-pointers-hooking-template-tutorial.14771/#post-90490
            // The il2cpp lib sometimes don't loaded first which caused crash when declaring the function pointer.
            // Instead splitting the function pointer, delay the service. The Il2Cpp will load first
            // before the service start
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    context.startService(new Intent(context, FloatingModMenuService.class));
                }
            }, 1000);
        }

        cacheDir = context.getCacheDir().getPath() + "/";

        writeToFile("OpenMenu.ogg", Sounds.OpenMenu());
        writeToFile("Back.ogg", Sounds.Back());
        writeToFile("Select.ogg", Sounds.Select());
        writeToFile("SliderIncrease.ogg", Sounds.SliderIncrease());
        writeToFile("SliderDecrease.ogg", Sounds.SliderDecrease());
        writeToFile("On.ogg", Sounds.On());
        writeToFile("Off.ogg", Sounds.Off());

       /* AssetManager assets = context.getAssets();
        String str2 = cacheDir + "/Slider-Switch.ogg";
        try {
            copyFile(assets.open("Slider-Switch.ogg"), new FileOutputStream(str2));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private static void writeToFile(String name, String base64) {
        File file = new File(cacheDir + name);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            byte[] decode = Base64.decode(base64, 0);
            fos.write(decode);
            fos.close();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    /*private static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }*/
}
