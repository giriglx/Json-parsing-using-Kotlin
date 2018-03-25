package com.example.giri.jsonparsinginkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_row.view.*

/**
 * Created by giri on 26/3/18.
 */
class Adaptor(val json:MainActivity.Json): RecyclerView.Adapter<CustomViewHolder>() {
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val contact=json.contacts.get(position)
        holder?.view?.tvName?.text = contact.name
    }

    override fun getItemCount(): Int {

        return json.contacts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_row, parent, false)
        return CustomViewHolder(cellForRow)
    }
}
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}