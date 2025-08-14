abstract class Document(val title: String, val author: String, val year : Int, var isBorrowed: Boolean = false) extends Borrowable {
    
    // Description d'un document
    def description(): String

    // Emprunter un document
    def borrow(): Boolean = {
        if (!isBorrowed) {
        isBorrowed = true
        true
        } else {
        false
        }
    }

    // Retourner un document
    def returnItem(): Boolean = {
        if (isBorrowed) {
        isBorrowed = false
        true
        } else {
        false
        }
    }

    // Retourner le statut du document
    def getBorrowStatus: String = {
        if (isBorrowed) {
            "Emprunte"
        } else {
            "Disponible"
        }
    }

    
}