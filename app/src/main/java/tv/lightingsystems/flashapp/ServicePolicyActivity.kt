package tv.lightingsystems.flashapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.lightingsystems.flashapp.databinding.ActivityServicepolicyBinding
import tv.lightingsystems.flashapp.policy.MyPolicyView

class ServicePolicyActivity : AppCompatActivity() {


    private lateinit var binding: ActivityServicepolicyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicepolicyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPolicyView = MyPolicyView(this)
        myPolicyView.startPolicyInitialization()
        binding.root.addView(myPolicyView)
        myPolicyView.loadUrl("https://google.com")


    }

}