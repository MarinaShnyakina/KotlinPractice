package ru.synergy.kotlinpractice.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import ru.synergy.kotlinpractice.R
import ru.synergy.kotlinpractice.databinding.ActivitySignInUpBinding
import ru.synergy.kotlinpractice.databinding.ActivityYoutuberBinding

class SignInUp : AppCompatActivity() {
    lateinit var bindingClass : ActivitySignInUpBinding
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignInUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(ConstancePeople.SIGN_STATE)!!

        if (signState == ConstancePeople.SIGN_IN_STATE) {

            bindingClass.editTextFirstName.visibility = View.GONE
            bindingClass.editTextLastName.visibility = View.GONE
            bindingClass.editTextPhone.visibility = View.GONE
            bindingClass.buttonAvatar.visibility = View.INVISIBLE

        }
    }

    fun onClickSave(view: View) {

        if (signState == ConstancePeople.SIGN_UP_STATE) {

            val intent = Intent()
            intent.putExtra(ConstancePeople.LOGIN, bindingClass.editTextLogin.text.toString())
            intent.putExtra(ConstancePeople.PASSWORD, bindingClass.editTextPassword.text.toString())
            intent.putExtra(ConstancePeople.FIRST_NAME, bindingClass.editTextFirstName.text.toString())
            intent.putExtra(ConstancePeople.LAST_NAME, bindingClass.editTextLastName.text.toString())
            intent.putExtra(ConstancePeople.PHONE, bindingClass.editTextPhone.text.toString())
            if(bindingClass.imageViewAvatar.isVisible)intent.putExtra(ConstancePeople.AVATAR_ID, R.drawable.manager)
            setResult(RESULT_OK, intent)
            finish()

        } else if(signState == ConstancePeople.SIGN_IN_STATE) {
            intent.putExtra(ConstancePeople.LOGIN, bindingClass.editTextLogin.text.toString())
            intent.putExtra(ConstancePeople.PASSWORD, bindingClass.editTextPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun onClickAvatar(view: View) {

        bindingClass.imageViewAvatar.visibility = View.VISIBLE
    }
}