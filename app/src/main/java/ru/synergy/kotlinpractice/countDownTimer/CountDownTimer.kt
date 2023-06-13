package ru.synergy.kotlinpractice.countDownTimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import ru.synergy.kotlinpractice.databinding.ActivityCountDownTimerBinding

class CountDownTimer : AppCompatActivity() {
    private lateinit var binding: ActivityCountDownTimerBinding

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountDownTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonStart.setOnClickListener {
                startCountDownTimer(20000)
            }
        }
    }

    private fun startCountDownTimer(timeMillis: Long) {
        timer?.cancel()
        timer = object : CountDownTimer(timeMillis, 1) {
            override fun onTick(timeM: Long) {
                binding.textViewTimer.text = timeM.toString()
            }

            override fun onFinish() {
                binding.textViewTimer.text = "Finish"
            }
        }.start()

    }
}