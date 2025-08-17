object Main {
  def main(args: Array[String]): Unit = {
    DatabaseManager.initSchema()
    val library = new Library

    // Ajouter un document
    val book1 = new Book("1984", "George Orwell", 1949, "Dystopian")
    val book1Id = DatabaseManager.insertDocument(Mapper.toEntity(book1))

    val user1 = new User("Alice")
    DatabaseManager.insertUser(UserEntity(None, user1.name))
    library.addUser(user1)

    println("\n📚 Documents avant emprunt:")
    library.addDocument(book1)
    library.listAvailableDocuments()

    // Alice emprunte 1984
    println("\n➡️ Alice emprunte 1984")
    user1.borrowDocument(book1, book1Id)

    println("\n📚 Documents disponibles après emprunt (mémoire):")
    library.listAvailableDocuments()

    println("\n💾 Documents en DB après emprunt:")
    DatabaseManager.listDocuments().foreach(d => println(s"- ${d.title}, borrowed = ${d.isBorrowed}"))

    // Alice retourne 1984
    println("\n↩️ Alice retourne 1984")
    user1.returnDocument(book1, book1Id)

    println("\n💾 Documents en DB après retour:")
    DatabaseManager.listDocuments().foreach(d => println(s"- ${d.title}, borrowed = ${d.isBorrowed}"))
  }
}
