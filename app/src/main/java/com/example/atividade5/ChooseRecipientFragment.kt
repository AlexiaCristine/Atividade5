package com.example.atividade5

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.view.*
import kotlinx.android.synthetic.main.fragment_specify_amount.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ChooseRecipientFragment : Fragment(), View.OnClickListener{

    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.next_btn.setOnClickListener(this)
        view.cancel_btn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.next_btn -> {
                if(!TextUtils.isEmpty(input_amout.text.toString())) {
                val bundle = bundleOf("recipient" to input_amout.text.toString())
                        navController!!.navigate(
                        R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle
                    )
                }
                else{
                    Toast.makeText(activity, "Enter an recipient", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> activity!!.onBackPressed()
        }

    }
}