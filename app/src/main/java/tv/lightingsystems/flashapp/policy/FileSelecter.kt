package tv.lightingsystems.flashapp.policy

import android.net.Uri
import android.webkit.ValueCallback

interface FileSelecter {

    fun onSelectFiles(selectedFiles: ValueCallback<Array<Uri>>?)

}