package tv.lightingsystems.flashapp

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tv.lightingsystems.flashapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (isNetworkAvailable()){
            navigateToTheFlashLightActivity()
        } else {
            navigateToTheNoInternetActivity()
        }
    }

    private fun navigateToTheFlashLightActivity(){
        val intentToFlashLight = Intent(this, FlashLightActivity::class.java)

        val loadingText = getString(R.string.your_screen_is_loading)

        lifecycleScope.launch {

            for (i in loadingText.indices){
                val newText = loadingText.toMutableList().apply {
                    this[i] = this[i].uppercaseChar()
                }.joinToString("")
                binding.loadingTV.text = newText
                delay(100)
            }

            startActivity(intentToFlashLight)
        }

    }

    private fun navigateToTheNoInternetActivity(){
        val intentToTheNoNet = Intent(this, NoInternetActivity::class.java)
        startActivity(intentToTheNoNet)
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || networkCapabilities.hasTransport(
            NetworkCapabilities.TRANSPORT_CELLULAR)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}