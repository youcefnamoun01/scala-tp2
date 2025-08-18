class User(val name: String) {

  // Liste des documents empruntés par l'utilisateur
  var borrowedDocs: List[Document] = List()


  // Emprunter un document
  def borrowDocument(document: Document): Boolean = {
    if (document.borrow()) {
      borrowedDocs = document :: borrowedDocs
      println(s"$name a emprunte: ${document.title}")
      true
    } else {
      println(s"Le document '${document.title}' n'est pas disponible")
      false
    }
  }
  
  // Retourner un document
  def returnDocument(document: Document): Boolean = {
    if (borrowedDocs.contains(document) && document.returnItem()) {
      borrowedDocs = borrowedDocs.filterNot(_ == document)
      println(s"$name a retourne: ${document.title}")
      true
    } else {
      println(s"$name n'a pas emprunte ce document")
      false
    }
  }
  
  // Lister les documents empruntés
  def listBorrowedDocuments(): Unit = {
    if (borrowedDocs.isEmpty) {
      println(s"$name n'a emprunte aucun document")
    } else {
      println(s"Documents empruntes par $name:")
      borrowedDocs.foreach(doc => println(s"  - ${doc.title}"))
    }
  }
}