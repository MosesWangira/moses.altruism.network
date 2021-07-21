package com.mosesaltruism.mosesaltruism

import android.annotation.SuppressLint
import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

/**
 * Extend this activity whenever you want the activity to react to network status changes
 */
@SuppressLint("Registered")
open class NetworkState : AppCompatActivity(),
    ConnectionStateMonitor.OnNetworkAvailableCallbacks {

    private var snackBar: CustomSnackBar? = null
    private var connectionStateMonitor: ConnectionStateMonitor? = null
    private var viewGroup: ViewGroup? = null

    override fun onStart() {
        super.onStart()
        snackBar?.dismiss()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onResume() {
        super.onResume()
        if (viewGroup == null) viewGroup = findViewById(android.R.id.content)
        if (snackBar == null)
            snackBar = CustomSnackBar.make(viewGroup!!, Snackbar.LENGTH_INDEFINITE)
                .setText("No internet connection.")

        if (connectionStateMonitor == null)
            connectionStateMonitor = ConnectionStateMonitor(this, this)
        //Register
        connectionStateMonitor?.enable()

        // Recheck network status manually whenever activity resumes
        if (connectionStateMonitor?.hasNetworkConnection() == false) onNegative()
        else onPositive()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onPause() {
        snackBar?.dismiss()
        snackBar = null
        //Unregister
        connectionStateMonitor?.disable()
        connectionStateMonitor = null
        super.onPause()
    }

    override fun onPositive() {
        runOnUiThread {
            snackBar?.dismiss()
        }
    }

    override fun onNegative() {
        runOnUiThread {
            snackBar?.setText("No internet connection.")?.show()
        }
    }
}
