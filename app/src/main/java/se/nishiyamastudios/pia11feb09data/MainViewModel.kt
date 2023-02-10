package se.nishiyamastudios.pia11feb09data


import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val theNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun loadstuff() {

        Handler(Looper.getMainLooper()).postDelayed({
            currentName.value = "Hej"
        }, 5000)

        theNumber.value = 10

        val timer = object: CountDownTimer(10000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                theNumber.value = theNumber.value!! - 1
            }

            override fun onFinish() {
                currentName.value = "It is done!"
            }
        }
        timer.start()
    }

}