package vcmsa.ci.musicapp
/*
https://za.pinterest.com/pin/2814818511609742/
 */
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class InputActivity : AppCompatActivity() {

    private var song = mutableListOf<String>()
    private var artist = mutableListOf<String>()
    private var ratings = mutableListOf<String>()
    private var comments = mutableListOf<String>()

    private lateinit var radioGroup: RadioGroup
    private lateinit var add: Button
    private lateinit var clear: Button
    private lateinit var view: Button
    private lateinit var exit: Button

    private val maxEntries = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)

        // Corrected assignment
        radioGroup = findViewById(R.id.radio_group)

        clear = findViewById(R.id.btnClear)
        clear.setOnClickListener {
            handleClearEntry()
        }

        exit = findViewById(R.id.btnExit)
        exit.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        view = findViewById(R.id.btnView)
        view.setOnClickListener {
            if (song.isNotEmpty()) {
                val intent = Intent(this, DetailsActivity::class.java)
                intent.putStringArrayListExtra("Song Title", ArrayList(song))
                intent.putStringArrayListExtra("Artist Name", ArrayList(artist))
                intent.putStringArrayListExtra("Rating", ArrayList(ratings))
                intent.putStringArrayListExtra("Comments", ArrayList(comments))
                startActivity(intent)
            } else {
                Snackbar.make(view, "List is empty. Add entries first.", Snackbar.LENGTH_SHORT).show()
            }
        }

        add = findViewById(R.id.buttonAdd)
        add.setOnClickListener {

            if (song.size >= maxEntries) {
                Toast.makeText(this, "You can only add up to $maxEntries entries.", Toast.LENGTH_SHORT).show()
            }

            val selectedRadioId = radioGroup.checkedRadioButtonId
            if (selectedRadioId == -1) {
                Toast.makeText(this, "Please select a rating", Toast.LENGTH_SHORT).show()

            }
            val selectedRating = findViewById<RadioButton>(selectedRadioId).text.toString()

            val etSong = findViewById<EditText>(R.id.etSongTitle)
            val songInput = etSong.text.toString().trim()
            if (songInput.isEmpty()) {
                Toast.makeText(this, "Please enter the song title", Toast.LENGTH_SHORT).show()
            }

            val etArtist = findViewById<EditText>(R.id.etArtist)
            val artistName = etArtist.text.toString().trim()
            if (artistName.isEmpty()) {
                Toast.makeText(this, "Please enter the artist name", Toast.LENGTH_SHORT).show()
            }

            val etComments = findViewById<EditText>(R.id.etComments)
            val commentInput = etComments.text.toString().trim()
            if (commentInput.isEmpty()) {
                Toast.makeText(this, "Please enter a comment", Toast.LENGTH_SHORT).show()
            }

            song.add(songInput)
            artist.add(artistName)
            ratings.add(selectedRating)
            comments.add(commentInput)

            Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show()

        }
            handleClearEntry()
    }

    fun radioButtonClick(view: View) {
        val selectedId = radioGroup.checkedRadioButtonId
        if (selectedId != -1) {
            val radio: RadioButton = findViewById(selectedId)
            Toast.makeText(applicationContext, "On click : ${radio.text}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleClearEntry() {
        song.clear()
        artist.clear()
        ratings.clear()
        comments.clear()

        findViewById<EditText>(R.id.etSongTitle).text.clear()
        findViewById<EditText>(R.id.etArtist).text.clear()
        findViewById<EditText>(R.id.etComments).text.clear()

        radioGroup.clearCheck()
    }
}
