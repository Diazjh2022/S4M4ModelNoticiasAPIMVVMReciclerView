package com.example.s4m4modelnoticiasapimvvmreciclerview.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s4m4modelnoticiasapimvvmreciclerview.databinding.ActivityMainBinding
import com.example.s4m4modelnoticiasapimvvmreciclerview.repository.recycler.AdaptadorRecycler
import com.example.s4m4modelnoticiasapimvvmreciclerview.viewmodel.ViewModel



class MainActivity : AppCompatActivity() {

    //viewmodel
    private lateinit var mainViewModel: ViewModel

    //viewbinding
    private lateinit var binding: ActivityMainBinding

    //recyclerview
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var adaptador:AdaptadorRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewmodel
        mainViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        observar() //viewmodel observer

        //recycler
        myRecyclerView = binding.myRecycler
        myRecyclerView.layoutManager =
            LinearLayoutManager(applicationContext,
                LinearLayoutManager.VERTICAL, false)

        //btnTraerNoticias
        binding.btnTraerNoticias.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.obBtnTraerNoticias()
        }
        binding.btncnn.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.obBtnCnn()
        }
        binding.btnbbc.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.obBtnBbc()
        }
        binding.btndeportes.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            mainViewModel.obBtndeportes()
        }

    }

    /**
     * observar livedata
     */
    private fun observar() {
        mainViewModel.noticias.observe(this, Observer {
            //binding.txtNoticias.text = "Noticias: \n"
            //binding.txtNoticias.append("${Gson().toJson(it)}")
            binding.progressBar.visibility = View.GONE

            adaptador = AdaptadorRecycler(applicationContext, it.data);
            myRecyclerView.adapter = adaptador

        })
    }


}