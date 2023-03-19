package com.example.phonebook

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.phonebook.databinding.FragmentListBinding

class ListFrag : Fragment() {
    // TODO: Rename and change types of parameters

    //viewModel 선언
    private val viewModel: ViewModel by activityViewModels()
    //fragment_list.xml 바인딩
    lateinit var binding : FragmentListBinding

    var phoneList = mutableListOf<phoneList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)

        //viewModel에 데이터 받아옴.
        for(i: Int in 0 .. viewModel.getSize()) {
            phoneList.add(phoneList(viewModel.getName(i), viewModel.getPhone(i)))
        }

        //listview에 adapter 출력
        val phoneAdapter = context?.let { ListAdapter(it, phoneList as ArrayList<phoneList>) }
        binding.listView.adapter = phoneAdapter
        // Inflate the layout for this fragment
        return binding.root
    }
}