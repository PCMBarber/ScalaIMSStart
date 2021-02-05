package com.qa
package ims

import controllers.{CrudController, UserController}
import domain.Domain
import domain.Action
import domain.Domain._
import domain.Action._

import com.qa.utils.Utils

import scala.annotation.tailrec

object imsFunc {

  implicit val utils: Utils = new Utils()
  lazy val userController = new UserController()

  def imsStart(): Unit = {
    println("Which entity would you like to use?")
    Domain.values foreach (value => println(s"$value?"));
    print("Please type the name of the table: ")
    val domainChoice = domain()
    domainChoice match {
      case USER =>
        val active = userController
        actionControl(domainChoice, active)
      case ITEM =>
        val active = null
        actionControl(domainChoice, active)
      case ORDER =>
        val active = null
        actionControl(domainChoice, active)
      case STOP =>
        ()
    }
  }
  @tailrec
  def actionControl(domain: Domain.Value, active: CrudController): Unit = {
    println(s"What would you like to do with $domain?")
    Action.values foreach (value => println(s"$value?"));
    print("Please type the action: ")
    val actionChoice = action()
    actionChoice match {
      case CREATE =>
        active.create()
        actionControl(domain, active)
      case READALL =>
        active.readAll()
        actionControl(domain, active)
      case READBYID =>
        active.readByID()
        actionControl(domain, active)
      case UPDATE =>
        active.update()
        actionControl(domain, active)
      case DELETE =>
        active.delete()
        actionControl(domain, active)
      case RETURN =>
        imsStart()
      case _ =>
        println("Invalid Response")
        actionControl(domain, active)
    }
  }
  @tailrec
  def domain()(implicit utils: Utils): Domain.Value = {
    val choice: String = utils.getString
    choice toUpperCase match {
      case "USER" =>
        USER
      case "ITEM" =>
        ITEM
      case "ORDER" =>
        ORDER
      case "STOP" =>
        STOP
      case _ =>
        println("Invalid Response")
        domain()
    }
  }
  @tailrec
  def action()(implicit utils: Utils): Action.Value = {
    val choice: String = utils.getString
    choice toUpperCase match {
      case "CREATE" =>
        CREATE
      case "READ ALL" =>
        READALL
      case "READ BY ID" =>
        READBYID
      case "UPDATE" =>
        UPDATE
      case "DELETE" =>
        DELETE
      case "RETURN" =>
        RETURN
      case _ =>
        println("Invalid Response")
        action()
    }
  }
  }