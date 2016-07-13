package yamaguchi.na_s.jp.ankofirst

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RelativeLayout
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityUi().setContentView(this)
    }
}

class MainActivityUi() : AnkoComponent<MainActivity> {

    val xmlLayoutId = View.generateViewId()
    var xmlLayout : RelativeLayout? = null

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        relativeLayout {

            xmlLayout = include<RelativeLayout>(R.layout.xml_layout) {
                id = xmlLayoutId
            }

            textView {
                text = "Hello, Anko!"
                backgroundColor = Color.BLACK
                textColor = Color.WHITE
            }.lparams {
                topMargin = dip(16)
                rightOf(xmlLayoutId)
                alignParentRight()
            }
        }
    }
}
