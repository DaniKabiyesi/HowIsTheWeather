package com.studying.howistheweather.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.studying.howistheweather.R
import com.studying.howistheweather.databinding.LoadingViewBinding

class LoadingView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val binding: LoadingViewBinding =
        LoadingViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        this.binding.root.setOnClickListener {}
        context.obtainStyledAttributes(R.styleable.LoadingView).apply {
            enabled(getBoolean(R.styleable.LoadingView_visible, true))
            recycle()
        }
    }

    fun show() {
        this.enabled(true)
    }

    fun dismiss() {
        this.enabled(false)
    }

    fun isShowing(): Boolean {
        return this.binding.root.visibility == View.VISIBLE
    }

    private fun enabled(isEnabled: Boolean) {
        this.binding.root.visibility = if (isEnabled) View.VISIBLE else View.GONE
    }
}