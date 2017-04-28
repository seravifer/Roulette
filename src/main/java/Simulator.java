import java.util.concurrent.TimeUnit;

public class Simulator {
    private Player player;
    private Roulette roulette;
    private static final double min = 1;
    private double pay = 1;

    private int number;
    private int repite = 1;

    private int pos = 0; // Fibonacci

    public Simulator(Player p, Roulette r) {
        player = p;
        roulette = r;
    }

    // http://trucosyastucias.com/trucos-para-ganar-dinero/estrategias-ruleta
    // http://trucosyastucias.com/trucos-para-ganar-dinero/estrategias-trucos-ruleta#reverse-fibonacci
    // Sistema basado en cuadros
    // Sistema Fortaleza Real
    // Triángulo numérico
    // Estrategia de Finales
    // Sistema Labouchere (Inverso)
    // Estrategia de Oscar
    


    /**
     * Fibonacci
     * If you win reduces 2 positions in the Fibonacci scale
     * If you lose you increase 1 on the Fibonacci scale
     *
     * @param s Bet
     * @return
     */
    public void fibonacci(String s) {
        int i = roulette.getActualNumber();
        String c = Roulette.color(i);

        if(c.equals(s)) {
            player.payment(fibonacciNumber(pos));
            if(pos > 1 ) pos -= 2; // Avoid negative numbers
        } else {
            player.payment(-fibonacciNumber(pos));
            pos += 1;
        }
        System.out.println("Color: " + c + " Apuesta: " + pay + " Dinero: " + player.getMoney() + "€");
    }

    private int fibonacciNumber(int n) {
        if ((n == 0) || (n == 1)) return 1;
        else return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }

    /**
    * Martingala
    * Si ganas vuelves a la puesta inicial
    * Si pierdes dublicas lo apostado
    */
    public void martingala(String s) {
        int i = roulette.getActualNumber();
        String c = Roulette.color(i);

        if(c.equals(s)) {
            player.payment(pay);
            pay = min;
        } else {
            player.payment(-pay); // Ley de los grandes números
            pay = pay * 2;
        }
        System.out.println("Color: " + c + " Apuesta: " + pay + " Dinero: " + player.getMoney() + "€");
    }

    /**
    * Martingala
    * Si ganas duplicas la apuesta
    * Si pierdo vuelvo a la apuesta inicial
    * */
    public void martingalaInverse(String s) {
        int i = roulette.getActualNumber();
        String c = Roulette.color(i);

        if(c.equals(s)) {
            player.payment(pay);
            pay = pay *2;
        } else {
            player.payment(-pay); // Ley de los grandes números
            pay = min;
        }
        System.out.println("Color: " + c + " Apuesta: " + pay + " Dinero: " + player.getMoney() + "€");
    }

    /**
    * Estrategia Paroli
    * Si ganas aumentas la apuesta hasta racha de x (lo decide el jugador)
    * Si pierdes vuelves a la apuesta principal
    */
    public void paroli(String s) { // SIN ACABAR
        int i = roulette.getActualNumber();
        String c = Roulette.color(i);

        if(c.equals(s)) {
            player.payment(pay);
            pay = 0;
        } else {
            player.payment(-pay); // Ley de los grandes números
            pay = min;
        }
        System.out.println("Color: " + c + " Apuesta: " + pay + " Dinero: " + player.getMoney() + "€");
    }

    /**
    * Sistema D’Alembert
    * Si gano bajo la apuesta 1
    * Si pierdo subo la apuesta 1
    *
    * Variante de Wells
    * D’Alembert Inverso
    * */
    public void alembert(String s) {
        int i = roulette.getActualNumber();
        String c = Roulette.color(i);

        if(c.equals(s)) {
            player.payment(pay);
            if(pay>1) pay -= 1;
        } else {
            player.payment(-pay);
            pay += 1;
        }
        System.out.println("Color: " + c + " Apuesta: " + pay + " Dinero: " + player.getMoney() + "€");
    }


    /**
    * 9 pins
    * Elges un numero, y lo apuestas en las siguientes 9 rondas
    * Si ganas sigues apostando a ese nunmero
    * Si pierdes cambias al numero de la 9 ronda
    * */
    public void pins() {
        int i = roulette.getActualNumber();
        System.out.print("Numero: " + i + " Dinero: " + player.getMoney() + "€");
        if(roulette.getNumMatches() == 1) {
            number = i;
        } else {
            if(i == number) {
                player.payment(37);
                repite = 1;
            } else {
                if(repite < 9) {
                    repite++;
                } else {
                    number = i;
                    repite = 1;
                }
                player.payment(-pay);
            }
        }
        System.out.println("Numero: " + number + " Apuesta: " + pay + " Dinero: " + player.getMoney() + "€");
    }

    /**
     * James Bond
     *
     */
    public void bond(int n) {
        int i = roulette.getActualNumber();

        double m1 = n * 0.7;
        double m2 = n * 0.25;
        double m3 = n * 0.05;

        if (i >= 19) {
            player.payment((m1 * 2) - n);
        } else if (i >= 12 && i <= 18) {
            player.payment((m2 * 8) - n);
        } else if (i == 0) {
            player.payment((m3 * 36) - n);
        } else {
            player.payment(-n);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Player p = new Player(5);
        Roulette r = new Roulette();
        Simulator s = new Simulator(p, r);
        while (true) {
            r.spin();
            //s.martingala("Black");
            //s.martingalaInverse("Black");
            //s.alembert("Black");
            //s.fibonacci("Red");
            //s.pins();
            s.bond(1);
            if(p.getMoney()<=0) {
                break;
            }
            TimeUnit.MILLISECONDS.sleep(50);
        }
    }

}