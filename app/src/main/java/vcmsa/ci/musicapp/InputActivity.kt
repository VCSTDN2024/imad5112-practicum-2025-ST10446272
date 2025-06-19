package vcmsa.ci.musicapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class InputActivity : AppCompatActivity() {

    //private lateinit var song: EditText
    //private lateinit var artist: EditText
    //private lateinit var radioGroup: RadioGroup

    //private lateinit var comments: EditText
    private var song = mutableListOf<String>()
    private var artist = mutableListOf<String>()
    private var ratings = mutableListOf<String>()
    private var comments = mutableListOf<String>()

    // Late Initialized variables
    private lateinit var radioGroup: RadioGroup
    //lateinit var button: Button
    private lateinit var add: Button
    private lateinit var clear: Button
    private lateinit var view: Button
    private lateinit var details: TextView
    private lateinit var exit: Button

    private val maxEntries = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input)

        ratings = findViewById(R.id.btnRadioGroup)

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
                Snackbar.make(view, "List is empty. Add entries first.", Snackbar.LENGTH_SHORT)
                    .show()

            }
        }

        add = findViewById(R.id.buttonAdd)
        add.setOnClickListener {
            if (song.size >= maxEntries) {
                Toast.makeText(this, "You can only add up to $maxEntries entries.", Toast.LENGTH_SHORT).show()
                //return@setOnClickListener
            }
            val selectedRadioId = radioGroup.checkedRadioButtonId
            val selectedRating = if (selectedRadioId != -1) {
                val radioButton: RadioButton = findViewById(selectedRadioId)
                radioButton.text.toString()
            } else {
                Toast.makeText(this, "Please select a rating", Toast.LENGTH_SHORT).show()

            }
            val etSong = findViewById<EditText>(R.id.etSongTitle)
            val songInput = etSong.text.toString()
            if (songInput.isBlank()) {
                Toast.makeText(this, "Please enter minutes played", Toast.LENGTH_SHORT).show()
            }


            val etArtist = findViewById<EditText>(R.id.etArtist)
            val artistName = etArtist.text.toString()
            if (artistName.isBlank()) {
                Toast.makeText(this, "Please enter minutes played", Toast.LENGTH_SHORT).show()
            }

            val etComments = findViewById<EditText>(R.id.etComments)
            val commentInput = etComments.text.toString()
            if (commentInput.isBlank()) {
                Toast.makeText(this, "Please enter minutes played", Toast.LENGTH_SHORT).show()

                song.add(songInput)
                artist.add(artistName)
                ratings.add(selectedRating.toString())
                comments.add(commentInput)

                Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // This method is properly inside the class
    fun radioButtonClick(view: View) {
        val selectedId = radioGroup.checkedRadioButtonId
        if (selectedId != -1) {
            val radio: RadioButton = findViewById(selectedId)
            Toast.makeText(applicationContext, "On click : ${radio.text}", Toast.LENGTH_SHORT).show()
        }
    }

        private fun handleClearEntry() {
            // Clear stored lists
            song.clear()
            artist.clear()
            ratings.clear()
            comments.clear()

            // Clear EditText
            val etSong = findViewById<EditText>(R.id.etSongTitle)
            etSong.text.clear()

            val etArtist = findViewById<EditText>(R.id.etArtist)
            etArtist.text.clear()

            val etComment = findViewById<EditText>(R.id.etComments)
            etComment.text.clear()

            // Clear RadioGroup selection
            //btnRadioGroup.clearCheck()
            radioGroup.clearCheck()

            val etComments = findViewById<EditText>(R.id.etComments)
            etComments.text.clear()


    }
}