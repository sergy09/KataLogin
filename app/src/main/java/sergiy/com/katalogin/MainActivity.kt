package sergiy.com.katalogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginLogoutButton.setOnClickListener {
            if (login(username.text.toString(), password.text.toString())) {
                loginLogoutButton.text = "Logout"
            }
        }
    }

}
