package demo;

import java.io.FileWriter;
import java.io.IOException;

public class ConvertCsv {

	public static void main(String[] args) {

		try {

			   FileWriter fw = new FileWriter("helloworld.csv");
			   String header = "trdate,hpr,lpr,tradeVolumn\r\n";
			   fw.write(header);
			   for (int i = 0; i < 10 * 100; i++) {
			    StringBuffer str = new StringBuffer();
			    for (int j = 0; j < 100; j++) {
			     str.append("2010-12-31,19,15,140000\r\n");
			    }
			    fw.write(str.toString());
			    fw.flush();

			   }
			   fw.close();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}

}
