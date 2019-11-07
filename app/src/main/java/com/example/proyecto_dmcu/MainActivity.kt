package com.example.proyecto_dmcu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var homeFragment: HomeFragment
    lateinit var tutorialsFragment: TutorialsFragment
    lateinit var searchFragment: SearchFragment
    var listview: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.btm_nav)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.home -> {

                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.tutorials -> {
                    listview= findViewById (R.id.listView)
                    tutorialsFragment = TutorialsFragment()

                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, tutorialsFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                        var list=tutorialsFragment.getList()
                        listview!!.adapter = MyAdapter(this, R.layout.row, list)
                        listview!!.setOnItemClickListener{parent:AdapterView<*>, view:View, position:Int, id:Long->
                            if(position==0){
                                setContentView(R.layout.technics)
                            }
                            if(position==1){
                                setContentView(R.layout.technics)
                            }
                            if(position==2){
                                setContentView(R.layout.technics)
                            }
                            if(position==3){
                                setContentView(R.layout.technics)
                            }
                        }

                }
                R.id.search -> {

                    searchFragment = SearchFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, searchFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }
    }
}
