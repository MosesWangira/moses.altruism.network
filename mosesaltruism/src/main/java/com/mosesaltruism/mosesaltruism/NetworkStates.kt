package com.mosesaltruism.mosesaltruism

import android.os.Build
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


open class NetworkStates : Fragment(), ConnectionStateMonitor.OnNetworkAvailableCallbacks {

    private var snackBar: CustomSnackBar? = null
    private var connectionStateMonitor: ConnectionStateMonitor? = null
    private var viewGroup: ViewGroup? = null

    override fun onPositive() {
        requireActivity().runOnUiThread {
            snackBar?.dismiss()
        }
    }

    override fun onNegative() {
        requireActivity().runOnUiThread {
            snackBar?.setText("No internet connection.")?.show()
        }
    }

    override fun onStart() {
        super.onStart()
        snackBar?.dismiss()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onResume() {
        super.onResume()
        if (viewGroup == null) viewGroup = requireActivity().findViewById(android.R.id.content)
        if (snackBar == null)
            snackBar = CustomSnackBar.make(viewGroup!!, Snackbar.LENGTH_INDEFINITE)
                .setText("No internet connection.")

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
        snackBar?.dismiss()
        snackBar = null
        //Unregister
        connectionStateMonitor?.disable()
        connectionStateMonitor = null
        super.onPause()
    }
}