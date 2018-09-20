package sergiy.com.katalogin


fun login(user: String, pass: String): Boolean = user == "admin" && pass == "admin"