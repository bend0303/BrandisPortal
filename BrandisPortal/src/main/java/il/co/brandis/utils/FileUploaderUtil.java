/*
 * @(#)FileUploaderUtil.java     22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.utils;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * The FileUploaderUtil class the Utility which will be used in order to upload files
*/
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
