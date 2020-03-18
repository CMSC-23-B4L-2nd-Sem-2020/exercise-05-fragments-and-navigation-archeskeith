package com.example.lightsout

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.lightsout.databinding.FragmentTitleBinding
import com.example.lightsout.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.game_fragment.*
import kotlinx.android.synthetic.main.game_fragment.view.*

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {
    var counter:Int = 0
    private lateinit var binding: GameFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<GameFragmentBinding>(inflater,
            R.layout.game_fragment,container,false)
//        val navController = this.findNavController(R.id.myNavHostFragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)
//        NavigationUI.setupWithNavController(binding.navView, navController)
//        nickname.visibility = View.VISIBLE

        binding.apply{
//            doneButton.setOnClickListener{
//                addNickname(it)
//            }
            nicknameEdit.setOnClickListener{
                updateNickname(it)
            }

            retryButton.setOnClickListener{makeBlackAgain()}



        }
        binding.nickname.text = this.arguments?.get("name").toString()
//        nickname.visibility = View.VISIBLE

        setListeners()

//        val retry: Button = findViewById(R.id.retry_button)
//        retry.setOnClickListener{makeBlackAgain()}


        return binding.root
    }

//    private fun addName(view: View){
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.textView2)
//        nicknameTextView.text = editText.text
//
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE
//
//    }


    private fun makeBlackAgain(){
        box_one_text.setBackgroundColor(Color.WHITE); box_one_text5.setBackgroundColor(Color.WHITE);
        box_five_text5.setBackgroundColor(Color.WHITE); box_five_text.setBackgroundColor(Color.WHITE)
        box_two_text.setBackgroundColor(Color.WHITE); box_three_text.setBackgroundColor(Color.WHITE)
        box_four_text.setBackgroundColor(Color.WHITE); box_one_text9.setBackgroundColor(Color.WHITE)
        box_two_text7.setBackgroundColor(Color.WHITE); box_three_text7.setBackgroundColor(Color.WHITE)
        box_four_text7.setBackgroundColor(Color.WHITE); box_five_text7.setBackgroundColor(Color.WHITE)
        box_one_text11.setBackgroundColor(Color.WHITE); box_two_text9.setBackgroundColor(Color.WHITE)
        box_three_text9.setBackgroundColor(Color.WHITE); box_four_text9.setBackgroundColor(Color.WHITE)
        box_five_text9.setBackgroundColor(Color.WHITE); box_one_text10.setBackgroundColor(Color.WHITE)
        box_two_text8.setBackgroundColor(Color.WHITE); box_three_text8.setBackgroundColor(Color.WHITE)
        box_four_text8.setBackgroundColor(Color.WHITE); box_five_text8.setBackgroundColor(Color.WHITE)
        box_two_text5.setBackgroundColor(Color.WHITE); box_three_text5.setBackgroundColor(Color.WHITE)
        box_four_text5.setBackgroundColor(Color.WHITE)
        counter = 0
//        val pointsText : TextView = findViewById(R.id.textView)
//        pointsText.text = counter.toString();
        binding.apply{
            textView.text = counter.toString();
        }

    }

    private fun applyColor(box:View){
        val cd = box.background as ColorDrawable
        val colorCode = cd.color

        if (colorCode == Color.BLACK){
            box.setBackgroundColor(Color.WHITE)
        }else if (colorCode == Color.WHITE){
            box.setBackgroundColor(Color.BLACK)
        }

    }

    private fun makeColored(view:View){

//        val pointsText : TextView = findViewById(R.id.textView)


        //i am assuming that this is the if function when it's clicked
        when (view.id){

            R.id.box_one_text -> {applyColor(box_one_text); applyColor(box_one_text9); applyColor(box_two_text); counter++;}
            R.id.box_one_text5 -> {applyColor(box_one_text10); applyColor(box_two_text5); applyColor(box_one_text5);counter++;}
            R.id.box_five_text5 -> {applyColor(box_five_text5); applyColor(box_four_text5);applyColor(box_five_text8);counter++;}
            R.id.box_five_text -> {applyColor(box_five_text); applyColor(box_five_text7); applyColor(box_four_text);counter++;}

            R.id.box_two_text -> {applyColor(box_one_text); applyColor(box_two_text); applyColor(box_two_text7); applyColor(box_three_text);counter++;}
            R.id.box_three_text -> {applyColor(box_three_text); applyColor(box_two_text); applyColor(box_three_text7); applyColor(box_four_text);counter++;}
            R.id.box_four_text -> {applyColor(box_four_text); applyColor(box_three_text); applyColor(box_four_text7); applyColor(box_five_text);counter++;}

            R.id.box_one_text9 -> {applyColor(box_one_text9); applyColor(box_one_text); applyColor(box_one_text11); applyColor(box_two_text7);counter++;}
            R.id.box_two_text7 -> {applyColor(box_two_text7); applyColor(box_one_text9); applyColor(box_two_text); applyColor(box_two_text9); applyColor(box_three_text7);counter++;}
            R.id.box_three_text7 -> {applyColor(box_three_text7); applyColor(box_two_text7); applyColor(box_three_text); applyColor(box_four_text7); applyColor(box_three_text9);counter++;}
            R.id.box_four_text7 -> {applyColor(box_four_text7); applyColor(box_three_text7); applyColor(box_four_text);applyColor(box_five_text7); applyColor(box_four_text9);counter++;}
            R.id.box_five_text7 -> {applyColor(box_five_text7); applyColor(box_four_text7); applyColor(box_five_text9); applyColor(box_five_text);counter++;}

            R.id.box_one_text11 -> {applyColor(box_one_text11); applyColor(box_two_text9); applyColor(box_one_text9); applyColor(box_one_text10);counter++;}
            R.id.box_two_text9 -> {applyColor(box_two_text9); applyColor(box_one_text11); applyColor(box_two_text7); applyColor(box_three_text9); applyColor(box_two_text8);counter++;}
            R.id.box_three_text9 -> {applyColor(box_three_text9); applyColor(box_two_text9); applyColor(box_three_text7); applyColor(box_four_text9);applyColor(box_three_text8);counter++;}
            R.id.box_four_text9 -> {applyColor(box_four_text9); applyColor(box_three_text9); applyColor(box_four_text7); applyColor(box_five_text9); applyColor(box_four_text8);counter++;}
            R.id.box_five_text9 -> {applyColor(box_five_text9); applyColor(box_four_text9); applyColor(box_five_text7); applyColor(box_five_text8);counter++;}

            R.id.box_one_text10 -> {applyColor(box_one_text10); applyColor(box_one_text11); applyColor(box_two_text8); applyColor(box_one_text5);counter++;}
            R.id.box_two_text8 -> {applyColor(box_two_text8); applyColor(box_one_text10); applyColor(box_two_text9); applyColor(box_three_text8); applyColor(box_two_text5);counter++;}
            R.id.box_three_text8 -> {applyColor(box_three_text8); applyColor(box_two_text8); applyColor(box_three_text9); applyColor(box_four_text8); applyColor(box_three_text5);counter++;}
            R.id.box_four_text8 -> {applyColor(box_four_text8); applyColor(box_three_text8); applyColor(box_four_text9); applyColor(box_five_text8); applyColor(box_four_text5);counter++;}
            R.id.box_five_text8 -> {applyColor(box_five_text8); applyColor(box_four_text8); applyColor(box_five_text9); applyColor(box_five_text5);counter++;}

            R.id.box_two_text5 -> {applyColor(box_two_text5); applyColor(box_one_text5); applyColor(box_two_text8); applyColor(box_three_text5);counter++;}
            R.id.box_three_text5 -> {applyColor(box_three_text5); applyColor(box_two_text5); applyColor(box_three_text8); applyColor(box_four_text5);counter++;}
            R.id.box_four_text5 -> {applyColor(box_three_text5); applyColor(box_four_text5); applyColor(box_four_text8); applyColor(box_five_text5);counter++;}
            else-> view.setBackgroundColor(Color.LTGRAY);

        }
        binding.apply{
            textView.text = counter.toString();
        }

    }

    private fun setListeners() {
//        val boxOneText = findViewById<TextView>(R.id.box_one_text)
//        val boxOneText5 = findViewById<TextView>(R.id.box_one_text5)
//        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
//        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
//        val boxFourText = findViewById<TextView>(R.id.box_four_text)
//        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
//        val boxOneText9 = findViewById<TextView>(R.id.box_one_text9)
//        val boxTwoText7 = findViewById<TextView>(R.id.box_two_text7)
//        val boxThreeText7 = findViewById<TextView>(R.id.box_three_text7)
//        val boxFourText7 = findViewById<TextView>(R.id.box_four_text7)
//        val boxFiveText7 = findViewById<TextView>(R.id.box_five_text7)
//        val boxOneText11 = findViewById<TextView>(R.id.box_one_text11)
//        val boxTwoText9 = findViewById<TextView>(R.id.box_two_text9)
//        val boxThreeText9 = findViewById<TextView>(R.id.box_three_text9)
//        val boxFourText9 = findViewById<TextView>(R.id.box_four_text9)
//        val boxFiveText9 = findViewById<TextView>(R.id.box_five_text9)
//        val boxFiveText5 = findViewById<TextView>(R.id.box_five_text5)
//        val boxOneText10 = findViewById<TextView>(R.id.box_one_text10)
//        val boxTwoText8 = findViewById<TextView>(R.id.box_two_text8)
//        val boxThreeText8 = findViewById<TextView>(R.id.box_three_text8)
//        val boxFourText8 = findViewById<TextView>(R.id.box_four_text8)
//        val boxFiveText8 = findViewById<TextView>(R.id.box_five_text8)
//        val boxTwoText5 = findViewById<TextView>(R.id.box_two_text5)
//        val boxThreeText5 = findViewById<TextView>(R.id.box_three_text5)
//        val boxFourText5 = findViewById<TextView>(R.id.box_four_text5)
//        counter = findViewById<TextView>(R.id.textView)


        binding.apply{
            textView.text = counter.toString()
            val clickableViews: List<View> =
                listOf(boxOneText, boxOneText5, boxTwoText, boxThreeText,
                    boxFourText, boxFiveText, boxOneText9, boxTwoText7, boxThreeText7,
                    boxFourText7, boxFiveText7, boxOneText11, boxTwoText9, boxThreeText9,
                    boxFourText9,boxFiveText9,boxFiveText5, boxOneText10, boxTwoText8, boxThreeText8, boxFourText8,
                    boxFiveText8, boxTwoText5, boxThreeText5, boxFourText5)

            for (item in clickableViews) {
                item.setOnClickListener { makeColored(it) }
            }
        }



    }
//
//    private fun addNickname(view: View) {
////        val editText = findViewById<EditText>(R.id.nickname_edit)
////        val nicknameTextView = findViewById<TextView>(R.id.nickname)
//        binding.apply{
////            nickname.text = nicknameEdit.text.toString()
////            nicknameEdit.visibility = View.GONE
//
//            nickname.visibility = View.VISIBLE
////            view.visibility = View.GONE
//
////            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
////            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
//        }
//
//
////        nicknameTextView.text = editText.text
////        editText.visibility = View.GONE
////        view.visibility = View.GONE
////        nicknameTextView.visibility = View.VISIBLE
//
//    }

    private fun updateNickname (view: View) {
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val doneButton = findViewById<Button>(R.id.done_button)
        
        binding.apply{
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            view.visibility = View.GONE
        }
//        editText.visibility = View.VISIBLE
//        doneButton.visibility = View.VISIBLE
//        view.visibility = View.GONE

        // Keyboard
//        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.showSoftInput(editText, 0)

    }
}
