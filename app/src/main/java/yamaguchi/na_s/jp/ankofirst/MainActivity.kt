package yamaguchi.na_s.jp.ankofirst

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.bindView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(MainActivityUi(this).createView(
                AnkoContext.Companion.create(this, this@MainActivity)
        ).rootView)
    }
}

class MainActivityUi : FrameLayout, AnkoComponent<MainActivity> {

    constructor(context: Context?) : super(context)

    constructor(context: Context?,
                attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    val xmlLayoutId = View.generateViewId()

    val textViewId = View.generateViewId()
    val textView : TextView by bindView(textViewId)

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        relativeLayout {

            include<RelativeLayout>(R.layout.xml_layout) {
                id = xmlLayoutId
            }

            textView {
                id = textViewId
                text = "Hello, Anko!"
                backgroundColor = Color.BLACK
                textColor = Color.WHITE
            }.lparams {
                topMargin = dip(16)
                rightOf(xmlLayoutId)
                alignParentRight()
            }
        }.apply { this@MainActivityUi.addView(this) }
    }
}
