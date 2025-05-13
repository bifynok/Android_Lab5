package com.example.lab5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class LevelView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var pitch = 0f
    private val paint = Paint()

    init {
        paint.color = Color.GREEN
        paint.strokeWidth = 10f
        paint.isAntiAlias = true
    }

    fun updatePitch(pitch: Float) {
        this.pitch = pitch
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val angle = Math.toRadians(pitch.toDouble())

        val lineLength = width.toFloat()

        val startX = centerX - lineLength * sin(angle).toFloat()
        val startY = centerY - lineLength * cos(angle).toFloat()
        val endX = centerX + lineLength * sin(angle).toFloat()
        val endY = centerY + lineLength * cos(angle).toFloat()

        canvas.drawColor(Color.BLACK)
        canvas.drawLine(startX, startY, endX, endY, paint)
    }
}
