/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.data.DataSource
import java.lang.IllegalArgumentException

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int


): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource
    var data = DataSource.dogs



    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // TODO: Declare and initialize all of the list item UI components


        val imageView : ImageView = view.findViewById(R.id.iv_dog_image)
        val txt_dog_name : TextView = view.findViewById(R.id.txt_dog_name)
        val txt_dog_age : TextView = view.findViewById(R.id.txt_dog_age)
        val txt_dog_hobbies : TextView = view.findViewById(R.id.txt_dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.

        val viewLayout = when(layout){
            1 -> R.layout.vertical_horizontal_list_item
            2 -> R.layout.vertical_horizontal_list_item
            3 -> R.layout.grid_list_item
            else -> throw IllegalArgumentException("invalid type")
        }



        // TODO Inflate the layout

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(viewLayout, parent, false)
        return DogCardViewHolder(adapterLayout)

    }

    override fun getItemCount(): Int = data.size // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position

        val info = data[position]
        // TODO: Set the image resource for the current dog
        holder.imageView.setImageResource(info.imageResourceId)



        // TODO: Set the text for the current dog's name
        // TODO: Set the text for the current dog's age

        val resources = context?.resources
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        if (resources != null) {
            holder.txt_dog_age.text = resources.getString(R.string.dog_age,info.age)
            holder.txt_dog_name.text = info.name
            holder.txt_dog_hobbies.text = resources.getString(R.string.dog_hobbies,info.hobbies)
        }
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
