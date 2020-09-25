package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class FileManager {
	Properties pro;

	public FileManager() {

		try {
			FileInputStream fis = new FileInputStream("F:\\WORK\\carbon\\Env.properties");
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Environoment file not found");
		}
	}

	public String getQatUrl() {
		String url = pro.getProperty("qat");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("qat url not found");
		}
	}

	public String getPreProductionUrl() {
		String url = pro.getProperty("prepro");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("pre Production url not found");
		}
	}

	public String getProductionUrl() {
		String url = pro.getProperty("pro");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException(" Production url not found");
		}
	}
	
	public long getImplictilyTime() {
		String val = pro.getProperty("impilictlyWait");
		long key = Long.parseLong(val);
		return key;
	}

}
