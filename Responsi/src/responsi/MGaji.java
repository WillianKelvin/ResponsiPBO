
package responsi;

public class MGaji {
    Gaji gaji = new Gaji();
    GajiModel model = new GajiModel();
    GajiController controller = new GajiController(model, gaji);
}
