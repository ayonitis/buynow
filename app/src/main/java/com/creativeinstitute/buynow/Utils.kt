package com.creativeinstitute.buynow

import android.widget.EditText

fun EditText.isEmpty():Boolean {

    if (this.text.toString().isEmpty()) {
        this.error = "This field cannot be empty!"
        return true
    }
    return false
}