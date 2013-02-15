package il.co.brandis.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public class FileUploaderUtil {

	public static void saveFile(MultipartFile file, String saveDir)
			throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();
		
		System.out.println("Saving file: "
				+ file.getOriginalFilename());

		if (!fileName.equals("")) {
			file.transferTo(new File(saveDir
					+ fileName));
		}

	}
}
