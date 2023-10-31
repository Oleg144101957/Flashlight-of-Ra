package tv.lightingsystems.flashapp.light

import android.content.Context
import android.hardware.camera2.CameraManager
import java.lang.Exception

class Light(context: Context) {

    private val cameraMan: CameraManager =
        context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    private val camId = cameraMan.cameraIdList[0]

    fun turnFlashLightOn(){
        try {
            cameraMan.setTorchMode(camId, true)
        } catch (e: Exception){

        }
    }

    fun turnFlashLightOff(){
        try {
            cameraMan.setTorchMode(camId, false)
        } catch (e: Exception){

        }
    }
}