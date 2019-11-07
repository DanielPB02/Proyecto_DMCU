package com.example.proyecto_dmcu


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SearchView
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class TutorialsFragment : Fragment() {

    lateinit var viewTuto: View
    private var list: ListView? = null
    private var adapter: TutorialAdapter? = null
    private var tutos: Array<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewTuto = inflater.inflate(R.layout.fragment_tutorials, container, false)

        // Generate sample data

        tutos = arrayOf(
            "Consejos para principiantes",
            "Sembrado de frutas",
            "Sembrado de flores"
        )

        // Locate the ListView in listview_main.xml
        list = viewTuto.findViewById(R.id.listview) as ListView

        TutoArrayList = ArrayList()

        for (i in tutos!!.indices) {
            val tutoName = Tutoriales(tutos!![i])
            // Binds all strings into an array
            TutoArrayList.add(tutoName)
        }

        // Pass results to ListViewAdapter Class
        adapter = TutorialAdapter(getActivity())

        // Binds the Adapter to the ListView
        list!!.adapter = adapter

        list!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            /*
            Toast.makeText(
                getActivity(),
                PlantsArrayList[position].getPlantName(),
                Toast.LENGTH_SHORT
            ).show()
    */

            val nameP = TutoArrayList[position].getNombre();
            val intent = Intent(this.activity, VerTutorialesActivity::class.java)
            intent.putExtra("Name", nameP)
            startActivity(intent)
        }
        return viewTuto
    }

    companion object {
        var TutoArrayList = ArrayList<Tutoriales>()
    }


}
