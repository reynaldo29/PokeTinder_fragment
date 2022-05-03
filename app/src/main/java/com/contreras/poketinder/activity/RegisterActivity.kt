package com.contreras.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.contreras.poketinder.data.User
import com.contreras.poketinder.databinding.ActivityRegisterBinding
import com.contreras.poketinder.util.SharedPreferenceUtil

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate){
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }
    fun validateInput(){
        if(binding.edtEmail.text.isEmpty() || binding.edtPassword.text.isEmpty() || binding.edtUserName.text.isEmpty() ||
            binding.edtPassword2.text.isEmpty()){
            Toast.makeText(this,"LLenar campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun registerUser(view: View){


        val user = User(
            "1",
            binding.edtUserName.text.toString(),
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString())
        sharedPreferenceUtil.saveFacebookUser(user)


        if(binding.edtEmail.text.isNotEmpty() && binding.edtPassword.text.isNotEmpty() &&
            binding.edtUserName.text.isNotEmpty() && binding.edtPassword2.text.isNotEmpty()  && binding.edtPassword.text.length>5){

                val intent = Intent(applicationContext, LoginActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
        }else if(binding.edtEmail.text.isNotEmpty() && binding.edtPassword.text.isNotEmpty() &&
            binding.edtUserName.text.isNotEmpty() && binding.edtPassword2.text.isNotEmpty() && binding.edtPassword.text.length>1
            && binding.edtPassword.text.length< 6){
            Toast.makeText(this,"La contraseña no debe ser menor de 6 digitos",Toast.LENGTH_SHORT).show()

        }else {
            validateInput()
        }


    }
    fun loginUser(view: View){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }
}