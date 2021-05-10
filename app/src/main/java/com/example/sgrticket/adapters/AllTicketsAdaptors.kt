package com.example.sgrticket.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sgrticket.R
import com.example.sgrticket.models.Ticket

class AllTicketsAdaptors(val tickets: ArrayList<Ticket>) : RecyclerView.Adapter<AllTicketsAdaptors.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtPassengerName: TextView = view.findViewById(R.id.customerName)
        val txtSourceFrom: TextView = view.findViewById(R.id.txtSource)
        val txtDestinationTo: TextView = view.findViewById(R.id.txtDestination)
        val txtTicketNumber: TextView = view.findViewById(R.id.ticketNumber)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.tickets_row, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = tickets[position]
        holder.txtPassengerName.text = currentItem.name
        holder.txtSourceFrom.text = currentItem.source
        holder.txtDestinationTo.text = currentItem.destination

    }

    override fun getItemCount() = tickets.size
}