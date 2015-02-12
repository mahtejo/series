// @SOURCE:C:/Users/M/Pictures/metas/conf/routes
// @HASH:0d53b4f9e70fe1d9abd8908d987341b0840f3ac0
// @DATE:Wed Feb 11 22:09:41 GMT-03:00 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_assistirEpisodio1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("episodio/"),DynamicPart("id", """[^/]+""",true),StaticPart("/assistiu"))))
private[this] lazy val controllers_Application_assistirEpisodio1_invoker = createInvoker(
controllers.Application.assistirEpisodio(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "assistirEpisodio", Seq(classOf[Long]),"POST", """""", Routes.prefix + """episodio/$id<[^/]+>/assistiu"""))
        

// @LINE:8
private[this] lazy val controllers_Application_assistirSerie2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serie/"),DynamicPart("id", """[^/]+""",true),StaticPart("/assistindo"))))
private[this] lazy val controllers_Application_assistirSerie2_invoker = createInvoker(
controllers.Application.assistirSerie(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "assistirSerie", Seq(classOf[Long]),"POST", """""", Routes.prefix + """serie/$id<[^/]+>/assistindo"""))
        

// @LINE:11
private[this] lazy val controllers_Assets_at3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at3_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """episodio/$id<[^/]+>/assistiu""","""controllers.Application.assistirEpisodio(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serie/$id<[^/]+>/assistindo""","""controllers.Application.assistirSerie(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:7
case controllers_Application_assistirEpisodio1_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_assistirEpisodio1_invoker.call(controllers.Application.assistirEpisodio(id))
   }
}
        

// @LINE:8
case controllers_Application_assistirSerie2_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Application_assistirSerie2_invoker.call(controllers.Application.assistirSerie(id))
   }
}
        

// @LINE:11
case controllers_Assets_at3_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at3_invoker.call(controllers.Assets.at(path, file))
   }
}
        
}

}
     