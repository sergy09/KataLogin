package sergiy.com.katalogin

import org.junit.Assert
import org.junit.Test


class LoginTest {

    @Test
    fun loginTest() {
        val kataApp = KataApp()
        with(kataApp) {
            Assert.assertEquals(login("admin", "admin").haveSimbols, false)
            Assert.assertEquals(login("admin;", "admi").haveSimbols, true)
            Assert.assertEquals(login("admin", "admin").userOk, true)
            Assert.assertEquals(login("admn", "admin").userOk, false)
        }
    }

    @Test
    fun logoutTest() {
        val kataApp = KataApp()
        with(kataApp) {
            Assert.assertEquals(logout(ClockMock("4")), true)
            Assert.assertEquals(logout(ClockMock("3")), false)
        }
    }

    class ClockMock(private val now: String) : Clock() {
        override fun getSecondsNow(): String {
            return now
        }
    }

}


