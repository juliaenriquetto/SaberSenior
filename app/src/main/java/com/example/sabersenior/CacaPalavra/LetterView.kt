import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import java.util.jar.Attributes
import androidx.appcompat.widget.AppCompatTextView
import timber.log.Timber


class LetterView( context: Context,
                attr: AttributeSet? = null
) : AppCompatTextView(context, attr)
{
    private var textPercentSize = 0.80f

    init {
        text = "A"
        gravity = Gravity.CENTER
        includeFontPadding = false
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)

        textSize = measuredWidth * textPercentSize

        Timber.i("onMeasure\n" +
                "view size -> $measuredWidth\n" +
                "text size -> $textSize")
    }

    override fun setTextSize(size: Float) {
        super.setTextSize(TypedValue.COMPLEX_UNIT_PX, size)
    }
}