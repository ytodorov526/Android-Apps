package com.pokemon20

import android.location.Location

class Pokemon {


        var name:String?=null
        var des:String?=null
        var image:Int?=null
        var power:Double?=null
        var isCatched:Boolean?=false
        var location:Location?=null

    constructor(name:String,des:String,image:Int,power:Double,lat:Double,long:Double){

        this.name=name
        this.des= des
        this.image=image
        this.power=power
        this.location= Location(name)
        this.location!!.latitude=lat
        this.location!!.longitude=long
        this.isCatched=false



    }

}
