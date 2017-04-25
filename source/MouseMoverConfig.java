import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MouseMoverConfig {

	private static Properties config = new Properties();
    private static String arquivo = "config.ini";//local do arquivo

    public static void main(String[] args) throws Exception {

		try {
				config.load(new FileInputStream(arquivo));
				String SET_SECONDS = config.getProperty("SET_SECONDS");
				String MAX_Y = config.getProperty("MAX_Y");
				String MAX_X = config.getProperty("MAX_X");
				
				Robot robot = new Robot();
				Random random = new Random();
				while (true) {
					robot.mouseMove(random.nextInt(Integer.parseInt(MAX_X)), random.nextInt(Integer.parseInt(MAX_Y)));
					Thread.sleep(Integer.parseInt(SET_SECONDS));
				}
			} catch (IOException ex) {
                        Logger.getLogger(MouseMoverConfig.class.getName()).log(Level.SEVERE, null, ex);
			}
    }
}