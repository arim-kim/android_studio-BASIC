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


class GainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val song_list = mutableListOf<String>()

        song_list.add("저런 노래")
        song_list.add("이러 노래")
        song_list.add("그런 노래")
        song_list.add("저런 노래")
        song_list.add("이러 노래")
        song_list.add("그런 노래")
        song_list.add("저런 노래")
        song_list.add("이러 노래")
        song_list.add("그런 노래")


        val view = inflater.inflate(R.layout.fragment_gain, container, false)

        val list_container = view.findViewById<RecyclerView>(R.id.gainSong_rvlist)
        val list_rvAdapter = rvAdapter(song_list)



        // nav 버튼 클릭 이벤트

        view.findViewById<ImageView>(R.id.youngong_imageBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_gainFragment_to_youngongFragment)
        }

        view.findViewById<ImageView>(R.id.youngtak_imageBtn).setOnClickListener {
            it.findNavController().navigate(R.id.action_gainFragment_to_youngtakFragment)
        }

        // 어댑터 연결
        list_container.adapter = list_rvAdapter
        list_container.layoutManager = LinearLayoutManager(context) // 필수

        return view
    }


}