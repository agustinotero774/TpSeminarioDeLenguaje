package com.example.tp_01
/*
import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat

class ServicioMusica : Service(){

    private var mediaPlayer: MediaPlayer? = null
    private val CHANNEL_ID: String = "musica"

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificacion = crearNotificacion()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1){
                crearChannelId()
            startForeground(1,notificacion)
        }else{
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                NotificationManagerCompat.from(this).notify(1, Notification)
        }
        if (intent?.getBooleanExtra("stop",false) == true){
            stop()
        }else {
            if (mediaPlayer == null) {
                configurarMediaPlayer()
            }
            if (intent?.getBooleanExtra("pause", false) == true) {
                if (mediaPlayer?.isPlaying == true) {
                    mediaPlayer?.pause()
                } else {
                    mediaPlayer?.start()
                }
            } else {
                mediaPlayer?.start()
            }


        }
        return START_STICKY
    }
    @RequiresApi(Build.VERSION_CODES.ECLAIR_0_1)
    private fun crearChannelId() {
        val  importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(CHANNEL_ID,"servicio de musica",importance)
        channel.description = ""
        val notificationManager = getSystemService(NOTIFICATION_SERVICE)
        notificationManager.createNotificationChannel(channel)
    }

    private fun crearNotificacion(): Notification {
        TODO("Not yet implemented")
    }


    private fun configurarMediaPlayer(){
        mediaPlayer = MediaPlayer.create(this,R.raw.pokemon)
        mediaPlayer?.setOnCompletionListener { mediaPlayer
        stop()
        }
    }

    private fun stop(){
        stopMusic()
        stopSelf()
    }

    private fun stopMusic(){
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}*/