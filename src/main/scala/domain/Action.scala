package com.qa
package domain

object Action extends Enumeration {
  val CREATE = Value(0, "Create")
  val READALL = Value(1, "Read All")
  val READBYID = Value(2, "Read By ID")
  val UPDATE = Value(3, "Update")
  val DELETE = Value(4, "Delete")
  val RETURN = Value(5, "Return")
}