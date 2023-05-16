package com.example.autodatos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.autodatos.R
import android.widget.TextView
import com.example.autodatos.database.AppDatabase
import com.example.autodatos.database.UserDao
import com.example.autodatos.entities.User

class  editpanel : Fragment() {

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
*/  lateinit var txtTile : TextView
    lateinit var v : View

    private var db: AppDatabase? = null
    private var userDao: UserDao? = null

    private lateinit var edtName: EditText
    private lateinit var edtCar: EditText
    private lateinit var edtFalla: EditText

    private lateinit var btnAdd: Button
    private lateinit var btnDelete: Button
    private lateinit var btnEdit: Button
    private lateinit var btnSearch: Button

    private lateinit var userList: MutableList<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_editpanel, container, false)
        edtName = v.findViewById(R.id.edt_Name)
        edtCar = v.findViewById(R.id.edt_Car)
        edtFalla = v.findViewById(R.id.edt_Falla)
        btnAdd = v.findViewById(R.id.btn_Add)
        btnDelete = v.findViewById(R.id.btn_Delete)
        btnEdit = v.findViewById(R.id.btn_Edit)
        btnSearch = v.findViewById(R.id.btn_Search)
        //txtTile = v.findViewById(R.id.textView_edit)
        //txtTile.text = "editfragment"

        return v
    }

    override fun onStart() {
        super.onStart()

        db = AppDatabase.getInstance(v.context)
        userDao = db?.userDao()


        // Dummy call to pre-populate db
        userDao?.fetchAllUsers()

        btnAdd.setOnClickListener {
            userDao?.insertUser(User(0, edtName.text.toString(), edtCar.text.toString(),edtFalla.text.toString()))
        }

        btnDelete.setOnClickListener {
            userDao?.delete(User(1, "", "",""))
        }

        btnEdit.setOnClickListener {
            userDao?.updateUser(User(1, "Juan", "Ford","Platino"))
        }

        btnSearch.setOnClickListener {
            Log.d("Test", userDao?.fetchUserById(1)?.name.toString())

            userList = userDao?.fetchAllUsers() as MutableList<User>

            for (actualUser in userList) {
                Log.d("Test", actualUser.name)
            }
        }
/*
        btnDebug.setOnClickListener {
            RoomExplorer.show(context, AppDatabase::class.java, "myDB")
        }*/
    }

}