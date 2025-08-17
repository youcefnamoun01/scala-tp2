class User(val name: String) {
  var borrowedDocs: List[Document] = List()


  // Emprunter un document
  def borrowDocument(doc: Document, docId: Int): Boolean = {
    if (doc.borrow()) {
      borrowedDocs = doc :: borrowedDocs
      DatabaseManager.updateBorrowStatus(docId, true)  // synchro DB
      true
    } else false
  }


  
  // Retourner un document
  def returnDocument(doc: Document, docId: Int): Boolean = {
    if (doc.returnItem()) {
      borrowedDocs = borrowedDocs.filterNot(_ == doc)
      DatabaseManager.updateBorrowStatus(docId, false) // synchro DB
      true
    } else false
  }
  
  // Lister les documents empruntés
  def listBorrowedDocuments(): Unit = {
    if (borrowedDocs.isEmpty) {
      println(s"$name n'a emprunté aucun document")
    } else {
      println(s"Documents empruntés par $name:")
      borrowedDocs.foreach(doc => println(s"  - ${doc.title}"))
    }
  }
}