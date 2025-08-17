case class DocumentEntity(
  id: Option[Int] = None,
  title: String,
  author: String,
  year: Int,
  docType: String,
  extraInfo: String,
  isBorrowed: Boolean = false
)

case class UserEntity(
  id: Option[Int] = None,
  name: String
)
