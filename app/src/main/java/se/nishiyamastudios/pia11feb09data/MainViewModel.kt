package se.nishiyamastudios.pia11feb09data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }



}