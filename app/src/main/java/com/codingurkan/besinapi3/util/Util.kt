package com.codingurkan.besinapi3.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide


fun ImageView.loadImage(url : String){
    Glide.with(this.context)
        .load(url)
        .into(this)
}
fun showMessage(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}