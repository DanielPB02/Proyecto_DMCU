package com.example.proyecto_dmcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.login_screen.*
import kotlinx.android.synthetic.main.signin_screen.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        b_signin.setOnClickListener {
            showSignin()
        }

        b_accept.setOnClickListener{
            login()
        }
    }

    private fun showSignin() {
        setContentView(R.layout.signin_screen)
        b_accSignin.setOnClickListener{
            showLogin()
        }
        b_haveAcc.setOnClickListener {
            showLogin()
        }
    }

    private fun showLogin() {
        setContentView(R.layout.login_screen)
        b_accept.setOnClickListener{
            login()
        }
        b_signin.setOnClickListener {
            showSignin()
        }
    }

    private fun login() {
        //setContentView(R.layout.fragment_home)
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
        b_signin.setOnClickListener {
            showSignin()
        }
    }

}
