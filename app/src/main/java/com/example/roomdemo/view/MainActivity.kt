package com.example.roomdemo.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.roomdemo.R
import com.example.roomdemo.db.users.User
import com.example.roomdemo.view.recyclerview.UserListAdapter
import com.example.roomdemo.viewmodel.UsersViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UsersViewModel
    private val animator = Animator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)

        createList()
        setListeners()
        setAnimations()
    }

    private fun createList() {
        val adapter = UserListAdapter(this)
        userViewModel.allUsers.observe(this, Observer { words ->
            words?.let { adapter.setUsers(it) }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setAnimations() {
        animator.setFlyInLeft(et_firstName)
        animator.setFlyInLeft(et_lastName)
        animator.setFlyInLeft(recyclerView)
        animator.setFlyInTop(btn_add)
    }

    override fun onResume() {
        super.onResume()
        animator.startAnimations()
    }

    override fun onPause() {
        animator.reverseAnimations()
        super.onPause()
    }

    private fun setListeners() {
        btn_add.setOnClickListener { addRecord() }
    }

    private fun addRecord() {
        val firstName = et_firstName.text.toString().trim()
        val lastName = et_lastName.text.toString().trim()

        if (firstName.isBlank() || lastName.isBlank()) {
            Toast.makeText(this, "Please enter valid name", Toast.LENGTH_LONG).show()
            return
        }

        val user = User(firstName, lastName)

        userViewModel.insert(user)

        clearTextFields()
    }

    private fun clearTextFields() {
        et_firstName.text.clear()
        et_lastName.text.clear()
    }
}
