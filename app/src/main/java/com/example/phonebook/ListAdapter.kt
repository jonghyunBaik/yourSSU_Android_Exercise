package com.example.phonebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

//custom ListView를 위한 adaptar 정의
class ListAdapter(val context: Context, val phoneList: ArrayList<phoneList>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_tile, null)

        /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
        val name = view.findViewById<TextView>(R.id.nameText)
        val number = view.findViewById<TextView>(R.id.numText)

        val phone = phoneList[position]
        name.text = phone.name
        number.text = phone.phone

        return view
    }

    override fun getItem(position: Int): Any {
        return phoneList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return phoneList.size
    }
}