package fire.crud.controller.ckeditor;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fire.crud.controller.util.FileUploadPath;
import fire.crud.controller.util.Login;
import fire.crud.controller.util.ResultTypeEnum;
import fire.crud.controller.util.ViewPath;

@Controller()
@RequestMapping(value = "/ckeditor")
public class CkeditorFileuploadController {

	final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * @param sentence
	 * @return
	 */
	@Login
	// TODO 可能提示后,页面出错
	// @FireAuthority({AuthorityType.First_Notice,AuthorityType.Distributor_Notice})
	@RequestMapping(value = "/upload.spr", method = RequestMethod.POST)
	public String save(MultipartFile upload, @ModelAttribute("CKEditorFuncNum") String CKEditorFuncNum, Model model) {
		// 更新图片
		if (upload != null && !upload.isEmpty()) {
			String extenstion = FilenameUtils.getExtension(upload.getOriginalFilename());
			logger.debug("extenstion is {}", extenstion);

			String distName = new Date().getTime() + "." + extenstion;

			File distFile = new File(FileUploadPath.CKEDITOR_FILEUPLOAD_IMAGE, distName);
			logger.debug("file name is {}", distName);
			//
			try {
				FileUtils.copyInputStreamToFile(upload.getInputStream(), distFile);
			} catch (IOException e) {
				logger.warn("图像上传出错了{}", e);
			}
			// produceOrder.setBoxPositiveMarkImage(distName);
			model.addAttribute("filePath", FileUploadPath.CKEDITOR_IMAGE_SHORT_PATH + "/" + distName);
			model.addAttribute("result", true);
		} else {
			model.addAttribute("result", false);
		}

		return ViewPath.CKIMAGE_UPLOAD_RESULT;
	}

	/**
	 * 
	 * @return
	 */
	@Login
	// @FireAuthority({AuthorityType.First_Notice,AuthorityType.Distributor_Notice})
	@RequestMapping(value = "/listFiles.spr", method = RequestMethod.GET)
	public String listFiles(@ModelAttribute("CKEditorFuncNum") String CKEditorFuncNum, Model model) {

		File file = new File(FileUploadPath.CKEDITOR_FILEUPLOAD_IMAGE);
		model.addAttribute("webPath", FileUploadPath.CKEDITOR_IMAGE_SHORT_PATH);
		model.addAttribute("files", file.listFiles());
		return ViewPath.CKIMAGE;
	}

	/**
	 * 
	 * @return
	 */
	@Login(ResultTypeEnum.json)
	// @FireAuthority({AuthorityType.First_Notice,AuthorityType.Distributor_Notice})
	@RequestMapping(value = "/deleteFile.spr", method = RequestMethod.GET)
	@ResponseBody
	public boolean deleteFile(String fileName) {
		String uploadDir = FileUploadPath.CKEDITOR_FILEUPLOAD_IMAGE + "/" + fileName;
		File file = new File(uploadDir);
		if (file.exists() == false) {
			return true;
		}

		file.delete();

		if (file.exists() == false) {
			return true;
		}

		return false;
	}
}
