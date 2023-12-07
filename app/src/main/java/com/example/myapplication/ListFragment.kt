package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private val list = arrayListOf<Character>(
        Character("https://nucarnival.com/static/d21063a7d97ef6eec3918e36066bf4f0/517e6/yakumo_face1.webp", "Yakumo", "I don't want to... be all alone again... I want to become stronger... so that I can protect Mr Eiden and the others..."),
        Character("https://nucarnival.com/static/7d3e6866d4ec1f9806e3676b6a3f387d/517e6/kuya_face1.webp", "Kuya", "Hehe... I wonder what special tricks you'll have to please me in the future. I'll be waiting most expectantly."),
        Character("https://nucarnival.com/static/0bdb761037ebb4ed631d9dd8ed924346/517e6/edmond_face1.webp", "Edmond", "I swear on my honor... to pledge my life to the protection of the kingdom."),
        Character("https://nucarnival.com/static/2dd0f52450438cbaaa55631f2847b2ea/517e6/olivine_face1.webp", "Olivine", "Worship me...? That's a bit of an exaggeration... This is just proof of everyone's undying faith in the God of Klein."),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacterAdapter(list, this::onClick)
        binding.rv.adapter = adapter
    }

    private fun onClick(position: Int) {
        val bundle = Bundle()
        val sf = SecondFragment()

        bundle.putString("key", list[position].img)
        bundle.putString("key2", list[position].title)
        bundle.putString("key3", list[position].desc)

        sf.arguments = bundle

        findNavController().navigate(R.id.secondFragment,bundle)
    }

}