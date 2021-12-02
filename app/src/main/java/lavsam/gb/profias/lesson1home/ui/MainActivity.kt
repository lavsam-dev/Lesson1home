package lavsam.gb.profias.lesson1home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import lavsam.gb.profias.lesson1home.R
import lavsam.gb.profias.lesson1home.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit()
        }
    }
}