import slick.jdbc.PostgresProfile.api._

class Documents(tag: Tag) extends Table[DocumentEntity](tag, "documents") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def title = column[String]("title")
  def author = column[String]("author")
  def year = column[Int]("year")
  def docType = column[String]("doc_type")
  def extraInfo = column[String]("extra_info")
  def isBorrowed = column[Boolean]("is_borrowed")

  def * = (id.?, title, author, year, docType, extraInfo, isBorrowed) <> (DocumentEntity.tupled, DocumentEntity.unapply)
}

class Users(tag: Tag) extends Table[UserEntity](tag, "users") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")

  def * = (id.?, name) <> (UserEntity.tupled, UserEntity.unapply)
}
