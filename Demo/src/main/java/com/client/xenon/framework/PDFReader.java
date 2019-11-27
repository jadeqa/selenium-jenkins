package com.client.xenon.framework;
/*package com.sal.xenon.framework;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFReader {

	public String GetBatchName(String url1) {
		try {
			PDDocument document = null;
			File file = new File("abcd.pdf");
			FileUtils.copyURLToFile(new URL(url1), file);

			URL url = new URL(url1);
			try (InputStream in = url.openStream()) {
				Files.copy(in, Paths.get("someFile.jpg"), StandardCopyOption.REPLACE_EXISTING);

				document = PDDocument.load(in);
				document.getClass();
				if (!document.isEncrypted()) {
					PDFTextStripperByArea stripper = new PDFTextStripperByArea();
					stripper.setSortByPosition(true);
					PDFTextStripper Tstripper = new PDFTextStripper();
					String st = Tstripper.getText(document);
					System.out.println("Text:" + st);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}

	public InputStream downloadFile(URL url) {
		try {
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(300000);
			conn.setReadTimeout(300000);
			conn.connect();

			return url.openStream();
		} catch (IOException e) {
			// Log error and return null, some default or throw a runtime exception
		}
		return null;
	}
}
*/