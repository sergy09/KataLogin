package sergiy.com.katalogin

import android.os.Handler
import android.util.Log
import co.metalab.asyncawait.async


class Presenter(val view: View, val kataApp: KataApp) {

    val clock = Clock()

    fun onLoginTap(loginLogoutButton: String, username: String, password: String) = async {
        when {
            loginLogoutButton == "Logout" -> {
                Log.d("Current Seccond", clock.getSecondsNow())
                if (kataApp.logout(Clock())) {
                    view.showLogin()
                }
            }
            kataApp.login(username, password).haveSimbols -> {
                view.showErrorCredentials()
            }
            kataApp.login(username, password).userOk -> {
                Handler().postDelayed({
                    view.showLogout()
                }, 3000)
            }
        }
    }

    interface View {
        fun showLogout()
        fun showLogin()
        fun showErrorCredentials()
    }

}