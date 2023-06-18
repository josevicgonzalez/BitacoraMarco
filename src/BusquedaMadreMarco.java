import java.util.Random;

public class BusquedaMadreMarco {

    public static void main(String[] args) {
        Random random = new Random();

        // Variables de Marco
        double velocidadPromedioMarco = random.nextDouble() * (15 - 10) + 10; // Velocidad promedio entre 10 y 15 km/h
        int horasTrayecto = random.nextInt(3) + 8; // Entre 8 y 10 horas de trayecto diario

        // Variables de la madre de Marcos
        double velocidadMadre = random.nextDouble() * (9 - 6) + 6; // Velocidad de 6 a 9 km/h
        int horasTrayectoMadre = random.nextInt(4) + 6; // Entre 6 y 9 horas de trayecto que recorre al día de la madre

        // Inicialización de variables de ambos
        double distanciaMarco = 350; // Distancia inicial  de Marco hacia su madre
        double distanciaMadre = 0; // Distancia recorrida por la madre
        int dias = 0;

        while (distanciaMarco > 0) {

            dias++;

            // Marco
            double velocidadMarco = velocidadPromedioMarco;
            int horas = horasTrayecto;

            // Verificar el clima
            double clima = random.nextDouble();
            if (clima < 0.1) {// Lluvia fuerte (reducción del 25%)

                velocidadMarco = velocidadMarco * 0.25;
            } else
                if (clima < 0.4) { // Lluvia normal (reducción del 25%)

                velocidadMarco = velocidadMarco * 0.75;
            }

            // Verificar estado del mono
            double estadoMono = random.nextDouble();
            if (estadoMono < 0.1) { // El mono se escapó y pierden dos horas en búsqueda

                horas = horas - 2;
            }
            else if (estadoMono < 0.2) { // El mono se cansa y pierden 10% de velocida

                velocidadMarco = velocidadMarco * 0.9;
            }

            double distanciaRecorridaMarco = velocidadMarco * horas;
            distanciaMarco = distanciaMarco - distanciaRecorridaMarco;

            // Madre
            double velocidadMadreActual = velocidadMadre;
            int horasMadre = horasTrayectoMadre;

            // Verificar el clima de la madre
            double climaMadre = random.nextDouble();
            if (climaMadre < 0.1) { // LLuvia fuerte reduce en 50% la velocidad

                velocidadMadreActual = velocidadMadreActual * 0.5;

            } else

                if (climaMadre < 0.4) { // LLuvia normal reduce en 25% la velocidad

                velocidadMadreActual = velocidadMadreActual * 0.75;
            }

            double distanciaRecorridaMadre = velocidadMadreActual * horasMadre;
            distanciaMadre = distanciaMadre + distanciaRecorridaMadre;

            // Verificar encuentro cercano
            if (Math.abs(distanciaMarco - distanciaMadre) < 50) {

                double encuentro = random.nextDouble();

                if (encuentro < 0.5) {

                    distanciaMarco = distanciaMarco - 25;
                }
            }
            System.out.println(dias);

        }

        System.out.println("Marco por fin encuentra a su madre luego de " + dias + " días de travesía ");
    }
}
