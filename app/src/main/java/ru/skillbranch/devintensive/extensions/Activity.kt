package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

fun Activity.hideKeyboard() {
    val view = this.currentFocus
    view?.let { v ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }
//    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//    imm.hideSoftInputFromWindow(this.et_message.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun Activity.isKeyboardOpen(): Boolean {
    val r = Rect()
    val rootView = findViewById<View>(android.R.id.content)
    rootView.getWindowVisibleDisplayFrame(r)

    val heightDiff = rootView.rootView.height - (r.bottom - r.top);
    if (heightDiff > 100) { // if more than 100 pixels, its probably a keyboard...
        return true
    }
    return false
}
fun Activity.isKeyboardClosed(): Boolean {
    return !isKeyboardOpen()
}