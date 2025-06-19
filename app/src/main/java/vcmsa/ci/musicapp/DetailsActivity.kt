package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class DetailsActivity : AppCompatActivity() {

    private lateinit var all: Button
    private lateinit var average: Button
    private lateinit var display: TextView
    private lateinit var back: Button
    private lateinit var exit: Button

    private lateinit var song: ArrayList<String>
    private lateinit var artist : ArrayList<String>
    private lateinit var rating : ArrayList<String>
    private lateinit var comments : ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        all = findViewById(R.id.btnAll)
        all.setOnClickListener {
            handleDisplayAll()
        }
        average = findViewById(R.id.btnAverage)
        average.setOnClickListener {
            handleAverageRating()
        }
        display = findViewById(R.id.tvDetails)


        // Receive intent data
        song = intent.getStringArrayListExtra("song")?: arrayListOf()
        artist = intent.getStringArrayListExtra("artist")?: arrayListOf()
        comments = intent.getStringArrayListExtra("comments")?: arrayListOf()
        rating = intent.getStringArrayListExtra("rating")?: arrayListOf()


        back = findViewById(R.id.btnBack)
        back.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }
        exit = findViewById(R.id.btnExit)
        exit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

    }
    private fun handleDisplayAll() {
        // Display entries
        val stringBuilder = StringBuilder()
        if (song.isNotEmpty()) {
            val builder = StringBuilder()
            for (i in song.indices) {
                stringBuilder.append("Entry ${i + 1}:\n")
                stringBuilder.append("Date: ${song[i]}\n")
                stringBuilder.append("Minutes Played: ${artist[i]}\n")
                stringBuilder.append("Genre: ${comments[i]}\n")
                stringBuilder.append("Rating: ${rating[i]}\n\n")
            }
            display.text = builder.toString()
        } else {
            display.text = "No data available. Please go back and add some entries."
        }
    }
    /* private fun handleTotalRating(){
        val totalInput = song.size
        val totalRatings = rating.map { it.toIntOrNull() ?: 0 }.sum()
        display.text = "Total Inputs: $totalInput\nTotal Rating: $totalRatings"
    }

     */
    private fun handleAverageRating(){
       /* if (song.isEmpty()) {
            display.text = "No data to calculate average."
            return
        }
        val totalInput = song.map { it.toIntOrNull() ?: 0 }.sum()
        val totalRatings = rating.toSet().size // Avoid counting the same date multiple times

        val average = if (totalInput > 0) totalRatings / totalInput else 0

        display.text = "Average Minutes Per Day: $average"

        */

        if (song.isEmpty()) {
            display.text = "No data to calculate average."
            return
        }
        var totalRating = 0
        for (i in song.indices) {
            totalRating += (rating[i].toIntOrNull() ?: 0)
        }
        val avg = totalRating / rating.size
        display.text = "Average Rating: $avg rating"

    }
}