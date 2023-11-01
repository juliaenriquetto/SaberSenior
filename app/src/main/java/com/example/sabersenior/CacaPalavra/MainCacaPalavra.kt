import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neo.wordsearch.databinding.ActivityCacaPalavraMainBinding


class MainCacaPalavra : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCacaPalavraMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}