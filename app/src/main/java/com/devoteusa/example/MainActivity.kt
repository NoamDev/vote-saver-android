package com.devoteusa.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devoteusa.example.databinding.ActivityMainBinding
import com.devoteusa.devote.DeVoteJNI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        var pk = ByteArray(32);
        var sk = ByteArray(32);

        DeVoteJNI.generateVoterKeypair(pk, sk);
    }
}