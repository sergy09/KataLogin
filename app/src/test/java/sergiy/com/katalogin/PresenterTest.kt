package sergiy.com.katalogin


import org.junit.Assert
import org.junit.Test
import java.util.concurrent.CountDownLatch


class PresenterTest {

    val mockView = MockView()
    var presenter = Presenter(mockView, MockKataApp())

    val latch = CountDownLatch(1)

    @Test(timeout = 4000)
    fun presenter_logout_Ok() {
        presenter.onLoginTap("Login", "admin", "admin").finally {
            Assert.assertTrue(mockView.didShowLogout)
        }
    }

    @Test
    fun presenter_login_credentials_error() {
        presenter.onLoginTap("Login", "admin,", "admin")
        Assert.assertTrue(mockView.didShowCredentialsError)
    }

    @Test
    fun presenter_login_ok() {
        presenter = Presenter(mockView, MockKataApp(true))
        presenter.onLoginTap("Logout", "admin", "admin")
        Assert.assertTrue(mockView.didShowLogin)
    }

    @Test
    fun presenter_login_error() {
        presenter = Presenter(mockView, MockKataApp(false))
        presenter.onLoginTap("Logout", "admin", "admin")
        Assert.assertFalse(mockView.didShowLogin)
    }

    class MockKataApp(var ourClock: Boolean = true) : KataApp() {
        override fun logout(clock: Clock): Boolean {
            return ourClock
        }
    }

    class MockView : Presenter.View {
        var didShowLogout = false
        var didShowLogin = false
        var didShowCredentialsError = false

        override fun showLogout() {
            val presenter = PresenterTest()
            presenter.latch.countDown()
            didShowLogout = true
        }

        override fun showLogin() {
            didShowLogin = true
        }

        override fun showErrorCredentials() {
            didShowCredentialsError = true
        }

    }

}


