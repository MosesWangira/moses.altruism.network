package com.mosesaltruism.mosesaltruism

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.snackbar.BaseTransientBottomBar

class CustomSnackBar private constructor(
    parent: ViewGroup, content: View,
    callback: com.google.android.material.snackbar.ContentViewCallback
) : BaseTransientBottomBar<CustomSnackBar>(parent, content, callback) {

    fun setText(text: CharSequence): CustomSnackBar {
        val textView = getView().findViewById<View>(R.id.snackbar_text) as TextView
        textView.text = text
        return this
    }

    /**
     * content view inflation animation
     */
    private class CustomContentViewCallback(private val content: View) :
        com.google.android.material.snackbar.ContentViewCallback {

        override fun animateContentIn(delay: Int, duration: Int) {
        }

        override fun animateContentOut(delay: Int, duration: Int) {
//            ObjectAnimator.ofFloat(content, View.SCALE_Y, 1f, 0f).setDuration(1000).start()
        }
    }

    companion object {
        fun make(parent: ViewGroup, duration: Int): CustomSnackBar {
            val inflater = LayoutInflater.from(parent.context)
            val content = inflater.inflate(R.layout.snack_bar, parent, false)
            val viewCallback = CustomContentViewCallback(content)

            return CustomSnackBar(parent, content, viewCallback).run {
                getView().setPadding(0, 0, 0, 0)
                this.duration = duration
                this
            }
        }
    }
}