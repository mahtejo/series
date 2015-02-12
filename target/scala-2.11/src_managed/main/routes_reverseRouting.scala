// @SOURCE:C:/Users/M/Pictures/metas/conf/routes
// @HASH:0d53b4f9e70fe1d9abd8908d987341b0840f3ac0
// @DATE:Wed Feb 11 22:09:41 GMT-03:00 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
class ReverseAssets {


// @LINE:11
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:7
def assistirEpisodio(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "episodio/" + implicitly[PathBindable[Long]].unbind("id", id) + "/assistiu")
}
                        

// @LINE:8
def assistirSerie(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "serie/" + implicitly[PathBindable[Long]].unbind("id", id) + "/assistindo")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:11
class ReverseAssets {


// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:7
def assistirEpisodio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.assistirEpisodio",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "episodio/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/assistiu"})
      }
   """
)
                        

// @LINE:8
def assistirSerie : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.assistirSerie",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serie/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/assistindo"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
class ReverseAssets {


// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:7
def assistirEpisodio(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.assistirEpisodio(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "assistirEpisodio", Seq(classOf[Long]), "POST", """""", _prefix + """episodio/$id<[^/]+>/assistiu""")
)
                      

// @LINE:8
def assistirSerie(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.assistirSerie(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "assistirSerie", Seq(classOf[Long]), "POST", """""", _prefix + """serie/$id<[^/]+>/assistindo""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

}
                          
}
        
    