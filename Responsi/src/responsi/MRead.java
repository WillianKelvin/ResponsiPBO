
package responsi;

public class MRead {
    //untuk menghubungkan 3 kelas view model dan controller
    Read read = new Read();
    Model model = new Model();
    RController controller = new RController(model, read);
}
