object Main {
  def main(args: Array[String]): Unit = {

    // Initialiser le schéma en DB
    DatabaseManager.initSchema()

    println("\n AJOUT DES DOCUMENTS:")
    val book1 = new Book("Harry Potter", "J.K. Rowling", 1997, "Fantasy")
    val book2 = new Book("Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, "Fantasy")
    val magazine1 = new Magazine("Science & Vie", "Equipe éditoriale", 2024, 1258)
    val magazine2 = new Magazine("National Geographic", "Redaction NG", 2023, 789)
    val comic1 = new Comic("Asterix", "Rene Goscinny & Albert Uderzo", 1961, 1)
    val comic2 = new Comic("Tintin", "Herge", 1929, 12)

    // Ajout en DB
    val book1Id = DatabaseManager.insertDocument(Mapper.toEntity(book1))
    val book2Id = DatabaseManager.insertDocument(Mapper.toEntity(book2))
    val magazine1Id = DatabaseManager.insertDocument(Mapper.toEntity(magazine1))
    val magazine2Id = DatabaseManager.insertDocument(Mapper.toEntity(magazine2))
    val comic1Id = DatabaseManager.insertDocument(Mapper.toEntity(comic1))
    val comic2Id = DatabaseManager.insertDocument(Mapper.toEntity(comic2))

    println("\n AJOUT DES UTILISATEURS:")
    val user1 = new User("Youcef")
    val user2 = new User("Juba")
    val user3 = new User("Omar")

    DatabaseManager.insertUser(UserEntity(None, user1.name))
    DatabaseManager.insertUser(UserEntity(None, user2.name))
    DatabaseManager.insertUser(UserEntity(None, user3.name))

    println("\n EMPRUNTS DE DOCUMENTS:")
    user1.borrowDocument(book1, book1Id)
    user1.borrowDocument(comic1, comic1Id)
    user2.borrowDocument(book1, book1Id) // Déjà emprunté
    user2.borrowDocument(magazine1, magazine1Id)
    user3.borrowDocument(comic2, comic2Id)

    println("\n DOCUMENTS EN DB APRÈS EMPRUNTS:")
    DatabaseManager.listDocuments().foreach(d =>
      println(s"- ${d.title}, borrowed = ${d.isBorrowed}")
    )

    println("\n RETOURS DE DOCUMENTS:")
    user1.returnDocument(book1, book1Id)
    user3.returnDocument(comic2, comic2Id)
    user2.returnDocument(book2, book2Id) // Retour d'un livre non emprunté

    println("\n DOCUMENTS EN DB APRÈS RETOURS:")
    DatabaseManager.listDocuments().foreach(d =>
      println(s"- ${d.title}, borrowed = ${d.isBorrowed}")
    )
  }
}
