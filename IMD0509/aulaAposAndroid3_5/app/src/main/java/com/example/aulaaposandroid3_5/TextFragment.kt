package com.example.aulaaposandroid3_5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TextFragment : Fragment(){
    private var txtMsg : TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        var v : View = inflater.inflate(R.layout.fragment_text, container, false)
        txtMsg  = v.findViewById(R.id.txt_Msg)
        return  v
    }

    fun setMsgText( txt : String){
        txtMsg?.text = txt
    }
}