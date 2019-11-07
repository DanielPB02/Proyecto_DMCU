package com.example.proyecto_dmcu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView

/**
 * A simple [Fragment] subclass.
 */
class TutorialsFragment : Fragment() {


    var adapter: MyAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_tutorials, container, false)



    }

    fun getList():List<Model>{



        var list=mutableListOf<Model>()
        list.add(Model("Consejos para principiantes", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.persona))
        list.add(Model("Sembrado de frutas", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.fresa))
        list.add(Model("Sembrado de flores", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.flor))
        list.add(Model("Sembrado de verduras", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.zanahorias))

        return list
    }
    fun getList2():List<Model>{



        var list=mutableListOf<Model>()
        list.add(Model("unachingadera", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.persona))
        list.add(Model("unachingadera", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.persona))
        list.add(Model("unachingadera", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.persona))
        list.add(Model("unachingadera", "Lorem impsum dolor sit met, consectur adipiscing elit.", R.drawable.persona))

        return list
    }


}
