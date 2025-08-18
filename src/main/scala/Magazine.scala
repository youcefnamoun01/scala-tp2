

class Magazine(title: String, author: String, year: Int, val editionNumber: Int) extends Document(title, author, year) {

    // Description du Magazine
    override def description(): String = {
        s"Magazine: '$title' - Auteur: $author - Annee $year - Edition n°$editionNumber - Status: $getBorrowStatus"
    }

}   