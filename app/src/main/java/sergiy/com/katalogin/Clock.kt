package sergiy.com.katalogin

import java.text.SimpleDateFormat
import java.util.*


open class Clock {

    open fun getSecondsNow(): String {
        val c = Calendar.getInstance()
        val mdformat = SimpleDateFormat("ss")
        return mdformat.format(c.time)
    }
}