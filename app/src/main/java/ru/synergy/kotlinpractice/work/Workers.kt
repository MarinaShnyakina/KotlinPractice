package ru.synergy.kotlinpractice.work

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.synergy.kotlinpractice.databinding.ActivityYoutuberBinding

class Workers : AppCompatActivity() {

    lateinit var bindingClass: ActivityYoutuberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityYoutuberBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)


        bindingClass.buttonResult.setOnClickListener {

            val resultValue = bindingClass.editTextValue.text.toString()

            when (resultValue) {

                Constance.DEVELOPER -> {
                    val timeText = "Получите ваши ${Constance.DEVELOPER_SALARY}"
                   bindingClass.textViewResult.text = if (bindingClass.editTextPassword.text.toString()
                       == Constance.DEVELOPER_PASSWORD
                   ) {
                       timeText
                    } else {
                        "Неверный пароль"
                    }
                }
                Constance.COACH -> {
                    val timeText = "Получите ваши ${Constance.COACH_SALARY}"
                    bindingClass.textViewResult.text =
                        if (bindingClass.editTextPassword.text.toString()
                            == Constance.COACH_PASSWORD
                        ) {
                            timeText
                        } else {
                            "Неверный пароль"
                        }
                }

                Constance.MANAGER -> {
                    val timeText = "Получите ваши ${Constance.MANAGER_SALARY}"
                    bindingClass.textViewResult.text =
                        if (bindingClass.editTextPassword.text.toString()
                            == Constance.MANAGER_PASSWORD
                        ) {
                            timeText
                        } else {
                            "Неверный пароль"
                        }
                }

                else -> {
                    bindingClass.textViewResult.visibility = View.VISIBLE
                    bindingClass.textViewResult.text = "Нет такого сотрудника"

                }

            }
        }
    }
}




