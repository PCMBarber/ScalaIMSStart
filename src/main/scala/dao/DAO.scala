package com.qa
package dao

import slick.jdbc.MySQLProfile.backend.Database
import slick.lifted.TableQuery

import scala.concurrent.Future

trait DAO[A, B] {
  def readAll: Future[Seq[A]]
  def readByID(id: Int): Future[Option[A]]
  def create(any: A): Future[String]
  def update(any: A): Future[String]
  def delete(id: Int): Future[Int]
}
