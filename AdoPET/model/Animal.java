package AdoPET.model;

public class Animal {
    private int id;
    private String namePet;
    private int agePet;
    private String especie;
    private String raca;
    private String description;
    private int userId;

    public Animal(int id, String namePet, int agePet, String especie, String raca, String description, int userId) {
        this.id = id;
        this.namePet = namePet;
        this.agePet = agePet;
        this.especie = especie;
        this.raca = raca;
        this.description = description;
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }
    public String getNamePet() {
        return namePet;
    }

    public void setAgePet(int agePet) {
        this.agePet = agePet;
    }
    public int getAgePet() {
        return agePet;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getEspecie() {
        return especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getRaca() {
        return raca;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }
        
}
