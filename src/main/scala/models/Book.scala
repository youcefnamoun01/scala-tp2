class Book(title: String, author: String, year: Int, val genre: String) extends Document(title, author, year) {

    // Description du Book
    override def description(): String = {
        s"Livre: '$title' - Auteur: $author - Annee: $year - Genre: $genre - Status: $getBorrowStatus"
    }

}   