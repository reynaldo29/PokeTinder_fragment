package com.contreras.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.contreras.poketinder.data.User
import com.contreras.poketinder.databinding.ActivityLoginBinding
import com.contreras.poketinder.util.SharedPreferenceUtil

class LoginActivity:BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil= SharedPreferenceUtil().also { SharedPreferenceUtil
        it.setSharedPreference(this)
        }
    }
    fun validateInput(){
        if(binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            Toast.makeText(this,"LLenar campos",Toast.LENGTH_SHORT).show()
        }else if(binding.edtEmail.text.isEmpty() &&  binding.edtPassword.text.isNotEmpty()){
            Toast.makeText(this,"Completar campo E-mail",Toast.LENGTH_SHORT).show()
        }else if(binding.edtEmail.text.isNotEmpty() && binding.edtPassword.text.isEmpty()){
            Toast.makeText(this,"Completar campo contraseña",Toast.LENGTH_SHORT).show()
        }
    }
    fun startLogin(view:View){
        //Validate input

        val user: User? =sharedPreferenceUtil.getUser()
        if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())){
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }else if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password !=(binding.edtPassword.text.toString())){
            Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show()
        }else if(user?.email !=(binding.edtEmail.text.toString())
            && user?.password !=(binding.edtPassword.text.toString())
            && binding.edtEmail.text.isNotEmpty() && binding.edtPassword.text.isNotEmpty()) {
            Toast.makeText(this,"datos invalidos",Toast.LENGTH_SHORT).show()}
        else{
            validateInput()
        }
    }
    fun back(){
        finish()
    }
}