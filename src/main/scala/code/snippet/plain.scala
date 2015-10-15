package code.snippet

import net.liftweb.common.Full
import net.liftweb.http.S
import net.liftweb.util.PassThru

object plain {
  def render = S.param("name") match {
    case Full(name) =>
      S.notice("Hello "+name)
      S.redirectTo("/plain")
    case _ =>
      PassThru
  }
}
