package com.example.movie.ui.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.databinding.CharacterItemBinding
import com.example.movie.model.BBCharacter
import java.text.FieldPosition

class CharacterListAdapter (private val list:MutableList<BBCharacter> = mutableListOf<BBCharacter>(),
    private val openDetails: ((BBCharacter) -> Unit)
        ) :RecyclerView.Adapter<CharacterListAdapter.CharacterViewModelHolder>() {

   /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewModelHolder {
        return CharacterViewModelHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewModelHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        holder.itemView.setOnClickListener { clickCallback?.invoke(character) }
    */

    fun setCharacterList(newList: List<BBCharacter>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    inner class CharacterViewModelHolder(private val binding:CharacterItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(bbCharacter: BBCharacter){
          Glide.with(binding.userImage).load(bbCharacter.img).into(binding.userImage)
            binding.userName.text = bbCharacter.name
            binding.userNickName.text = bbCharacter.nickname
            binding.userStatus.text = bbCharacter.status

            binding.userOccupation.text = bbCharacter.birthday.toString()
//            Glide.with(binding.ivListimageView).load(pokemonDb.image).into(binding.ivListimageView)
//            binding.tvPokeName.text= pokemonDb.name
            binding.root.setOnClickListener{
                openDetails(bbCharacter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewModelHolder {
      return  CharacterViewModelHolder(CharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewModelHolder, position: Int) {

        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
     return list.size
    }
}

//
//class CharactersComparator : DiffUtil.ItemCallback<BBCharacter>() {
//    override fun areItemsTheSame(oldItem: BBCharacter, newItem: BBCharacter): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: BBCharacter, newItem: BBCharacter): Boolean {
//        return oldItem.name == newItem.name &&
//                oldItem.nickname == newItem.nickname &&
//                oldItem.status ==  newItem.status &&
//                oldItem.img ==  newItem.img &&
//                oldItem.birthday == newItem.birthday //&&
//              //  oldItem.occupation.contentEquals(newItem.occupation)
//
//    }
//}
//
//class CharacterViewModelHolder1(itemView: View) : RecyclerView.ViewHolder(itemView){
//    private val nameTextView: TextView =  itemView.findViewById(R.id.NametextView)
//    private val nicknametextview: TextView =  itemView.findViewById(R.id.NickanameTextview)
//    private val statustextview: TextView =  itemView.findViewById(R.id.statusTextView)
//    private val birthdaytextview: TextView = itemView.findViewById(R.id.birthdayTexView)
//    private val ocuppationtextview: TextView = itemView.findViewById(R.id.occupationTextView)
//    private val imageview: ImageView = itemView.findViewById(R.id.imageView)
//
//    fun bind(character: BBCharacter){
//        nameTextView.text = character.name
//        nicknametextview.text = character.nickname
//        statustextview.text = character.status
//        birthdaytextview.text = character.birthday.toString()
//        //  ocuppationtextview.text =  character.
//
//        if (character.img != null) {
//            Glide.with (itemView).load(character.img).centerCrop().into(imageview)
//        }
//    }

//                companion object {
//                    fun create (parent: ViewGroup): CharacterViewModelHolder{
//                        val view: View = LayoutInflater.from(parent.context)
//                            .inflate(R.layout.character_item, parent, false)
//                        return CharacterViewModelHolder(view)
//                    }
//                }
//}