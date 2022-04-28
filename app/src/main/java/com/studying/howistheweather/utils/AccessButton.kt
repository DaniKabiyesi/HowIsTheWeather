package com.studying.howistheweather.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.studying.howistheweather.R
import com.studying.howistheweather.databinding.AccessButtonBinding

class AccessButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttrs) {

    private val binding = AccessButtonBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet) {
        attrs.let {
            val attribute = context.obtainStyledAttributes(
                attrs,
                R.styleable.AccessButton
            )

            this.binding.textButton.text = attribute.getString(R.styleable.AccessButton_button_text)

            attribute.recycle()

        }
    }



}