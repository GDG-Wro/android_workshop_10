package pl.gdgwroclaw.workshop.styles

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.withStyledAttributes
import kotlin.properties.Delegates

class TrafficLightView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.trafficLightViewStyle,
    defStyleRes: Int = R.style.TrafficLightView_Green
) : View(context, attrs, defStyleAttr, defStyleRes) {
    @get:ColorInt
    private var color by Delegates.notNull<Int>()

    init {
        context.withStyledAttributes(attrs, R.styleable.TrafficLightView, defStyleAttr, defStyleRes) {
            color = getColor(R.styleable.TrafficLightView_color, Color.CYAN)
        }
        setBackgroundColor(color)
    }
}