package ru.degus.randomanimal.util

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:url", "app:errorImage")
fun loadImage(
    view: ImageView?,
    url: String?,
    errorImage: Drawable?
) {
    errorImage?.let { Picasso.get().load(url).error(it).fit().into(view) }
}

fun parsePath(message : String) : String {
    val fullName = message.substringAfterLast( "/")
    return fullName.substringBeforeLast(".")
}
