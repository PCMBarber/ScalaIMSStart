package com.qa
package controllers
import dao.UserDAO

import com.qa.domain.User
import com.qa.utils.Utils

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

class UserController(implicit utils: Utils) extends CrudController {

  override def readAll(): Unit = {
    val readAllFuture = UserDAO.readAll
    readAllFuture onComplete {
      case Success(value) =>
        print("\n")
        value foreach(println)
      case Failure(error) =>
        error.printStackTrace()
    }
  }

  override def readByID(): Unit = {
    print("Please enter the ID of the user: ")
    val id = utils.getInt
    val readByIDFuture = UserDAO.readByID(id)
    readByIDFuture onComplete {
      case Success(value) =>
        print("\n")
        println(value.getOrElse("User Not Found"))
      case Failure(error) =>
        error.printStackTrace()
    }
  }

  override def create(): Unit = {
    print("Please enter the first name of the new user: ")
    val fName = utils.getString
    print("Please enter the last name of the new user: ")
    val lName = utils.getString
    print("Please enter the age of the new user: ")
    val age = utils.getInt
    val createFuture = UserDAO.create(User(0,fName,lName,age))
    createFuture onComplete {
      case Success(value) =>
        print("\n")
        println(value)
      case Failure(error) =>
        error.printStackTrace()
    }
  }

  override def update(): Unit = {
    readAll()
    print("Please enter the ID of the user: ")
    val id = utils.getInt
    print("Please enter the first name user: ")
    val fName = utils.getString
    print("Please enter the last name user: ")
    val lName = utils.getString
    print("Please enter the age user: ")
    val age = utils.getInt
    val updateFuture = UserDAO.update(User(id,fName,lName,age))
    updateFuture onComplete {
      case Success(value) =>
        print("\n")
        println(value)
      case Failure(error) =>
        error.printStackTrace()
    }
  }

  override def delete(): Unit = {
    readAll()
    print("Please enter the ID of the user: ")
    val id = utils.getInt
    val deleteFuture = UserDAO.delete(id)
    deleteFuture onComplete {
      case Success(1) =>
        print("\n")
        println("Delete successful")
      case Success(0) =>
        print("\n")
        println("User Doesn't Exist")
      case Failure(error) =>
        error.printStackTrace()
    }
  }
}
