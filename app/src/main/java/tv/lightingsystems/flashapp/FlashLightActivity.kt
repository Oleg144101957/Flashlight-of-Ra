package tv.lightingsystems.flashapp

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import tv.lightingsystems.flashapp.databinding.ActivityFlashlightBinding
import tv.lightingsystems.flashapp.light.Light

class FlashLightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFlashlightBinding
    private lateinit var light: Light
    private var isShiningNow = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlashlightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        light = Light(this)

        binding.lightBtn.setOnClickListener {

            isShiningNow = if (isShiningNow){
                light.turnFlashLightOff()
                false
            } else {
                light.turnFlashLightOn()
                true
            }

        }

        binding.infobtn.setOnClickListener {
            val intentToTheInfoActivity = Intent(this, ServicePolicyActivity::class.java)
            startActivity(intentToTheInfoActivity)
        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}