package AdoPET.model;

public class Adoption {
    private int id;
    private int petId;
    private int adotanteId;
    private String dataPedido;
    private Status status;

    enum Status {
        INDEFIRIDO,
        PENDENTE,
        DEFERIDO
    }

    public Adoption(int id, int petId, int adotanteId, String dataPedido, Status status) {
        this.id = id;
        this.petId = petId;
        this.adotanteId = adotanteId;
        this.dataPedido = dataPedido;
        this.status = status;
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

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }
    public String getDataPedido() {
        return dataPedido;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return this.status;
    }

}
