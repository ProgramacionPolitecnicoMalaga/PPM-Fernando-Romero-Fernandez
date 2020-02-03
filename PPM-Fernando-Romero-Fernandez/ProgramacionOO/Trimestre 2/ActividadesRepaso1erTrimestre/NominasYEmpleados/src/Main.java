public class Main {
    public static void main(String[] args) {
        GestorDeNominas gestorDeNominas = new GestorDeNominas();
        System.out.println(gestorDeNominas.calcularNomina(new Comisionados("Fernando", "Romero", 5)));
        System.out.println(gestorDeNominas.calcularNomina(new PorHoras("Facundo","De Nardo",8)));
        System.out.println(gestorDeNominas.calcularNomina(new Asalariados("Alberto", "Gandoy")));
    }
}
