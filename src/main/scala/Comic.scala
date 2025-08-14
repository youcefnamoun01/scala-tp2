

class Comic(title: String, author: String, year: Int, val seriesVolume: Int) extends Document(title, author, year) {

    // Description du Comic
    override def description(): String = {
        s"Comic: '$title' - Auteur: $author - Annee: $year - Volume: $seriesVolume - Status: $getBorrowStatus"
    }

}   