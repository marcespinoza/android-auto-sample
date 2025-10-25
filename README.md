# Android Auto Sample App car 🚗
This is small sample project to show how you can add android auto support to your project.
In this particular case is a media app, but of course you can create other such a message or navigation app.
  
  I recommended this great tutorial to understand deeper https://proandroiddev.com/android-auto-tutorial-step-by-step-guide-50bb6b73e2b8

## Basic keys 🔑
Add to your manifest

        <meta-data
            android:name="com.google.android.gms.car.application"
            android:resource="@xml/automotive_app_desc" />

        <service android:name=".service.MediaService"
            android:exported="true">
            <intent-filter>
                <action android:name="android.media.browse.MediaBrowserService" />
            </intent-filter>
        </service>

automotive_app_desc.xml

        <?xml version="1.0" encoding="utf-8"?>
        <automotiveApp>
            <uses name="media" />
        </automotiveApp>

# Desktop head unit
If you don't have a car you can test your app with the desktop head unit, install it following this instructions https://developer.android.com/training/cars/testing/dhu
                

            
