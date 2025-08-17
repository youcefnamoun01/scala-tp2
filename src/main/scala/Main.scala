object Main extends App {
  // Création de la bibliothèque
  val library = new Library()
  
  println("AJOUT DES DOCUMENTS:")
  val book1 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943, "Fiction")
  val book2 = new Book("1984", "George Orwell", 1949, "Science-fiction")
  val magazine1 = new Magazine("Science & Vie", "Équipe éditoriale", 2024, 1258)
  val comic1 = new Comic("Astérix", "René Goscinny & Albert Uderzo", 1961, 1)
  val comic2 = new Comic("Tintin", "Hergé", 1929, 12)
  
  library.addDocument(book1)
  library.addDocument(book2)
  library.addDocument(magazine1)
  library.addDocument(comic1)
  library.addDocument(comic2)

  library.listAvailableDocuments()
    
  println("AJOUT DES UTILISATEURS:")
  val user1 = new User("Alice")
  val user2 = new User("Bob")
  val user3 = new User("Charlie")
  
  library.addUser(user1)
  library.addUser(user2)
  library.addUser(user3)
  
  
  println("EMPRUNTS DE DOCUMENTS:")
  user1.borrowDocument(book1)
  user1.borrowDocument(comic1)
  user2.borrowDocument(book1) // Deja emprunté
  user2.borrowDocument(magazine1)
  user3.borrowDocument(comic2)
  
  
  println("LISTE DES DOCUMENTS EMPRUNTÉS:")
  user1.listBorrowedDocuments()
  user2.listBorrowedDocuments()
  user3.listBorrowedDocuments()
  

  println("DOCUMENTS DISPONIBLES APRÈS EMPRUNTS:")
  library.listAvailableDocuments()
  
  println("RETOURS DE DOCUMENTS:")
  user1.returnDocument(book1)
  user3.returnDocument(comic2)
  user2.returnDocument(book2) // Retour d'un livre non emprunté
  
  // Affichage final de tous les documents
  println("DOCUMENTS:")
  library.listAllDocuments()
  
  println("DOCUMENTS EMPRUNTÉS PAR LES UTILISATEURS:")
  user1.listBorrowedDocuments()
  user2.listBorrowedDocuments()
  user3.listBorrowedDocuments()
}