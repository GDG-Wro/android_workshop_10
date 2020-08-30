package pl.gdgwroclaw.workshop.styles

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.withStyledAttributes
import androidx.core.view.postDelayed
import kotlin.properties.Delegates

class TrafficLightView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.trafficLightViewStyle,
    defStyleRes: Int = R.style.TrafficLightView_Green
) : View(context, attrs, defStyleAttr, defStyleRes) {
    @get:ColorInt
    private var color by Delegates.notNull<Int>()
    private var isAnimating = false

    init {
        context.withStyledAttributes(
            attrs,
            R.styleable.TrafficLightView,
            defStyleAttr,
            defStyleRes
        ) {
            color = getColor(R.styleable.TrafficLightView_color, Color.CYAN)
        }
        setOnClickListener {
            color = Color.YELLOW
            invalidate()
        }
        setOnLongClickListener {
            isAnimating = true
            changeColor()
            true
        }
    }

    private fun changeColor() {
        color = when (color) {
            Color.RED -> Color.GREEN
            else -> Color.RED
        }
        invalidate()
        postDelayed(500, ::changeColor)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(color)
    }
}