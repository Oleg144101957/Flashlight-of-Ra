package tv.lightingsystems.flashapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.lightingsystems.flashapp.databinding.ActivityNointernetBinding

class NoInternetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNointernetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNointernetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReload.setOnClickListener {
            val intentToThePreviousScreen = Intent(this, StartActivity::class.java)
            startActivity(intentToThePreviousScreen)
        }
    }
}