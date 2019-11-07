package com.example.proyecto_dmcu


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList



/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment(), SearchView.OnQueryTextListener {

    lateinit var viewSearch: View
    lateinit var search: SearchView
    private var list: ListView? = null
    private var adapter: ListViewAdapter? = null
    private var editsearch: SearchView? = null
    private var plantList: Array<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        viewSearch = inflater.inflate(R.layout.fragment_search, container, false)
        search = viewSearch.findViewById(R.id.search)

        // Generate sample data

        plantList = arrayOf(
            "Sunflower",
            "Dandelion",
            "Rose",
            "Daisy",
            "Lily",
            "Tulip",
            "Delphinium",
            "Gardenia"
        )

        // Locate the ListView in listview_main.xml
        list = viewSearch.findViewById(R.id.listview) as ListView

        PlantsArrayList = ArrayList()

        for (i in plantList!!.indices) {
            val plantnames = Plants(plantList!![i])
            // Binds all strings into an array
            PlantsArrayList.add(plantnames)
        }

        // Pass results to ListViewAdapter Class
        adapter = ListViewAdapter(getActivity())

        // Binds the Adapter to the ListView
        list!!.adapter = adapter

        // Locate the EditText in listview_main.xml
        editsearch = viewSearch.findViewById(R.id.search) as SearchView
        editsearch!!.setOnQueryTextListener(this)

        list!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            /*
            Toast.makeText(
                getActivity(),
                PlantsArrayList[position].getPlantName(),
                Toast.LENGTH_SHORT
            ).show()
    */
            val nameP = PlantsArrayList[position].getPlantName();
            val intent = Intent(this.activity, PlantDetailsActivity::class.java)
            intent.putExtra("Name", nameP)
            startActivity(intent)
        }
        return viewSearch
    }

    override fun onQueryTextSubmit(query: String): Boolean {

        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        adapter!!.filter(newText)
        return false
    }

    companion object {
        var PlantsArrayList = ArrayList<Plants>()
    }

    }

