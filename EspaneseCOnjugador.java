import java.lang.String;
public class EspaneseCOnjugador {

    public static String madre(String palabra){
        int largoDeLaPalabra = palabra.length();
        return palabra.substring(largoDeLaPalabra - 2);
    }

    public static String raíz(String palabra){
        int largoDeLaPalabra = palabra.length();
        return palabra.substring(0, largoDeLaPalabra - 2);
    }

    public static void Espanol1(String pronombre, String verbo){

        pronombre = pronombre.toLowerCase(); verbo = verbo.toLowerCase(); //hace minisculas las palabras porque es más fácil
        int largoDelVerbo = verbo.length();
        String madre = madre(verbo);
        String raíz = raíz(verbo); //el verbo sin madre

        // crea el parte de la palabra que se conjuga
        String nuevoFinal = null;
        boolean singular1a = pronombre.equals("yo");
        boolean singular2a = pronombre.equals("tu") || pronombre.equals("tú");
        boolean singular3a = pronombre.equals("el") || pronombre.equals("él") || pronombre.equals("ella") || pronombre.equals("usted");
        boolean plural1a = pronombre.equals("nosotros") || pronombre.equals("nosotras");
        boolean plural3a = pronombre.equals("ellos") || pronombre.equals("ellas") || pronombre.equals("ustedes");
        //esta parte crea booleanes para las tenses

        if (singular1a) nuevoFinal = "o";
            //porque cada verbo en la primera persona termina con "o", yo hago ese porque sí
        else {
            if (madre.equals("ar")) {
                if (singular2a) nuevoFinal = "as"; // si es en la segunda persona y singular:
                if (plural1a) nuevoFinal = "amos"; // si es en la primera persona y plural:
                if (singular3a) nuevoFinal = "a"; // si es en la tercera persona y singular:
                if (plural3a) nuevoFinal = "an"; // si es en la tercera persona y plural:
            }
            if (madre.equals("er") || madre.equals("ir")) {
                if (singular2a) nuevoFinal = "es"; // si es en la segunda persona y singular:
                if (plural1a) { // si es en la primera persona y plural:
                    if (madre.equals("ir")) nuevoFinal = "imos"; // si la palabra termina con -ir:
                    else nuevoFinal = "emos"; // si la palabra termina con -er:
                }
                if (singular3a) nuevoFinal = "e"; // si es en la tercera persona y singular:
                if (plural3a) nuevoFinal = "en"; // si es en la tercera persona y plural:
            }
        }
        //esta parte cambia el final

        System.out.println(raíz.concat(nuevoFinal)); // crea la palabra conjugada e la imprime
    }
}
