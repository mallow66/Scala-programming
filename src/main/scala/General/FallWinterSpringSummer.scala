package General

import General.ChecksumAccumulator.calculate

/**
  * Created by brahim on 2/28/18.
  */
object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    print(season+" : " + calculate(season))

}
