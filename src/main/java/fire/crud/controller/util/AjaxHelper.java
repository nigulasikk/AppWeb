package fire.crud.controller.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AjaxHelper {

	final private static Logger LOGGER = LoggerFactory.getLogger(AjaxHelper.class);

	public static ResponseEntity<AjaxResult> makeResult(AjaxResult ajaxResult) {
		LOGGER.debug("ajaxResult: {}", ajaxResult.toString());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=utf-8");
		return new ResponseEntity<AjaxResult>(ajaxResult, responseHeaders, HttpStatus.OK);

	}

}
