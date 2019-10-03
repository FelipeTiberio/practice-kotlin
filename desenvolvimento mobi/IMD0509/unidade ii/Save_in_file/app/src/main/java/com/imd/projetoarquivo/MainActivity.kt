package com.imd.projetoarquivo

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.Error
import java.lang.Exception
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        salvar_button.setOnClickListener {

            if ( radio_group.checkedRadioButtonId == interna_radio.id){
                saveToIntenal()
                Toast.makeText(this, "Texto salvo", Toast.LENGTH_SHORT).show()
            }
            else if (radio_group.checkedRadioButtonId === externa_private_radio.id){
                saveToExtenal(true)
            }
            else if (externa_publico_radio.isActivated ){

            }else{
                Toast.makeText(this, " É necessário escolher uma das três opções.", Toast.LENGTH_SHORT).show()
            }

        }

        ler_button.setOnClickListener {
            if ( radio_group.checkedRadioButtonId == interna_radio.id){
                loadToIntenal()
            }
            else if (radio_group.checkedRadioButtonId === externa_private_radio.id){
                loadFromExternal(true)

            }
            else if (externa_publico_radio.isActivated ){

            }
            else{
                Toast.makeText(this, " É necessário escolher uma das três opções.", Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun saveInFile( arquivo : FileOutputStream, edit_txt : EditText){
        val lines = TextUtils.split( edit_txt.text.toString(), "\n")
        val write = PrintWriter(arquivo)

        for ( line in lines){
            write.println(line)
        }

        write.flush()
        write.close()
        arquivo.close()
    }

    private  fun  loadFromFile( arquivo :FileInputStream, textView: TextView){
        val reader = BufferedReader( InputStreamReader(arquivo))
        val sb = StringBuilder()

        do{
            val line = reader.readLine() ?: break
            if( sb.isNotEmpty()){
                sb.append('\n')
            }
            sb.append(line)

        }while (true)

        reader.close()
        arquivo.close()
        textView.text = sb.toString()
    }


    // Para a memoria interna

    private fun saveToIntenal(){
        try{
            val fos = openFileOutput("arquivo.txt", Context.MODE_PRIVATE)
            saveInFile(fos, main_editText)
        }catch (e :Exception){
            Log.e("ERRO_FILE", " Erro ao salvar o arquivo", e)
        }
    }

    private fun loadToIntenal(){
        try{
            val fos = openFileInput("arquivo.txt")
            loadFromFile(fos, text_save_textView)
        }catch (e :Exception){
            Log.e("ERRO_FILE", " Erro ao carregar o arquivo", e)
        }
    }

    // Salvar no cartão privado
    private fun getExternalDir(privateDir: Boolean){
        if (privateDir){
             getExternalFilesDir("SDCard/Android/data/com.imd.projetoarquivo/file")
        }else{
            Environment.getExternalStorageDirectory()
        }
    }

    private fun saveToExtenal(privateDir: Boolean){
        val state = Environment.getExternalStorageState()

        if(Environment.MEDIA_MOUNTED == state){
            val myDir =  getExternalFilesDir("SDCard/Android/data/com.imd.projetoarquivo/file")

            try {
                if (myDir?.exists() == false){
                    myDir.mkdir()
                }

                val txtFile =File(myDir , "arquivo.txt")

                if(!txtFile.exists()){
                    txtFile.createNewFile()
                }

                val fos = FileOutputStream(txtFile)
                saveInFile(fos, main_editText)
            }catch ( e :Exception){
                Log.e("ERRO_FILE", "Erro ao salvar o arquivo no cartão (private",e)
            }

        }else{
            Log.e("ERRO_FILE", "Não é possivel escrever no cartão (private")
        }
    }

    private fun loadFromExternal(privateDir: Boolean){

        val hasPermission = checkStoragePermisson(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            RC_STORAGE_PERMISSION)

        if (!hasPermission){
            return
        }

        val state = Environment.getExternalStorageState()

        if(Environment.MEDIA_MOUNTED == state ||
                Environment.MEDIA_MOUNTED_READ_ONLY == state){

            val myDir =  getExternalFilesDir("SDCard/Android/data/com.imd.projetoarquivo/file")

            if(myDir?.exists() == true){
                val txtFile = File(myDir , "arquivo.txt")

                if(txtFile.exists()){
                    try {
                        txtFile.createNewFile()
                        val fis = FileInputStream(txtFile)
                        loadFromFile(fis, text_save_textView)
                    }catch (e : Exception){
                        Log.e("ERRO_FILE",
                            " Não é possivel escreve no SD card",e)
                    }
                }
            }

        }else{
            Log.e("ERRO_FILE", "SD CARD indisponivel ")
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
       // super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){

            RC_STORAGE_PERMISSION -> if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permissão Concedida",
                    Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,
                    "Permissão negada", Toast.LENGTH_SHORT
                    ).show()
            }
        }

    }

    companion object{
        val RC_STORAGE_PERMISSION = 0
    }

    private  fun checkStoragePermisson( permission : String, requestCode: Int): Boolean{

        if(ActivityCompat.checkSelfPermission(this, permission)
                !=
            PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permission)){
                Toast.makeText(this,
                    "Você precisa habilitar a permissão para ler ou salvar o arquivo",
                    Toast.LENGTH_SHORT).show()
            }
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
            return  false
        }
        return true
    }


}
