package com.nikhijadhav.singaporepsi.models

import com.google.gson.annotations.SerializedName

data class Readings (
     @SerializedName("o3_sub_index")
     var o3SubIndex: O3SubIndex? ,
     @SerializedName("pm10_twenty_four_hourly")
     var pm10TwentyFourHourly: Pm10TwentyFourHourly? ,
     @SerializedName("pm10_sub_index")
     var pm10SubIndex: Pm10SubIndex? ,
     @SerializedName("co_sub_index")
     var coSubIndex: CoSubIndex? ,
     @SerializedName("pm25_twenty_four_hourly")
     var pm25TwentyFourHourly: Pm25TwentyFourHourly? ,
     @SerializedName("so2_sub_index")
     var so2SubIndex: So2SubIndex? ,
     @SerializedName("co_eight_hour_max")
     var coEightHourMax: CoEightHourMax? ,
     @SerializedName("no2_one_hour_max")
     var no2OneHourMax: No2OneHourMax? ,
     @SerializedName("so2_twenty_four_hourly")
     var so2TwentyFourHourly: So2TwentyFourHourly? ,
     @SerializedName("pm25_sub_index")
     var pm25SubIndex: Pm25SubIndex? ,
     @SerializedName("psi_twenty_four_hourly")
     var psiTwentyFourHourly: PsiTwentyFourHourly? ,
     @SerializedName("o3_eight_hour_max")
     var o3EightHourMax: O3EightHourMax? ){

     fun getReadingsDataFor(query:String):String{
          val finalString = "Readings for $query \n"
          when(query){
               "north"->{
                  return  finalString +
                            "o3_sub_index : "+ o3SubIndex!!.north+"\n"+
                            "pm10_twenty_four_hourly : "+ pm10TwentyFourHourly!!.north+"\n"+
                            "pm10_sub_index : "+ pm10SubIndex!!.north+"\n"+
                            "co_sub_index : "+ coSubIndex!!.north+"\n"+
                            "pm25_twenty_four_hourly : "+ pm25TwentyFourHourly!!.north+"\n"+
                            "so2_sub_index : "+ so2SubIndex!!.north+"\n"+
                            "co_eight_hour_max : "+ coEightHourMax!!.north+"\n"+
                            "no2_one_hour_max : "+ no2OneHourMax!!.north+"\n"+
                            "so2_twenty_four_hourly : "+ so2TwentyFourHourly!!.north+"\n"+
                            "pm25_sub_index : "+ pm25SubIndex!!.north+"\n"+
                            "psi_twenty_four_hourly : "+ psiTwentyFourHourly!!.north+"\n"+
                            "o3_eight_hour_max : "+ o3EightHourMax!!.north+"\n"
               }"south"->{
                  return  finalString +
                            "o3_sub_index : "+ o3SubIndex!!.south+"\n"+
                            "pm10_twenty_four_hourly : "+ pm10TwentyFourHourly!!.south+"\n"+
                            "pm10_sub_index : "+ pm10SubIndex!!.south+"\n"+
                            "co_sub_index : "+ coSubIndex!!.south+"\n"+
                            "pm25_twenty_four_hourly : "+ pm25TwentyFourHourly!!.south+"\n"+
                            "so2_sub_index : "+ so2SubIndex!!.south+"\n"+
                            "co_eight_hour_max : "+ coEightHourMax!!.south+"\n"+
                            "no2_one_hour_max : "+ no2OneHourMax!!.south+"\n"+
                            "so2_twenty_four_hourly : "+ so2TwentyFourHourly!!.south+"\n"+
                            "pm25_sub_index : "+ pm25SubIndex!!.south+"\n"+
                            "psi_twenty_four_hourly : "+ psiTwentyFourHourly!!.south+"\n"+
                            "o3_eight_hour_max : "+ o3EightHourMax!!.south+"\n"
               }"east"->{
                  return  finalString +
                            "o3_sub_index : "+ o3SubIndex!!.east+"\n"+
                            "pm10_twenty_four_hourly : "+ pm10TwentyFourHourly!!.east+"\n"+
                            "pm10_sub_index : "+ pm10SubIndex!!.east+"\n"+
                            "co_sub_index : "+ coSubIndex!!.east+"\n"+
                            "pm25_twenty_four_hourly : "+ pm25TwentyFourHourly!!.east+"\n"+
                            "so2_sub_index : "+ so2SubIndex!!.east+"\n"+
                            "co_eight_hour_max : "+ coEightHourMax!!.east+"\n"+
                            "no2_one_hour_max : "+ no2OneHourMax!!.east+"\n"+
                            "so2_twenty_four_hourly : "+ so2TwentyFourHourly!!.east+"\n"+
                            "pm25_sub_index : "+ pm25SubIndex!!.east+"\n"+
                            "psi_twenty_four_hourly : "+ psiTwentyFourHourly!!.east+"\n"+
                            "o3_eight_hour_max : "+ o3EightHourMax!!.east+"\n"
               }"west"->{
                  return  finalString +
                            "o3_sub_index : "+ o3SubIndex!!.west+"\n"+
                            "pm10_twenty_four_hourly : "+ pm10TwentyFourHourly!!.west+"\n"+
                            "pm10_sub_index : "+ pm10SubIndex!!.west+"\n"+
                            "co_sub_index : "+ coSubIndex!!.west+"\n"+
                            "pm25_twenty_four_hourly : "+ pm25TwentyFourHourly!!.west+"\n"+
                            "so2_sub_index : "+ so2SubIndex!!.west+"\n"+
                            "co_eight_hour_max : "+ coEightHourMax!!.west+"\n"+
                            "no2_one_hour_max : "+ no2OneHourMax!!.west+"\n"+
                            "so2_twenty_four_hourly : "+ so2TwentyFourHourly!!.west+"\n"+
                            "pm25_sub_index : "+ pm25SubIndex!!.west+"\n"+
                            "psi_twenty_four_hourly : "+ psiTwentyFourHourly!!.west+"\n"+
                            "o3_eight_hour_max : "+ o3EightHourMax!!.west+"\n"
               }"central"->{
                  return  finalString +
                            "o3_sub_index : "+ o3SubIndex!!.central+"\n"+
                            "pm10_twenty_four_hourly : "+ pm10TwentyFourHourly!!.central+"\n"+
                            "pm10_sub_index : "+ pm10SubIndex!!.central+"\n"+
                            "co_sub_index : "+ coSubIndex!!.central+"\n"+
                            "pm25_twenty_four_hourly : "+ pm25TwentyFourHourly!!.central+"\n"+
                            "so2_sub_index : "+ so2SubIndex!!.central+"\n"+
                            "co_eight_hour_max : "+ coEightHourMax!!.central+"\n"+
                            "no2_one_hour_max : "+ no2OneHourMax!!.central+"\n"+
                            "so2_twenty_four_hourly : "+ so2TwentyFourHourly!!.central+"\n"+
                            "pm25_sub_index : "+ pm25SubIndex!!.central+"\n"+
                            "psi_twenty_four_hourly : "+ psiTwentyFourHourly!!.central+"\n"+
                            "o3_eight_hour_max : "+ o3EightHourMax!!.central+"\n"
               }
               else->{
                    return finalString
               }
          }
     }
}