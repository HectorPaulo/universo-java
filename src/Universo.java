interface Negras {
    boolean enfriamiento();
}
interface Evolucion {
    boolean hidrogeno();
}
interface Agujero {
    boolean supernova();
}
abstract class Estrella {
    protected String nombre;
    protected double luminosidad;
    protected double diametro;

    public Estrella(String nombre, double luminosidad, double diametro) {
        this.nombre = nombre;
        this.luminosidad = luminosidad;
        this.diametro = diametro;
    }

    public abstract void mostrarInformacion();
}

class Enana extends Estrella implements Negras {
    private double masa;
    private double densidad;
    private double velocidad;
    private double temperatura;

    public Enana(String nombre, double luminosidad, double diametro, double masa, double densidad, double velocidad, double temperatura) {
        super(nombre, luminosidad, diametro);
        this.masa = masa;
        this.densidad = densidad;
        this.velocidad = velocidad;
        this.temperatura = temperatura;
    }

    @Override
    public boolean enfriamiento() {
        return this.temperatura < 10000;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estrella Enana: " + nombre);
        System.out.println("Luminosidad: " + luminosidad);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Masa: " + masa);
        System.out.println("Densidad: " + densidad);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Se ha enfriado: " + (enfriamiento() ? "Sí" : "No"));
    }
}

class Gigante extends Estrella implements Evolucion {
    private double temperaturaSuperficial;
    private boolean hidrogeno;
    private double presion;
    private String color;

    public Gigante(String nombre, double luminosidad, double diametro, double temperaturaSuperficial, boolean hidrogeno, double presion, String color) {
        super(nombre, luminosidad, diametro);
        this.temperaturaSuperficial = temperaturaSuperficial;
        this.hidrogeno = hidrogeno;
        this.presion = presion;
        this.color = color;
    }

    @Override
    public boolean hidrogeno() {
        return this.hidrogeno;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estrella Gigante: " + nombre);
        System.out.println("Luminosidad: " + luminosidad);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Temperatura Superficial: " + temperaturaSuperficial);
        System.out.println("Hidrógeno disponible: " + (hidrogeno ? "Sí" : "No"));
        System.out.println("Presión: " + presion);
        System.out.println("Color: " + color);
    }
}
class Hipergigante extends Estrella implements Agujero {
    private String color;
    private double energia;
    private double edad;
    private double temperatura;

    public Hipergigante(String nombre, double luminosidad, double diametro, String color, double energia, double edad, double temperatura) {
        super(nombre, luminosidad, diametro);
        this.color = color;
        this.energia = energia;
        this.edad = edad;
        this.temperatura = temperatura;
    }

    @Override
    public boolean supernova() {
        return this.temperatura >= 3500 && this.temperatura <= 35000 && this.edad >= 1 && this.edad <= 3;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estrella Hipergigante: " + nombre);
        System.out.println("Luminosidad: " + luminosidad);
        System.out.println("Diámetro: " + diametro);
        System.out.println("Color: " + color);
        System.out.println("Energía: " + energia);
        System.out.println("Edad: " + edad);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Se ha vuelto supernova: " + (supernova() ? "Sí" : "No"));
    }
}

public class Universo {
    public static void main(String[] args) {
        Estrella enana = new Enana("Enana Roja", 0.01, 0.1, 0.5, 10000, 200, 8000);
        Estrella gigante = new Gigante("Gigante Azul", 10000, 100, 15000, true, 2000, "Azul");
        Estrella hipergigante = new Hipergigante("Hipergigante Roja", 50000, 500, "Rojo", 1000000, 2, 25000);

        enana.mostrarInformacion();
        System.out.println();
        gigante.mostrarInformacion();
        System.out.println();
        hipergigante.mostrarInformacion();
    }
}
