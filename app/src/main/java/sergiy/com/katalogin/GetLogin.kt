package sergiy.com.katalogin

import android.os.Handler


object GetLogin {

    fun getLogin(callback: GetLoginCallback) {
        Handler().postDelayed({
            callback.onLoginOK(true)
        }, 3000)
    }

    interface GetLoginCallback {
        fun onLoginOK(response: Boolean)
    }
}