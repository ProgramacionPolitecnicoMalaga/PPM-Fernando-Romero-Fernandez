import com.politecnicomalaga.*;

public class App {
    public static void main(String[] args) {
        PackBuilder packBasicoBuilder = new PackBasicoBuilder();
        DirectorPack director = new DirectorPack(packBasicoBuilder);
        Pack packBasico = director.crearPackBasico();
        System.out.println(packBasico);

        PackBuilder packRomanceBuilder = new PackRomanceBuilder();
        DirectorPack director3 = new DirectorPack(packRomanceBuilder);
        Pack packRomance = director3.crearPackRomance();
        System.out.println(packRomance);

        PackBuilder packDeluxeBuilder = new PackDeluxeBuilder();
        DirectorPack director2 = new DirectorPack(packDeluxeBuilder);
        Pack packDeluxe = director2.crearPackDeluxe();
        System.out.println(packDeluxe);
    }
}
