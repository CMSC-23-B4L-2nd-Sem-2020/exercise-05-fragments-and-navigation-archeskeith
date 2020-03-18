package com.example.lightsout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.lightsout.databinding.GameWonFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class GameWon: Fragment() {
    private lateinit var binding: GameWonFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<GameWonFragmentBinding>(inflater,
            R.layout.game_won_fragment,container,false)

        binding.finalScore.text = this.arguments?.get("score").toString()
        binding.finalButton.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.action_gameWon_to_titleFragment)

        }

        return binding.root
    }

}


