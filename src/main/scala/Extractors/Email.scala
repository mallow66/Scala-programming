package Extractors

/**
  * Created by brahim on 3/21/18.
  */
object Email {


  def apply(user: String, domain: String) = user + "@" + domain


  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}
