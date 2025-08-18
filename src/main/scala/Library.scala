class Library {

  // Liste des documents
  var documents: List[Document] = List()

  // Liste des utilisateurs
  var users: List[User] = List()
  
  // Ajout d'un document à la bibliothèque
  def addDocument(document: Document): Unit = {
    documents = document :: documents
    println(s"Document ajouté: ${document.title}")
  }
  
  // Ajout d'un utilisateur à la bibliothèque
  def addUser(user: User): Unit = {
    users = user :: users
    println(s"Utilisateur ajouté: ${user.name}")
  }
  
  // Liste des documents disponibles
  def listAvailableDocuments(): Unit = {
    val availableDocs = documents.filter(!_.isBorrowed)
    if (availableDocs.isEmpty) {
      println("Aucun document disponible")
    } else {
      println("Documents disponibles:")
      availableDocs.foreach(doc => println(s"  - ${doc.description()}"))
    }
  }
  
  // Liste des documents empruntés
  def getDocuments: List[Document] = documents

  // Liste des utilisateurs
  def getUsers: List[User] = users
  
  // Liste de tous les documents
  def listAllDocuments(): Unit = {
    if (documents.isEmpty) {
      println("Aucun document dans la bibliothèque")
    } else {
      println("Tous les documents:")
      documents.foreach(doc => println(s"  - ${doc.description()}"))
    }
  }
}