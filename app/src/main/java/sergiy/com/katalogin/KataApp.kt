package sergiy.com.katalogin


open class KataApp() {

    class LoginResult(var haveSimbols: Boolean, var userOk: Boolean)

    open fun login(user: String, pass: String): LoginResult {
        return when {
            user.contains(".") || user.contains(",") || user.contains(";") -> LoginResult(true, false)
            user == "admin" && pass == "admin" -> LoginResult(false, true)
            else -> LoginResult(false, false)
        }
    }

    open fun logout(clock: Clock): Boolean = clock.getSecondsNow().toInt() % 2 == 0

}
