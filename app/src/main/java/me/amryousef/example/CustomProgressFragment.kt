package me.amryousef.example

import androidx.navigation.dynamicfeatures.fragment.ui.AbstractProgressFragment

class CustomProgressFragment : AbstractProgressFragment() {
    override fun onCancelled() {

    }

    override fun onFailed(errorCode: Int) {
    }

    override fun onProgress(status: Int, bytesDownloaded: Long, bytesTotal: Long) {
    }
}