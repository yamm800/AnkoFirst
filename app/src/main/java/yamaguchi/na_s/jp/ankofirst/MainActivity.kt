package yamaguchi.na_s.jp.ankofirst

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityUi().setContentView(this)
    }
}

class MainActivityUi() : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout {
            textView {
                text = "Hello, Anko!"
            }
        }

    }
}
