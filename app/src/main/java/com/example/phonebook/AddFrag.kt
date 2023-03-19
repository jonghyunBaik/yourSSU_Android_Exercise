package com.example.phonebook

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.phonebook.databinding.FragmentAddBinding


class AddFrag : Fragment() {
    //fragment간 데이터 전달을 위한 viewModel 선언
    private val viewModel: ViewModel by activityViewModels()
    //fragment_add.xml 바인딩
    lateinit var binding : FragmentAddBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentAddBinding.inflate(inflater,container,false)

        admitBtn()
        // 3. 프래그먼트 레이아웃 뷰 반환
        return binding.root
    }

    // 등록버튼 터치시 실행 함수
    fun admitBtn() {
        binding.admitButton.setOnClickListener() {

            //textField text 받아와서 viewModel에 넘겨줌
            if(binding.nameET.text.toString() != "" && binding.phoneET.text.toString() != "") {
                viewModel.addUser(binding.nameET.text.toString(), binding.phoneET.text.toString())

                Toast.makeText(this.context, "등록되었습니다", Toast.LENGTH_SHORT).show()
                binding.nameET.text.clear()
                binding.phoneET.text.clear()
            } else {
                Toast.makeText(this.context, "입력을 완료해주세요", Toast.LENGTH_SHORT).show()

            }
        }
    }
}

