package com.androidauto.sample.service

import android.net.Uri
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.session.MediaSessionCompat
import androidx.media.MediaBrowserServiceCompat

private const val MEDIA_BROWSER_ROOT_ID = "MEDIA_ROOT_ID"


class MediaService : MediaBrowserServiceCompat() {

    private lateinit var mediaSession: MediaSessionCompat

    override fun onCreate() {
        super.onCreate()

        mediaSession = MediaSessionCompat(this, "AndroidAutoSample").apply {
            setCallback(object : MediaSessionCompat.Callback() {

                //Implement here your logic to manage when a item has been selecte (e.g. Play some music )
                override fun onPlayFromMediaId(mediaId: String?, extras: Bundle?) {
                    super.onPlayFromMediaId(mediaId, extras)
                }

                //Implement here your logic to manage voice control actions.
                override fun onPlayFromSearch(query: String?, extras: Bundle?) {
                    super.onPlayFromSearch(query, extras)
                }
                override fun onPlay() {
                    // Start playback (e.g. via ExoPlayer)
                }

                override fun onPause() {
                    // Pause playback
                }
            })
            isActive = true
        }

        sessionToken = mediaSession.sessionToken
    }

    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot {
        return BrowserRoot(MEDIA_BROWSER_ROOT_ID, null)
    }

    override fun onLoadChildren(
        parentId: String,
        result: Result<MutableList<MediaBrowserCompat.MediaItem>>
    ) {
        val mediaItems = mutableListOf<MediaBrowserCompat.MediaItem>()

        // Example 1: A music track
        val song1Description = MediaDescriptionCompat.Builder()
            .setMediaId("song_1")
            .setTitle("Sample Song 1")
            .setSubtitle("Artist A")
            .setDescription("A nice demo track")
            .setIconUri(Uri.parse("https://example.com/cover1.jpg"))
            .build()

        mediaItems.add(
            MediaBrowserCompat.MediaItem(
                song1Description,
                MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
            )
        )

        // Example 2: Another music track
        val song2Description = MediaDescriptionCompat.Builder()
            .setMediaId("song_2")
            .setTitle("Sample Song 2")
            .setSubtitle("Artist B")
            .setDescription("Another cool demo track")
            .setIconUri(Uri.parse("https://example.com/cover2.jpg"))
            .build()

        mediaItems.add(
            MediaBrowserCompat.MediaItem(
                song2Description,
                MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
            )
        )

        // Example 3: A "folder" (browsable item)
        val playlistDescription = MediaDescriptionCompat.Builder()
            .setMediaId("playlist_1")
            .setTitle("My Playlist")
            .setDescription("A list of great songs")
            .build()

        mediaItems.add(
            MediaBrowserCompat.MediaItem(
                playlistDescription,
                MediaBrowserCompat.MediaItem.FLAG_BROWSABLE
            )
        )

        // Send the result back
        result.sendResult(mediaItems)
    }


}
