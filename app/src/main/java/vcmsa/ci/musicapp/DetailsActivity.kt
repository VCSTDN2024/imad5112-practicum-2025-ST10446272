package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class DetailsActivity : AppCompatActivity() {

    private lateinit var all: Button
    private lateinit var average: Button
    private lateinit var display: TextView
    private lateinit var back: Button
    private lateinit var exit: Button

    private lateinit var song: ArrayList<String>
    private lateinit var artist: ArrayList<String>
    private lateinit var rating: ArrayList<String>
    private lateinit var comments: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        all = findViewById(R.id.btnAll)
        average = findViewById(R.id.btnAverage)
        display = findViewById(R.id.tvDetails)
        back = findViewById(R.id.btnBack)
        exit = findViewById(R.id.btnExit)

        // get intent
        song = intent.getStringArrayListExtra("Song Title") ?: arrayListOf()
        artist = intent.getStringArrayListExtra("Artist Name") ?: arrayListOf()
        rating = intent.getStringArrayListExtra("Rating") ?: arrayListOf()
        comments = intent.getStringArrayListExtra("Comments") ?: arrayListOf()

        all.setOnClickListener { handleDisplayAll() }
        average.setOnClickListener { handleAverageRating() }

        back.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        exit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }

    private fun handleDisplayAll() {
        val stringBuilder = StringBuilder()
        if (song.isNotEmpty()) {
            for (i in song.indices) {
                stringBuilder.append("Entry ${i + 1}:\n")
                stringBuilder.append("Song: ${song[i]}\n")
                stringBuilder.append("Artist: ${artist[i]}\n")
                stringBuilder.append("Comments: ${comments[i]}\n")
                stringBuilder.append("Rating: ${rating[i]}\n\n")
            }
            display.text = stringBuilder.toString()
        } else {
            display.text = "No data available. Please go back and add some entries."
        }
    }

    private fun handleAverageRating() {
        if (rating.isEmpty()) {
            display.text = "No ratings to calculate average."
            return
        }

        val totalRating = rating.sumOf { it.toIntOrNull() ?: 0 }
        val avg = totalRating.toDouble() / rating.size
        display.text = "Average Rating: %.2f".format(avg)
    }
}
