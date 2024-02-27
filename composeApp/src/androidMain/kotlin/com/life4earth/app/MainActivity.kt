package com.life4earth.app

import MainView
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import utils.Constants.ACTION_DARK_MODE_ICON
import utils.Constants.ACTION_LIGHT_MODE_ICON

class MainActivity : AppCompatActivity() {

    private var _iconChangeReceiver: IconChangeReceiver? = null
    private val iconChangeReceiver get() = _iconChangeReceiver!!

    private var _isDarkMode: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _iconChangeReceiver = IconChangeReceiver()
        setContent {
            _isDarkMode = isSystemInDarkTheme()
            MainView(this)
        }
    }

    private fun changeAppIcon(isDarkMode: Boolean) {
        val action = if (isDarkMode) ACTION_DARK_MODE_ICON else ACTION_LIGHT_MODE_ICON
        val intent = Intent(action)
        iconChangeReceiver.onReceive(this, intent)
    }

    override fun onStop() {
        _isDarkMode?.let { changeAppIcon(it) }
        super.onStop()
    }

    override fun onDestroy() {
        _iconChangeReceiver = null
        super.onDestroy()
    }
}
