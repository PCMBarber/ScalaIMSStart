package com.qa
package dao

import domain.{User, Users}

import slick.jdbc.MySQLProfile.backend.Database
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global


object UserDAO extends DAO[User, Users] {

  lazy val db: Database = Database.forConfig("mysqlDB")
  lazy val table: TableQuery[Users] = TableQuery[Users]

  override def readAll: Future[Seq[User]] = {
    db.run(table.result)
  }

  override def readByID(id: Int): Future[Option[User]] = {
    db.run(table.filter(_.id === id).result.headOption)
  }

  override def create(user: User): Future[String] = {
    db.run(table += user).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }


  override def update(user: User): Future[String] = {
    db.run(table.insertOrUpdate(user)).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  override def delete(id: Int): Future[Int] = {
    db.run(table.filter(_.id === id).delete)
  }
}
