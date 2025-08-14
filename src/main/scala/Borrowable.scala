trait Borrowable { 

    // Emprunter un document
    def borrow(): Boolean
    
    // Retourner un document
    def returnItem(): Boolean
    
} 