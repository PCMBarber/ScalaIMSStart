package com.qa

import utils.Utils

import com.qa.domain.{User, Users}
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
import com.qa.ims.imsFunc._

object Runner {
  def main(args: Array[String]): Unit = {
    imsStart()
    println("Goodbye!")
  }
}
