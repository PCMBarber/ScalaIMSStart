package com.qa
package domain

object Domain extends Enumeration {
  val USER = Value(0, "User")
  val ITEM = Value(1, "Item")
  val ORDER = Value(2, "Order")
  val STOP = Value(3, "Stop")
}
