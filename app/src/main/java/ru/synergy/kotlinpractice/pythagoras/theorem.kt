package ru.synergy.kotlinpractice.pythagoras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.synergy.kotlinpractice.R
import ru.synergy.kotlinpractice.databinding.ActivityTheoremBinding
import kotlin.math.pow
import kotlin.math.sqrt

class theorem : AppCompatActivity() {
    lateinit var binding: ActivityTheoremBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTheoremBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            val result =  getString(R.string.resultInfo) + getResult()
            binding.textViewResult.text = result
        }

    }

    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = R.string.error.toString()
            if (edB.text.isNullOrEmpty()) edB.error = R.string.error.toString()
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt( (a.pow(2) + b.pow(2)) ).toString()
    }
}