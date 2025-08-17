import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import com.typesafe.config.ConfigFactory

object DatabaseManager {
  val config = ConfigFactory.load()
  val url = config.getString("db.URL")
  val user = config.getString("db.USER")
  val password = config.getString("db.PASSWORD")
  val driver = config.getString("db.DRIVER")


  val db = Database.forURL(
    url = url,
    user = user,
    password = password,
    driver = driver
  )

  val documents = TableQuery[Documents]
  val users = TableQuery[Users]

  def initSchema(): Unit = {
    val setup = DBIO.seq(
      (documents.schema ++ users.schema).createIfNotExists
    )
    Await.result(db.run(setup), 10.seconds)
    println("Tables créées ou déjà existantes")
  }

  def insertDocument(doc: DocumentEntity): Unit =
    Await.result(db.run(documents += doc), 5.seconds)

  def insertUser(user: UserEntity): Unit =
    Await.result(db.run(users += user), 5.seconds)

  def listDocuments(): Seq[DocumentEntity] =
    Await.result(db.run(documents.result), 5.seconds)

  def listUsers(): Seq[UserEntity] =
    Await.result(db.run(users.result), 5.seconds)
}
