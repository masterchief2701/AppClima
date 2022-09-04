package com.ionc.apps.cursos.appclima

/*W5 - Tienes que empatar los nombres de los campos del JSON y su tipo de estructura para que funcione el gson, checa muy bien tu json
* Incluso checa si tienes que crear mas Clases para en base la estructura json
* */
class Ciudad(name:String, weather: ArrayList<Weather>, main:Main) {

    var name: String = ""
    var weather: ArrayList<Weather>? = null
    var main: Main? = null

    init {
        this.name = name
        this.weather = weather
        this.main = main
    }
}