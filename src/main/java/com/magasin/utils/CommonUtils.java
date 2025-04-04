package com.magasin.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {
	public static Long generateMilliSeconds() {
		Calendar calendar = Calendar.getInstance();
		// calendar.set(Calendar.MILLISECOND, 0); // Clear the millis part. Silly API.
		// calendar.set(2010, 8, 14, 0, 0, 0); // Note that months are 0-based
		Date date = calendar.getTime();
		Long millis = date.getTime(); // Millis since Unix epoch
		return millis;
	}

	public static String uploadFile(String storagePath, String fileName, byte[] bytes) {
		String filePath = null;
		try {
			String mainDirectoryName = Paths.get(storagePath).getFileName().toString();
			storagePath = storagePath.replace(mainDirectoryName, "");
			///// folder months and year
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			Path mainDirectoryNameWithDate = Paths.get(mainDirectoryName, month + "-" + year);
			mainDirectoryName = mainDirectoryNameWithDate.toString();

			Path dirPath = Paths.get(storagePath, mainDirectoryName);
			File directory = new File(dirPath.toString());

			if (!directory.exists()) {
				directory.mkdirs();
			}

			Path path = Paths.get(dirPath.toString(), fileName);

			Files.write(path, bytes);

			filePath = path.toString();

			return filePath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
