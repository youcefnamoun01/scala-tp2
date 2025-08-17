object Main {
  def main(args: Array[String]): Unit = {
    DatabaseManager.initSchema()

    val library = new Library

    val book1 = new Book("1984", "George Orwell", 1949, "Dystopian")
    val mag1 = new Magazine("Science Today", "Editorial Team", 2021, 12)

    // En mémoire
    library.addDocument(book1)
    library.addDocument(mag1)

    // En DB
    DatabaseManager.insertDocument(Mapper.toEntity(book1))
    DatabaseManager.insertDocument(Mapper.toEntity(mag1))

    val user1 = new User("Alice")
    library.addUser(user1)
    DatabaseManager.insertUser(UserEntity(None, user1.name))

    println("\n📚 Documents en mémoire:")
    library.listAvailableDocuments()

    println("\n💾 Documents en DB:")
    val docsDB = DatabaseManager.listDocuments()
    docsDB.foreach(d => println(s"- ${d.title} (${d.docType})"))
  }
}
