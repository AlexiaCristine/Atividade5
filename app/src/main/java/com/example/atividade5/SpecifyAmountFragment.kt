package com.example.atividade5

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.room.Room
import com.example.atividade5.Models.Record
import com.example.atividade5.database.AppDatabase
import com.example.atividade5.database.daos.RecordsDAO
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import kotlinx.android.synthetic.main.fragment_specify_amount.view.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var dao: RecordsDAO

    fun createDB() {
        //create DB instance
        val db = Room.databaseBuilder(
            requireActivity(),
            AppDatabase::class.java,
            "user-db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        //get DAO
        dao = db.recordsDao()
    }

    lateinit var navController: NavController
    lateinit var recipient: String


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        createDB()
        recipient = requireArguments().getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.next_btn.setOnClickListener {
            val amount = input_amout.text.toString().toFloat()
            val record = Record(1, amount,recipient, null,null)
            dao.insert(record)
            val bundle = Bundle()
            bundle.putString("recipient", recipient)
            bundle.putFloat("amount", amount)
            navController!!.navigate(
                R.id.action_specifyAmountFragment_to_confirmationFragment, bundle
            )
        }
        view.cancel_btn.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onClick(v: View?) {
//        when(v!!.id){
//            R.id.send_money_btn-> {
//                if(!TextUtils.isEmpty(input_amout.text.toString())){
//                    val amount = Money(BigDecimal(input_amout.text.toString()))
//                    val bundle = bundleOf(
//                        "recipient" to recipient,
//                        "amount" to amount
//                    )
//                    navController!!.navigate(
//                        R.id.action_specifyAmountFragment_to_confirmationFragment,
//                        bundle
//                    )
//                }
//                else{
//                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            R.id.cancel_btn -> requireActivity().onBackPressed()
//        }
    }
}