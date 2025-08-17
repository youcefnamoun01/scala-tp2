object Mapper {

  def toEntity(doc: Document): DocumentEntity = doc match {
    case b: Book     => DocumentEntity(None, b.title, b.author, b.year, "Book", b.genre, b.isBorrowed)
    case m: Magazine => DocumentEntity(None, m.title, m.author, m.year, "Magazine", m.editionNumber.toString, m.isBorrowed)
    case c: Comic    => DocumentEntity(None, c.title, c.author, c.year, "Comic", c.seriesVolume.toString, c.isBorrowed)
  }

  def fromEntity(e: DocumentEntity): Document = e.docType match {
    case "Book"     => new Book(e.title, e.author, e.year, e.extraInfo)
    case "Magazine" => new Magazine(e.title, e.author, e.year, e.extraInfo.toInt)
    case "Comic"    => new Comic(e.title, e.author, e.year, e.extraInfo.toInt)
  }

}
