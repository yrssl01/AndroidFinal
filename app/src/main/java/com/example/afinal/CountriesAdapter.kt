package com.example.afinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.model.Countries

class CountriesAdapter(val context: Context, val countries: List<Countries>) : RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return CountriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        val country = countries[position]
        holder.country.text = country.Country
        holder.slug.text = country.Slug
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var country = itemView.findViewById<TextView>(R.id.tvCountry)
        var slug = itemView.findViewById<TextView>(R.id.tvSlug)
    }

}