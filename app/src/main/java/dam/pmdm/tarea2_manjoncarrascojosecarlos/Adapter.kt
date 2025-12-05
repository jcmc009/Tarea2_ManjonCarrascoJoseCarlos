package dam.pmdm.tarea2_manjoncarrascojosecarlos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.pmdm.tarea2_manjoncarrascojosecarlos.databinding.CharacterItemBinding

class Adapter(
    private val characterList: List<CharacterToShow>,
    private val onClick: (CharacterToShow) -> Unit
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bin(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    //View holder class
    inner class MyViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bin(character: CharacterToShow) {
            // binding.characterName.text = character.name
            binding.characterName.setText(character.name)
            binding.characterImage.setImageResource(character.getImage())
            binding.root.setOnClickListener {
                onClick(character)
            }
        }


    }
}