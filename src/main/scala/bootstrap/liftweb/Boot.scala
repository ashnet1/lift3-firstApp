package bootstrap.liftweb

import net.liftweb.util.{Props, DefaultConnectionIdentifier}
import net.liftweb.db._
import net.liftweb.http.{Html5Properties, LiftRules, Req}
import net.liftweb.sitemap.{Menu, SiteMap}

/**
* A class that's instantiated early and run. It allows the application
* to modify lift's environment
*/
class Boot {
  def boot: Unit = {

    // where to search snippet
    LiftRules.addToPackages("code")

    // Build SiteMap
    def sitemap(): SiteMap = SiteMap(
      Menu.i("Home") / "index"
    )
	
    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
    new Html5Properties(r.userAgent))
  }
}
