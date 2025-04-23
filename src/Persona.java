import java.util.ArrayList;
import java.util.List;

public class Persona {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected int documento;

    private List<Perro> perrosAdoptados;

    public Persona() {
        perrosAdoptados = new ArrayList<>();
    }

    public Persona(String nombre, String apellido, int edad, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perrosAdoptados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public List<Perro> getPerrosAdoptados() {
        return perrosAdoptados;
    }

    public void adoptarPerro(Perro perroAdoptado) {
        if (perroAdoptado != null) {
            perrosAdoptados.add(perroAdoptado);
        }
    }

    public Perro perroMasGrande() {
        if (perrosAdoptados.isEmpty()) {
            return null;
        }

        Perro mayor = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }
        return mayor;
    }

    @Override
    public String toString() {
        return "Persona \n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Edad: " + edad + "\n" +
                "Documento: " + documento + "\n" +
                "Perros adoptados: " + perrosAdoptados.size() + "\n" +
                "-----------------------------";

    }


}

