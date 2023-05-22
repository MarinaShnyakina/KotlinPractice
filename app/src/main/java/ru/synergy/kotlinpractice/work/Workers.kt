package ru.synergy.kotlinpractice.work

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.synergy.kotlinpractice.R
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
                    bindingClass.textViewResult.visibility = View.VISIBLE
                    bindingClass.imageViewPhoto.visibility = View.VISIBLE
                    val timeText = "Получите ваши ${Constance.DEVELOPER_SALARY}"
                    if (bindingClass.editTextPassword.text.toString()
                       == Constance.DEVELOPER_PASSWORD
                   ) {
                        bindingClass.textViewResult.text = timeText
                        bindingClass.imageViewPhoto.setImageResource(R.drawable.developer)
                    } else {
                        bindingClass.textViewResult.text = "Неверный пароль"
                    }
                }
                Constance.COACH -> {
                    bindingClass.textViewResult.visibility = View.VISIBLE
                    bindingClass.imageViewPhoto.visibility = View.VISIBLE
                    val timeText = "Получите ваши ${Constance.COACH_SALARY}"
                    if (bindingClass.editTextPassword.text.toString()
                            == Constance.COACH_PASSWORD
                        ) {
                        bindingClass.textViewResult.text = timeText
                        bindingClass.imageViewPhoto.setImageResource(R.drawable.coach)
                        } else {
                        bindingClass.textViewResult.text = "Неверный пароль"
                        }
                }

                Constance.MANAGER -> {
                    bindingClass.textViewResult.visibility = View.VISIBLE
                    bindingClass.imageViewPhoto.visibility = View.VISIBLE
                    val timeText = "Получите ваши ${Constance.MANAGER_SALARY}"
                    if (bindingClass.editTextPassword.text.toString()
                            == Constance.MANAGER_PASSWORD
                        ) {
                        bindingClass.textViewResult.text = timeText
                        bindingClass.imageViewPhoto.setImageResource(R.drawable.manager)
                        } else {
                        bindingClass.textViewResult.text = "Неверный пароль"
                        }
                }

                else -> {
                    bindingClass.textViewResult.visibility = View.VISIBLE
                    bindingClass.imageViewPhoto.visibility = View.VISIBLE
                    bindingClass.imageViewPhoto.setImageResource(R.drawable.coworker)
                    bindingClass.textViewResult.text = "Нет такого сотрудника"

                }

            }
        }
    }
}




