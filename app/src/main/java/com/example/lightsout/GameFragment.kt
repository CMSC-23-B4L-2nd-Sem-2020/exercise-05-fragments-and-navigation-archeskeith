package com.example.lightsout

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
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
import androidx.core.os.bundleOf
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

    //the game fragment got all of its function codes from main activity (if compared to exer3)
    //the only difference this has are the navigation codes, and the binding implementations
    var counter:Int = 0
    var colorCounter = 0
    private lateinit var binding: GameFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding implementation
        binding = DataBindingUtil.inflate<GameFragmentBinding>(inflater,
            R.layout.game_fragment,container,false)


        binding.apply{

            retryButton.setOnClickListener{makeBlackAgain()}

        }
        binding.nickname.text = this.arguments?.get("name").toString()


        setListeners()

        return binding.root
    }


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

        binding.apply{
            textView.text = counter.toString();
        }
        colorCounter = 0

    }

    private fun applyColor(box:View){

        val cd = box.background as ColorDrawable
        val colorCode = cd.color

        if (colorCode == Color.BLACK){
            box.setBackgroundColor(Color.WHITE)
            colorCounter--
        }else if (colorCode == Color.WHITE){
            box.setBackgroundColor(Color.BLACK)
            colorCounter++
        }

    }

    private fun makeColored(view:View){


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
        if (colorCounter == 25){
                //navigating to gameWon Fragment and acquiring score /number of clicks
                view?.findNavController()?.navigate(R.id.action_gameFragment_to_gameWon,bundleOf("score" to counter))
        }

    }

    private fun setListeners() {
        var colorCounter = 0;
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

//        // Keyboard
////        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
////        imm.showSoftInput(editText, 0)

}
