
package pruebasbomberman;

public class PruebasBomberman {

    public static int clevels = 0;    
    /* Probar hacer arreglo de objetos. Los objetos a meter en el arreglo serían:
        Ladrillo, Jugador, Enemigo, Bonus, Final y Null*/
    public static String[][][] levels = {
        // Lvl 1
        {
            {"L", "J", "L", "L", "E", "L", "L", "B", "N", "L", "L", "L"},
            {"L", "L", "L", "N", "N", "L", "L", "L", "L", "N", "N", "N"},
            {"L", "L", "L", "N", "N", "N", "N", "N", "N", "L", "N", "N"},
            {"L", "L", "L", "L", "N", "L", "N", "L", "N", "L", "L", "N"},
            {"L", "L", "L", "N", "N", "N", "L", "N", "L", "L", "L", "L"},
            {"L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L"},
            {"L", "L", "L", "L", "N", "L", "L", "L", "N", "L", "L", "N"},
            {"L", "N", "N", "N", "L", "N", "N", "L", "N", "L", "N", "L"},
            {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
            {"B", "N", "N", "L", "N", "N", "L", "N", "N", "L", "L", "L"},
            {"N", "N", "N", "N", "N", "N", "N", "N", "N", "L", "L", "F"},
            {"L", "L", "L", "L", "E", "N", "N", "L", "L", "L", "N", "N"}
        },
        // Lvl 2
        {
            {"L","L","L","L","L","L","N","L","L","J","L","L"},
            {"N","L","L","N","N","L","B","L","L","N","L","L"},
            {"N","E","L","N","L","L","N","L","N","L","L","L"},
            {"B","N","L","N","N","N","L","L","N","N","N","N"},
            {"N","N","N","N","N","N","N","N","E","N","N","N"},
            {"L","L","L","L","L","N","L","N","L","L","L","L"},
            {"N","N","N","N","N","L","L","L","L","L","L","N"},
            {"N","N","N","N","N","N","N","N","N","L","N","N"},
            {"L","L","L","E","L","L","N","N","N","L","E","N"},
            {"L","F","L","N","N","N","N","N","N","L","B","N"},
            {"L","L","L","B","N","L","L","L","L","L","N","L"},
            {"L","L","L","N","N","N","N","N","N","N","N","N"}
        },
        // Lvl 3
        {
            {"E","B","L","L","L","N","N","L","L","L","N","N"},
            {"L","L","N","L","N","E","N","N","N","L","L","B"},
            {"L","L","J","L","N","N","L","N","N","L","L","L"},
            {"L","L","L","L","N","N","L","L","N","E","L","L"},
            {"L","E","N","N","N","N","N","L","N","N","L","F"},
            {"L","L","L","L","L","L","L","L","L","L","L","L"},
            {"L","L","N","N","N","N","N","L","N","L","L","L"},
            {"B","L","L","E","N","N","L","B","L","N","L","L"},
            {"N","L","N","N","N","N","N","L","L","L","N","L"},
            {"N","L","N","N","N","N","E","L","L","N","E","L"},
            {"N","L","L","L","L","N","N","B","L","L","L","L"},
            {"E","N","N","N","L","L","L","L","N","L","L","N"}

        }
    };
    public static void main(String[] args) {        
        Menu menu = new Menu();
        menu.show();
    }
    
}
