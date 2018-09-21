package sergiy.com.katalogin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), Presenter.View {

    val presenter = Presenter(this, KataApp())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginLogoutButton.setOnClickListener {
            val button = it as Button
            presenter.onLoginTap(button.text.toString(), username.text.toString(), password.text.toString())
        }
    }

    override fun showLogout() {
        loginLogoutButton.text = "Logout"
        username.visibility = View.INVISIBLE
        password.visibility = View.INVISIBLE
    }

    override fun showLogin() {
        loginLogoutButton.text = "Login"
        username.visibility = View.VISIBLE
        password.visibility = View.VISIBLE
    }

    override fun showErrorCredentials() {
        Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
    }

}
