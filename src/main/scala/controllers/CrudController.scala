package com.qa
package controllers

trait CrudController {
  def readAll(): Unit
  def readByID(): Unit
  def create(): Unit
  def update(): Unit
  def delete(): Unit
}
