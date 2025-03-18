package AdoPET.model;

public class Favs {
    private int id;
    private int petId;
    private int adotanteId;
   
    public Favs(int id, int petId, int adotanteId) {
        this.id = id;
        this.petId = petId;
        this.adotanteId = adotanteId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }
    public int getPetId() {
        return petId;
    }

    public void setAdotanteId(int adotanteId) {
        this.adotanteId = adotanteId;
    }
    public int getAdotanteId() {
        return adotanteId;
    }
    
}
