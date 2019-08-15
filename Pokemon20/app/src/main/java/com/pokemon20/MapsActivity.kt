package com.pokemon20

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

import  android.Manifest
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.lang.Exception
import kotlin.random.Random
import kotlin.random.Random.Default.nextDouble


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        checkPermission()
    }

    var ACCESSLOCATION=123
    fun checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "here", Toast.LENGTH_SHORT).show()
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), ACCESSLOCATION)
                return
            }
        }

        getUserLocation()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when (requestCode) {

            ACCESSLOCATION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getUserLocation()
                } else {
                    Toast.makeText(this, "we cannot access your location", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun getUserLocation(){
        //Toast.makeText(this," User location access on", Toast.LENGTH_SHORT).show()


        var locationManager= getSystemService(Context.LOCATION_SERVICE) as LocationManager

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f,MyLocationListener())

        var myThread=myThread(locationManager)
        myThread.start()

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    var location:Location?=null
    //get user location
    inner class MyLocationListener:LocationListener {


        constructor(){
            location=Location("Start")
            location!!.longitude=0.0
            location!!.latitude=0.0
        }
        override fun onLocationChanged(p0: Location?) {
          location=p0
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderEnabled(p0: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderDisabled(p0: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }




    inner class myThread:Thread{

        constructor(locMan: LocationManager):super() {

          loadPokemon(locMan)
      }


        override fun run(){


            var oneTime=0
            while(true){

                try{

                    runOnUiThread {

                        var locMan= getSystemService(Context.LOCATION_SERVICE) as LocationManager

                        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER,3,3f,MyLocationListener())

                        mMap.clear()
                        val sydney = LatLng(locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER).latitude,
                            locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER).longitude)
                        mMap.addMarker(
                            MarkerOptions().position(sydney).title("Me").snippet("here is my location").icon(
                                BitmapDescriptorFactory.fromResource(R.drawable.mario)
                            )
                        )
                        if(oneTime++==0)mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14f))


                        //show pokemons

                        for (i in listPokemons){
                            if(i.isCatched==false){

                                val pokemonLoc = LatLng(i.location!!.latitude, i.location!!.longitude)
                                mMap.addMarker(
                                    MarkerOptions().position(pokemonLoc).title(i.name).snippet(i.des!!+",power:"+i!!.power).icon(
                                        BitmapDescriptorFactory.fromResource(i.image!!)))

                                location!!.set(locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER))
                                if(location!!.distanceTo(i.location)<2){
                                    i.isCatched=true
                                    playerPower+=i.power!!
                                    Toast.makeText(applicationContext,"You catched a pokemon. Your new power is "+playerPower,Toast.LENGTH_LONG).show()



                                }

                            }

                        }
                    }
                    sleep(1000)

                }catch (ex:Exception){}

            }
        }
    }

    var playerPower:Double=0.0
    var listPokemons=ArrayList<Pokemon>()

    fun loadPokemon(locMan: LocationManager){


        listPokemons.add(Pokemon(
            "Charmander", "Charmander living in japan",R.drawable.charmander, 55.0, randomizerLat(locMan), randomizerLong(locMan)))
        listPokemons.add(Pokemon(
            "Bulbasaur", "Bulbasaur living in usa",R.drawable.bulbasaur, 90.5, randomizerLat(locMan), randomizerLong(locMan)))
        listPokemons.add(Pokemon(
            "Squirtle", "Squirtle living in iraq",R.drawable.squirtle, 33.5, randomizerLat(locMan), randomizerLong(locMan)))


    }
    fun randomizerLat(locMan: LocationManager): Double {


        return locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER).latitude + nextDouble(-0.0002, 0.0002)
    }
     fun randomizerLong(locMan: LocationManager): Double {


         return locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER).longitude+ nextDouble(-0.0002, 0.0002) //+ nextDouble(-0.05, 0.05)
     }

}


