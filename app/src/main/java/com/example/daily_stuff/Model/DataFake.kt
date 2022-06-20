package com.example.daily_stuff.Model

class DataFake private constructor() {
    var todoDao = TodoData()
        private set

    companion object{
        @Volatile private var instance:DataFake? = null

        fun instanceGet() = instance?: synchronized(this){
            instance ?: DataFake().also { instance = it }
        }
    }
}