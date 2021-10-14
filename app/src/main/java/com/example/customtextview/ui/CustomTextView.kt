package com.example.customtextview.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var bitmap: Bitmap? = null
    private var customCanvas: CustomCanvas? = null
    private var useCustomTextView = false

    init {
        useCustomTextView =
            typeface.style == Typeface.ITALIC || typeface.style == Typeface.BOLD_ITALIC
    }

    private fun checkForTypeFaceChange(): Boolean {
        useCustomTextView =
            typeface.style == Typeface.ITALIC || typeface.style == Typeface.BOLD_ITALIC
        if (useCustomTextView) {
            return createBitMap()
        }
        return false
    }

    private fun createBitMap(): Boolean {
        if (bitmap?.width == width && bitmap?.height == height) return true
        customCanvas?.bitmap?.recycle()
        try {
            bitmap =
                Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            customCanvas = CustomCanvas(bitmap!!)
        } catch (e: Throwable) {
            customCanvas?.bitmap?.recycle()
            customCanvas = null
            return false
        }
        return true
    }

    override fun onSizeChanged(
        width: Int, height: Int,
        oldwidth: Int, oldheight: Int
    ) {
        if (width != oldwidth || height != oldheight && width > 0 && height > 0) {
            checkForTypeFaceChange()
        }
        super.onSizeChanged(width, height, oldwidth, oldheight)
    }

    override fun onDraw(canvas: Canvas) {
        if (checkForTypeFaceChange()) {
            customCanvas?.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
            super.onDraw(customCanvas)
            canvas.drawBitmap(bitmap!!, 0f, 0f, null)
        } else {
            super.onDraw(canvas)
        }
    }
}

class CustomCanvas(val bitmap: Bitmap) : Canvas(bitmap) {
    override fun clipRect(
        clipLeft: Float,
        clipTop: Float,
        clipRight: Float,
        clipBottom: Float
    ): Boolean {
        return true
    }
}
