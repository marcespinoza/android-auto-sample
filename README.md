# Android Auto Sample App 🚗
This is small sample project to show how you can add android auto support to your project.
In this particular case is a media app, but of course you can create other such a message or navigation app.
  
  I recommend this great tutorial to understand deeper https://proandroiddev.com/android-auto-tutorial-step-by-step-guide-50bb6b73e2b8

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

# Voice actions support 🗣️

To support voice actions you need to implement ***onPlayFromSearch*** method in your media session callback.

        override fun onPlayFromSearch(query: String?, extras: Bundle?) {
            super.onPlayFromSearch(query, extras)
        }

# Desktop head unit
To test your app you need to install the desktop head unit, install it following this instructions https://developer.android.com/training/cars/testing/dhu
<img width="820" height="529" alt="imagecarauto" src="https://github.com/user-attachments/assets/06cc685d-4a0f-4548-a8a0-82b0c6572dcb" />

# Sample App 📱
This is how it looks the sample app, notice that you dont have to create any view, android does it for you, all you have to do is pass it the necessary data to media session and thats it.

<img width="802" height="512" alt="Screenshot from 2025-10-25 10-54-49" src="https://github.com/user-attachments/assets/b2779dfd-8325-4a80-b542-1c0f01224cba" />
<img width="802" height="512" alt="Screenshot from 2025-10-25 10-54-40" src="https://github.com/user-attachments/assets/a70b8655-1aad-4453-a738-656fa8e7e088" />


            
