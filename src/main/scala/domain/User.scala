package com.qa
package domain
import slick.jdbc.MySQLProfile.api._


case class User(id: Int = 0, firstName: String, lastName: String, age: Int) {
  override def toString: String = s"ID: $id, First name: $firstName, Last Name $lastName, Age: $age"
}

case class Users(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Int]("User_ID", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("User_FName")
  def lastName = column[String]("User_LName")
  def age = column[Int]("User_Age")
  def * = (id, firstName, lastName, age) <> (User.tupled, User.unapply)
}