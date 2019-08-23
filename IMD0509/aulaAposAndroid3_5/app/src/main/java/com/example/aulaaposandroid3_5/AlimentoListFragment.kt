package com.example.aulaaposandroid3_5

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class AlimentoListFragment : ListFragment (){

    private var adapter : ArrayAdapter<Alimento>? = null
    private  var listener : onItemClickAlimento? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if ( context !is onItemClickAlimento){
            throw  RuntimeException( " Não é OnItemClickAlimento ")
        }

        listener = context
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1)

        // Acessando os nomes de values.string xml
        var nomes = requireActivity().resources.getStringArray(R.array.alimentos_nomes)

        var precos = requireActivity().resources.getStringArray(R.array.alimentos_precos)

        // Percorrendo os vetores nomes e preços para colocar no adapter
        for( i in nomes.indices){
            var alimento : Alimento = Alimento(nomes[i], precos[i].toDouble())
            adapter?.add(alimento)
        }


        listAdapter = adapter
    }


    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var alimento = adapter?.getItem(position)
        listener?.onClick(alimento!!)

    }

    interface  onItemClickAlimento {
        fun onClick(alimento : Alimento)
    }
}