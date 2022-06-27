package com.example.Notes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Notes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), inotesadap {

//    companion object{
//        const val REPLIED_INTENT = "reply failed"
//    }

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.recycleViewId.layoutManager = LinearLayoutManager(this)
        val madapter = RecyclAdapter(this,this)
        binding.recycleViewId.adapter = madapter

        viewModel = ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)


//        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result:ActivityResult->
//            if(result.resultCode == Activity.RESULT_OK){
//                val data: Intent? = result.data
//                val itemnote = data?.getStringExtra(REPLIED_INTENT)
//
//                if (itemnote != null) {
//                        viewModel.insertNote(Notes(itemnote))
//                    Toast.makeText(this, "Note Inserted", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
        val st = intent.getStringExtra("Note_data")

        if(st != null)
        viewModel.insertNote(Notes(st))

        viewModel.allnotes.observe(this) { list ->
            list?.let {
                madapter.updatelist(it)
            }
        }

        binding.fabPlusButton.setOnClickListener {

            val intent = Intent(this,newitemssaveactivity::class.java)
            startActivity(intent)
        }

    }

    override fun onitemclicked(note: Notes) {
       viewModel.deletnode(note)
        Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show()
    }

}