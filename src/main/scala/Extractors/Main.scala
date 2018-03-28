package Extractors

/**
  * Created by brahim on 3/21/18.
  */
object Main extends App{


  def myEmail(em: String) = em match {
    case Email(user, domain) => println("this is an email"); println("the user: "+ user+"\n the domain: "+ domain)
    case _ => println("this is not an email")
  }

  /*
  would lead to call Email.unapply
   */


  myEmail("brahimserghini2@gmail.com")
}
