package com.example.roomdemo.view.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.roomdemo.R
import com.example.roomdemo.db.users.User

/**
 * Created by uzafar
 * on 31 Jan, 2019
 * at 1:45 PM
 */

class UserListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>() // Cached copy of users

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = inflater.inflate(R.layout.user_item, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = users[position]
        holder.id.text = current.uid.toString()
        holder.firstName.text = current.firstName.toString()
        holder.lastName.text = current.lastName.toString()
    }

    internal fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.tv_id)
        val firstName: TextView = itemView.findViewById(R.id.tv_firstName)
        val lastName: TextView = itemView.findViewById(R.id.tv_lastName)
    }
}