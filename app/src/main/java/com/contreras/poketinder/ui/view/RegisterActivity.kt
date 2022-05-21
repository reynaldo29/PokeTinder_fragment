package com.contreras.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.contreras.poketinder.databinding.ActivityRegisterBinding
import com.contreras.poketinder.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate){
    private  lateinit var registerViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewModel = RegisterViewModel(this)
        registerViewModel.onCreate()

        registerViewModel.emptyField.observe(this){
            Toast.makeText(this,"Llenar los campos vacios",Toast.LENGTH_SHORT).show()
        }
        registerViewModel.registerFielsdError.observe(this){
            Toast.makeText(this,"La contraseña debe tener por lo menos 6 digitos",Toast.LENGTH_SHORT).show()
        }
        registerViewModel.goSuccesActivity.observe(this){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun registerUser(view: View){

        registerViewModel.validateInputs(binding.edtEmail.text.toString(),binding.edtPassword.text.toString(),
        binding.edtPassword2.text.toString(),binding.edtUserName.text.toString())

    }
    fun loginUser(view: View){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }
}