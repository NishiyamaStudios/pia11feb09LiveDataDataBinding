package se.nishiyamastudios.pia11feb09data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    val model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //newName är ett egen namn i stället för It.
        val nameObserver  = Observer<String> { newName ->
            //Vad skall hända när det kommer ett nyt värde

            findViewById<TextView>(R.id.mainTextView).text = newName
        }

        val numberObserver  = Observer<Int> { newNumber ->
            //Vad skall hända när det kommer ett nyt värde

            findViewById<TextView>(R.id.numberTV).text = newNumber.toString()
        }

        model.currentName.observe(this, nameObserver) //Vad skall vi observera, samt ägare och vem som observerar
        model.theNumber.observe(this, numberObserver)

        model.loadstuff()

        findViewById<Button>(R.id.mainButton).setOnClickListener {
            model.currentName.value = "Bartil"
        }

    }
}