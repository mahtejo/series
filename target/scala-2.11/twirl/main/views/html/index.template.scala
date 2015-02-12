
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Serie],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(series: List[Serie]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.23*/("""

"""),_display_(/*3.2*/main("TVShow List")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
    """),format.raw/*4.5*/("""<html xmlns="http://www.w3.org/1999/html">
        <head>
            <title>Minhas Series</title>
            <meta charset="UTF-8">
            <link href=""""),_display_(/*8.26*/routes/*8.32*/.Assets.at("stylesheets/bootstrap.css")),format.raw/*8.71*/("""" rel="stylesheet" media="screen">
            <script src=""""),_display_(/*9.27*/routes/*9.33*/.Assets.at("javascripts/jquery-2.1.1.min.js")),format.raw/*9.78*/(""""></script>
            <script src=""""),_display_(/*10.27*/routes/*10.33*/.Assets.at("javascripts/myjs.js")),format.raw/*10.66*/(""""></script>
            <script src=""""),_display_(/*11.27*/routes/*11.33*/.Assets.at("javascripts/bootstrap.min.js")),format.raw/*11.75*/(""""></script>
            <script src=""""),_display_(/*12.27*/routes/*12.33*/.Assets.at("javascripts/inputvalidator.js")),format.raw/*12.76*/(""""></script>
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        </head>
        <body>
            <div class="container">
                <div class="page-header">
                    <h1 class="text-info">TVShow List
                        <small>O jeito mais fácil de organizar suas séries. </small>
                    </h1>
                </div>
                <br>


                <div class="col-md-6" id="criaMeta">
                    <section class="panel panel-info">
                        <header class="panel-heading">
                            <h2 class="panel-title">Séries Disponíveis</h2>
                        </header>
                        <div class="panel-body">
                            Clique no nome da série que você deseja marcar como assistida.<br><br>
                        """),_display_(/*33.26*/for(serie <- series) yield /*33.46*/{_display_(Seq[Any](format.raw/*33.47*/("""
                            """),_display_(/*34.30*/if(!serie.isAssistindo)/*34.53*/{_display_(Seq[Any](format.raw/*34.54*/("""
                                """),format.raw/*35.33*/("""<div id="accordion" class="panel-group">
                                    <div class="panel panel-default">
                                        <div class="panel-heading" >
                                            <h4 class="panel-title">
                                                """),_display_(/*39.50*/serie/*39.55*/.getNome),format.raw/*39.63*/("""
                                                """),format.raw/*40.49*/("""<form class="pull-right" action=""""),_display_(/*40.83*/routes/*40.89*/.Application.assistirSerie(serie.getId)),format.raw/*40.128*/("""" method="post">
                                                    <button class="btn btn-success"><span class="glyphicon glyphicon-play" aria-hidden="true"></span></button>
                                                </form>
                                            </h4><br/>
                                        </div>
                                        <div class="panel-body">
                                        </div>
                                    </div>
                                </div>

                            """)))}),format.raw/*50.30*/("""
                        """)))}),format.raw/*51.26*/("""
                        """),format.raw/*52.25*/("""</div>


                    </section>  </div>

            <div class="col-md-6">
                    <section class="panel panel-success">
                        <header class="panel-heading">
                            <h2 class="panel-title">Séries Assistidas</h2>
                        </header>
                    <div class="panel-body">

                    """),_display_(/*64.22*/for(serie <- series) yield /*64.42*/ {_display_(Seq[Any](format.raw/*64.44*/("""
                        """),_display_(/*65.26*/while(!serie.isAssistindo)/*65.52*/{_display_(Seq[Any](format.raw/*65.53*/("""
                            """),format.raw/*66.29*/("""Você ainda não assistiu a nenhuma série.<br>
                        """)))}),format.raw/*67.26*/("""
                        """),_display_(/*68.26*/if(serie.isAssistindo)/*68.48*/ {_display_(Seq[Any](format.raw/*68.50*/("""
                            """),format.raw/*69.29*/("""<div id="accordion" class="panel-group">
                                <div class="panel panel-default">
                                    <div class="panel-heading" >
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion" href="#"""),_display_(/*73.104*/serie/*73.109*/.getNome.split(" ")),format.raw/*73.128*/(""" """),_display_(/*73.130*/serie/*73.135*/.getId),format.raw/*73.141*/("""">"""),_display_(/*73.144*/serie/*73.149*/.getNome),format.raw/*73.157*/("""</a>
                                        </h4>
                                        <br/>
                                    </div>
                                    <div id=""""),_display_(/*77.47*/serie/*77.52*/.getNome.split(" ")),format.raw/*77.71*/(""" """),_display_(/*77.73*/serie/*77.78*/.getId),format.raw/*77.84*/("""" class="panel-collapse collapse">
                                        <div class="panel-body">
                                        """),_display_(/*79.42*/for(temporada <- serie.getTemporadas) yield /*79.79*/ {_display_(Seq[Any](format.raw/*79.81*/("""
                                            """),format.raw/*80.45*/("""<div id="accordion" class="panel-group">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#"""),_display_(/*84.120*/temporada/*84.129*/.getId),format.raw/*84.135*/(""" """),_display_(/*84.137*/temporada/*84.146*/.getSerie.getNome.split(" ")),format.raw/*84.174*/("""">"""),_display_(/*84.177*/temporada/*84.186*/.getNumero),format.raw/*84.196*/("""
                                                                """),format.raw/*85.65*/("""Temporada - """),_display_(/*85.78*/temporada/*85.87*/.getQuantidadeDeEpisodiosAssistidos),format.raw/*85.122*/("""/"""),_display_(/*85.124*/temporada/*85.133*/.getTotalDeEpisodios),format.raw/*85.153*/("""</a>
                                                        </h4>
                                                        <br/>
                                                    </div>
                                                    <div id=""""),_display_(/*89.63*/temporada/*89.72*/.getId),format.raw/*89.78*/(""" """),_display_(/*89.80*/temporada/*89.89*/.getSerie.getNome.split(" ")),format.raw/*89.117*/("""" class="panel-collapse collapse">
                                                        <div class="panel-body">

                                                            """),_display_(/*92.62*/for(episodio <- temporada.getEpisodios) yield /*92.101*/ {_display_(Seq[Any](format.raw/*92.103*/("""
                                                                """),_display_(/*93.66*/if(episodio.isAssistido)/*93.90*/ {_display_(Seq[Any](format.raw/*93.92*/("""
                                                                    """),format.raw/*94.69*/("""<br>
                                                                        <del> <span class="glyphicon glyphicon-play" aria-hidden="true"></span>"""),_display_(/*95.145*/episodio/*95.153*/.getNome),format.raw/*95.161*/("""</del>

                                                                    <br/>
                                                                """)))}/*98.67*/else/*98.72*/{_display_(Seq[Any](format.raw/*98.73*/("""
                                                                    """),format.raw/*99.69*/("""<br>
                                                                        """),_display_(/*100.74*/if(temporada.ehOProximoASerAssistido(episodio.getId))/*100.127*/ {_display_(Seq[Any](format.raw/*100.129*/("""
                                                                            """),format.raw/*101.77*/("""<span class="glyphicon glyphicon-play" aria-hidden="true"></span>"""),_display_(/*101.143*/episodio/*101.151*/.getNome),format.raw/*101.159*/(""" """),format.raw/*101.160*/("""(PRÓXIMO)
                                                                        """)))}/*102.75*/else/*102.80*/{_display_(Seq[Any](format.raw/*102.81*/("""
                                                                            """),format.raw/*103.77*/("""<span class="glyphicon glyphicon-play" aria-hidden="true"></span>"""),_display_(/*103.143*/episodio/*103.151*/.getNome),format.raw/*103.159*/("""
                                                                        """)))}),format.raw/*104.74*/("""
                                                                        """),format.raw/*105.73*/("""<form class="pull-right" action=""""),_display_(/*105.107*/routes/*105.113*/.Application.assistirEpisodio(episodio.getId)),format.raw/*105.158*/("""" method="post" >
                                                                            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                                                                        </form>
                                                                    <br/>
                                                                """)))}),format.raw/*109.66*/("""
                                                            """)))}),format.raw/*110.62*/("""
                                                        """),format.raw/*111.57*/("""</div>
                                                    </div>
                                                </div>
                                            </div>
                                        """)))}),format.raw/*115.42*/("""
                                        """),format.raw/*116.41*/("""</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        """)))}),format.raw/*121.26*/("""
                        """)))}),format.raw/*122.26*/("""

                    """),format.raw/*124.21*/("""</section></div></div>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        </body>

    </html>
""")))}),format.raw/*131.2*/("""




"""))}
  }

  def render(series:List[Serie]): play.twirl.api.HtmlFormat.Appendable = apply(series)

  def f:((List[Serie]) => play.twirl.api.HtmlFormat.Appendable) = (series) => apply(series)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Feb 11 22:09:42 GMT-03:00 2015
                  SOURCE: C:/Users/M/Pictures/metas/app/views/index.scala.html
                  HASH: df399577028872a1308a48167d852f1bd9241a42
                  MATRIX: 728->1|837->22|867->27|894->46|933->48|965->54|1154->217|1168->223|1227->262|1315->324|1329->330|1394->375|1460->414|1475->420|1529->453|1595->492|1610->498|1673->540|1739->579|1754->585|1818->628|2757->1540|2793->1560|2832->1561|2890->1592|2922->1615|2961->1616|3023->1650|3352->1952|3366->1957|3395->1965|3473->2015|3534->2049|3549->2055|3610->2094|4209->2662|4267->2689|4321->2715|4733->3100|4769->3120|4809->3122|4863->3149|4898->3175|4937->3176|4995->3206|5097->3277|5151->3304|5182->3326|5222->3328|5280->3358|5652->3702|5667->3707|5708->3726|5738->3728|5753->3733|5781->3739|5812->3742|5827->3747|5857->3755|6074->3945|6088->3950|6128->3969|6157->3971|6171->3976|6198->3982|6368->4125|6421->4162|6461->4164|6535->4210|6970->4617|6989->4626|7017->4632|7047->4634|7066->4643|7116->4671|7147->4674|7166->4683|7198->4693|7292->4759|7332->4772|7350->4781|7407->4816|7437->4818|7456->4827|7498->4847|7779->5101|7797->5110|7824->5116|7853->5118|7871->5127|7921->5155|8129->5336|8185->5375|8226->5377|8320->5444|8353->5468|8393->5470|8491->5540|8669->5690|8687->5698|8717->5706|8886->5857|8899->5862|8938->5863|9036->5933|9143->6012|9207->6065|9249->6067|9356->6145|9451->6211|9470->6219|9501->6227|9532->6228|9636->6313|9650->6318|9690->6319|9797->6397|9892->6463|9911->6471|9942->6479|10049->6554|10152->6628|10215->6662|10232->6668|10300->6713|10713->7094|10808->7157|10895->7215|11144->7432|11215->7474|11432->7659|11491->7686|11544->7710|11841->7976
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|61->33|61->33|61->33|62->34|62->34|62->34|63->35|67->39|67->39|67->39|68->40|68->40|68->40|68->40|78->50|79->51|80->52|92->64|92->64|92->64|93->65|93->65|93->65|94->66|95->67|96->68|96->68|96->68|97->69|101->73|101->73|101->73|101->73|101->73|101->73|101->73|101->73|101->73|105->77|105->77|105->77|105->77|105->77|105->77|107->79|107->79|107->79|108->80|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|112->84|113->85|113->85|113->85|113->85|113->85|113->85|113->85|117->89|117->89|117->89|117->89|117->89|117->89|120->92|120->92|120->92|121->93|121->93|121->93|122->94|123->95|123->95|123->95|126->98|126->98|126->98|127->99|128->100|128->100|128->100|129->101|129->101|129->101|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|131->103|132->104|133->105|133->105|133->105|133->105|137->109|138->110|139->111|143->115|144->116|149->121|150->122|152->124|159->131
                  -- GENERATED --
              */
          