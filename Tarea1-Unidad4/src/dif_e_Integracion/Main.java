package dif_e_Integracion;

public class Main {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 1.0;
        double tolerancia = 0.00001;

        System.out.println("=========================================================");
        System.out.println("   ANÁLISIS COMPARATIVO: TRAPECIO VS SIMPSON 1/3        ");
        System.out.println("=========================================================");
        System.out.printf("Intervalo de integración: [%.2f, %.2f]\n", a, b);
        System.out.printf("Tolerancia establecida: %.6f\n\n", tolerancia);

        System.out.println("--- Ejecución Trapecio Compuesto ---");
        TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);

        System.out.println("\n--- Ejecución Simpson 1/3 Compuesto ---");
        SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);
    }
}