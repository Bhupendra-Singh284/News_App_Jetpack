package com.example.news_app_jetpack_compose_mvvm.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.news_app_jetpack_compose_mvvm.domain.model.Source


@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun sourceToString(source: Source):String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(string:String):Source{
        return  string.split(',').let{
            stringArray->
            Source(stringArray[0],stringArray[1])
        }
    }
}