package app.octocon.app.utils

import android.content.Context
import android.content.pm.ApplicationInfo

actual val currentPlatform = DevicePlatform.Android

actual interface PlatformUtilities : CommonPlatformUtilities {
  val context: Context
}

actual interface PlatformDelegate

actual object AppBuildConfig : BuildConfigInterface {
  var applicationContext: Context? = null

  override fun isDebug(): Boolean {
    if(applicationContext == null)
      return false

    return 0 != applicationContext!!.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
  }
}
