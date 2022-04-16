package com.studying.howistheweather.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.studying.howistheweather.R
import com.studying.howistheweather.databinding.AccessEditTextBinding

class AccessEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttrs) {

    private val binding = AccessEditTextBinding
        .inflate(LayoutInflater.from(context), this, true)

    init {
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let {
            val attribute = context.obtainStyledAttributes(
                attrs,
                R.styleable.AccessEditText
            )
            setBackgroundResource(R.drawable.access_edit_text)

            this.binding.inputTextLayout.isPasswordVisibilityToggleEnabled =
                attribute.getBoolean(
                    R.styleable.AccessEditText_is_password,
                    false
                )
            this.binding.accessHintEditText.hint =
                attribute.getString(R.styleable.AccessEditText_change_hint)

            this.binding.accessHintEditText.inputType =
                attribute.getType(R.styleable.AccessEditText_input_type)

            attribute.recycle()
        }
    }

            fun isValid(): Boolean{
                return this.binding.accessHintEditText.text!!.isNotEmpty()
            }
}

