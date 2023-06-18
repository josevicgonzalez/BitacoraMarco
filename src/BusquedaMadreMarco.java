import java.util.Random;

public class BusquedaMadreMarco {

    public static void main(String[] args) {
        Random random = new Random();

        // Variables de Marco

        // Velocidad promedio entre 10 y 15 km/h
        double velocidadPromedioMarco = random.nextDouble() * (15 - 10) + 10;

        // Entre 8 y 10 horas de trayecto diario de Marco
        int horasRecorrido= random.nextInt(3) + 8;

        // Variables de la madre de Marcos

        // Velocidad de 6 a 9 km/h
        double velocidadMadre = random.nextDouble() * (9 - 6) + 6;

        // Entre 6 y 9 horas de trayecto que recorre al día de la madre
        int horasRecorridoMadre = random.nextInt(4) + 6;

        // Inicializamos variables de Marcos y su madre

        // Distancia inicial de Marco hacia su madre
        double distanciaMarco = 350;

        // Distancia recorrida por su madre
        double distanciaMadre = 0;
        int dias = 0;
        String estadoClima = "";

        while (distanciaMarco > 0) {

            dias++;

            // Recorrido de Marcos
            double velocidadMarco = velocidadPromedioMarco;
            int horas = horasRecorrido;

            // Verificar el clima
            double clima = random.nextDouble();


            // Lluvia fuerte (reducción del 25%)
            if (clima < 0.1) {

                estadoClima = "Con lluvia muy fuerte";
                velocidadMarco = velocidadMarco * 0.25;

            } else

                // Lluvia normal (reducción del 25%)
                if (clima < 0.4) {

                estadoClima = "Con lluvia normal";
                velocidadMarco = velocidadMarco * 0.75;

            } else {

                estadoClima = "con un buen sol y despejado";
            }

            // Verificar estado del mono
            double estadoMono = random.nextDouble();

            // El mono se escapó y pierden dos horas en búsqueda
            if (estadoMono < 0.1) {

                horas = horas - 2;

            } else

                // El mono se cansa y pierden 10% de velocidad
                if (estadoMono < 0.2) {

                velocidadMarco = velocidadMarco * 0.9;

            }

            double distanciaRecorridaMarco = velocidadMarco * horas;
            distanciaMarco = distanciaMarco - distanciaRecorridaMarco;

            // Avance de la madre
            double velocidadMadreActual = velocidadMadre;
            int horasMadre = horasRecorridoMadre;

            // Verificar el clima de la madre
            double climaMadre = random.nextDouble();

            // LLuvia fuerte reduce en 50% la velocidad
            if (climaMadre < 0.1) {

                velocidadMadreActual = velocidadMadreActual * 0.5;

            } else

                // LLuvia normal reduce en 25% la velocidad
                if (climaMadre < 0.4) {

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

            // Impresión de la bitácora diaria
            System.out.println("Día " + dias + ": ");
            System.out.println("Hoy logré recorrer: " + Math.floor(distanciaRecorridaMarco)  + " km");
            System.out.println("La madre de Marco pudo recorrer " + Math.floor(distanciaRecorridaMadre)  + " km");
            System.out.println("El clima estuvo " + estadoClima);
            System.out.println("La madre se encuentra a una distancia de " + Math.floor(distanciaMarco)  + " km de Marco");
            System.out.println("  ");

        }

        System.out.println("Finalmente a los  " + dias + " días de búsqueda, Marco encuentra a su madre");

    }

}
