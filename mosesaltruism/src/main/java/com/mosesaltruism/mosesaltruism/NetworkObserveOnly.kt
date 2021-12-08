package com.mosesaltruism.mosesaltruism

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

open class NetworkObserveOnly : Fragment(), ConnectionStateMonitor.OnNetworkAvailableCallbacks {

    private var snackBar: CustomSnackBar? = null
    private var connectionStateMonitor: ConnectionStateMonitor? = null

    override fun onPositive() {

    }

    override fun onNegative() {

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onResume() {
        super.onResume()
        if (connectionStateMonitor == null)
            connectionStateMonitor = ConnectionStateMonitor(requireContext(), this)
        //Register
        connectionStateMonitor?.enable()

        // Recheck network status manually whenever activity resumes
        if (connectionStateMonitor?.hasNetworkConnection() == false) onNegative()
        else onPositive()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onPause() {
        snackBar = null
        //Unregister
        connectionStateMonitor?.disable()
        connectionStateMonitor = null
        super.onPause()
    }
}