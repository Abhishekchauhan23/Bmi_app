package ab.sample.bottom_nav2.Activities

import ab.sample.bottom_nav2.Fragments.FirstFragment
import ab.sample.bottom_nav2.Fragments.SecondFragment
import ab.sample.bottom_nav2.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment:Fragment= FirstFragment()
        val secondFragment:Fragment= SecondFragment()

        setCurrentFragment(firstFragment)


        bottom_bar.onTabSelected = {

            Log.d("bottom_bar", "Selected tab: " + it.title)
            if (it.title=="Home"){
                setCurrentFragment(firstFragment)
            }
            if (it.title=="Records"){
                setCurrentFragment(secondFragment)
            }
        }



    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}