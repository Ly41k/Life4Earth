package com.life4earth.app

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import utils.Constants.ACTION_DARK_MODE_ICON
import utils.Constants.ACTION_LIGHT_MODE_ICON

class IconChangeReceiver : BroadcastReceiver() {

    private val darkModeAlias: String = "com.life4earth.app.DarkModeMainActivityAlias"
    private val lightModeAlias: String = "com.life4earth.app.LightModeMainActivityAlias"

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            ACTION_DARK_MODE_ICON -> changeAppIcon(context, true)
            ACTION_LIGHT_MODE_ICON -> changeAppIcon(context, false)
        }
    }

    private fun changeAppIcon(context: Context?, isDarkMode: Boolean) {
        context?.let { it ->
            val aliasToEnable = if (isDarkMode) darkModeAlias else lightModeAlias
            val aliasToDisable = if (!isDarkMode) darkModeAlias else lightModeAlias
            val packageManager = it.packageManager
            enableComponent(it, packageManager, aliasToEnable)
            disableComponent(it, packageManager, aliasToDisable)
        }
    }

    private fun enableComponent(
        context: Context,
        packageManager: PackageManager,
        componentNameString: String
    ) {
        val componentName = ComponentName(context, componentNameString)
        packageManager.setComponentEnabledSetting(
            componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, 0
        )
    }

    private fun disableComponent(
        context: Context,
        packageManager: PackageManager,
        componentNameString: String
    ) {
        val componentName = ComponentName(context, componentNameString)
        packageManager.setComponentEnabledSetting(
            componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, 0
        )
    }
}
