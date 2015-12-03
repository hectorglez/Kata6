package kata6;

public class Person1 {

    private final Integer id;
    private final String name;
    private final String genero;
    private final String fechanacimiento;
    private final Float peso;
    private final String mail;

    public Person1(Integer id, String name, String genero, String fechanacimiento, Float peso, String mail) {
        this.id = id;
        this.name = name;
        this.genero = genero;
        this.fechanacimiento = fechanacimiento;
        this.peso = peso;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenero() {
        return genero;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public Float getPeso() {
        return peso;
    }

    public String getMail() {
        return mail;
    }
    
    
}
