package com.arim.trotapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class YoungtakFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val song_list = mutableListOf<String>()
        song_list.add("그런노래")
        song_list.add("그런노래")
        song_list.add("그런노래")
        song_list.add("그런노래")
        song_list.add("그런노래")
        song_list.add("그런노래")
        song_list.add("그런노래")
        song_list.add("그런노래")

        val view = inflater.inflate(R.layout.fragment_youngtak, container, false)
        val list_container = view.findViewById<RecyclerView>(R.id.youngtakSong_rvlist)
        val list_rvAdapter = rvAdapter(song_list)



        view.findViewById<ImageView>(R.id.gain_imageBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_youngtakFragment_to_gainFragment)
        }

        view.findViewById<ImageView>(R.id.youngong_imageBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_youngtakFragment_to_youngongFragment)
        }

        list_container.adapter = list_rvAdapter
        list_container.layoutManager = LinearLayoutManager(context)


        return view
    }


}