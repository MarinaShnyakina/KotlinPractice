package ru.synergy.kotlinpractice.registration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isInvisible
import ru.synergy.kotlinpractice.R
import ru.synergy.kotlinpractice.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    lateinit var bindingClass: ActivityRegistrationBinding

    private var launcher: ActivityResultLauncher<Intent>? = null

    private var login: String = "empty"
    private var password: String = "empty"
    private var firstName: String = "empty"
    private var lastName: String = "empty"
    private var phone: String = "empty"
    private var avatarImageId: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->

                if (result.resultCode == Activity.RESULT_OK) {
                    val _login = result.data?.getStringExtra(ConstancePeople.LOGIN)
                    val _password = result.data?.getStringExtra(ConstancePeople.PASSWORD)
                    if (login == _login && password == _password) {

                        bindingClass.imageViewAvatar.visibility = View.VISIBLE
                        bindingClass.imageViewAvatar.setImageResource(avatarImageId)
                        val textInfo = "$firstName $lastName"
                        bindingClass.textViewInfo.text = textInfo
                        bindingClass.buttonSignUp.visibility = View.GONE
                        bindingClass.buttonSignIn.text = "Выйти"

                    } else {
                        bindingClass.imageViewAvatar.visibility = View.VISIBLE
                        bindingClass.imageViewAvatar.setImageResource(R.drawable.coworker)
                        bindingClass.textViewInfo.text = "Такого аккаунта не существует!"
                    }

                } else if (result.resultCode == Activity.RESULT_OK) {
                    login = result.data?.getStringExtra(ConstancePeople.LOGIN)!!
                    password = result.data?.getStringExtra(ConstancePeople.PASSWORD)!!
                    firstName = result.data?.getStringExtra(ConstancePeople.FIRST_NAME)!!
                    lastName = result.data?.getStringExtra(ConstancePeople.LAST_NAME)!!
                    phone = result.data?.getStringExtra(ConstancePeople.PHONE)!!
                    avatarImageId = result.data!!.getIntExtra(ConstancePeople.AVATAR_ID, 0)
                    bindingClass.imageViewAvatar.visibility = View.VISIBLE
                    bindingClass.imageViewAvatar.setImageResource(avatarImageId)
                    val textInfo = "$firstName $lastName"
                    bindingClass.textViewInfo.text = textInfo
                    bindingClass.buttonSignUp.visibility = View.GONE
                    bindingClass.buttonSignIn.text = "Выйти"


                }
            }
    }

        fun onClickSignIn(view: View) {

            if (bindingClass.imageViewAvatar.isInvisible && bindingClass.textViewInfo.text.toString() != "Такого акаунта не существует!") {
                bindingClass.imageViewAvatar.visibility = View.INVISIBLE
                bindingClass.textViewInfo.text = ""
                bindingClass.buttonSignUp.visibility = View.VISIBLE
                bindingClass.buttonSignIn.text = getString(R.string.signIn)

            } else {
                launcher?.launch(Intent(this, SignInUp::class.java))
                intent.putExtra(ConstancePeople.SIGN_STATE, ConstancePeople.SIGN_IN_STATE)
                setResult(Activity.RESULT_OK, intent)
            }
        }

    fun onClickSignUp(view: View) {
        launcher?.launch(Intent(this, SignInUp::class.java))
        intent.putExtra(ConstancePeople.SIGN_STATE, ConstancePeople.SIGN_UP_STATE)
        setResult(Activity.RESULT_OK, intent)
    }

}