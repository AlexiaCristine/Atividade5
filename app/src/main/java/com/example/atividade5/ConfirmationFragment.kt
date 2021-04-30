package com.example.atividade5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.room.Room
import com.example.atividade5.database.AppDatabase
import com.example.atividade5.database.daos.RecordsDAO
import kotlinx.android.synthetic.main.fragment_confirmation.*

class ConfirmationFragment : Fragment() {

        lateinit var recipient : String
        var amount: Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient")!!
        amount = requireArguments().getFloat("amount")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val confirmationMessage = "You have sent $amount to $recipient"
        confirmation_message.text = confirmationMessage
    }
}