/**
 * This software was developed at the National Institute of Standards and Technology by employees of
 * the Federal Government in the course of their official duties. Pursuant to title 17 Section 105
 * of the United States Code this software is not subject to copyright protection and is in the
 * public domain. This is an experimental system. NIST assumes no responsibility whatsoever for its
 * use by other parties, and makes no guarantees, expressed or implied, about its quality,
 * reliability, or any other characteristic. We would appreciate acknowledgement if the software is
 * used. This software can be redistributed and/or modified freely provided that any derivative
 * works bear some notice that they are derived from it, and any modified versions bear some notice
 * that they have been modified.
 */

package gov.nist.hit.iz.web.controller;

import gov.nist.hit.core.service.exception.MessageException;
import gov.nist.hit.core.service.exception.TestCaseException;
import gov.nist.hit.core.service.util.HtmlUtil;
import gov.nist.hit.core.service.util.PdfGeneratorUtil;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

/**
 * @author Harold Affo (NIST)
 * 
 */

@RequestMapping("/testartifact")
@RestController
public class TestArtifactController extends TestingController {

  static final Logger logger = LoggerFactory.getLogger(TestArtifactController.class);

  @RequestMapping(value = "/download", method = RequestMethod.POST,
      consumes = "application/x-www-form-urlencoded; charset=UTF-8")
  public String download(@RequestParam("path") String path, HttpServletRequest request,
      HttpServletResponse response) throws MessageException {
    try {
      if (path != null && path.endsWith("pdf")) {
        InputStream content = null;
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        content = TestArtifactController.class.getResourceAsStream("/" + path);
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        FileCopyUtils.copy(content, response.getOutputStream());
      }

      throw new IllegalArgumentException("Invalid Path Provided");
    } catch (IOException e) {
      logger.debug("Failed to download the test package ");
      throw new TestCaseException("Cannot download the artifact " + e.getMessage());
    }

  }


  @RequestMapping(value = "/generateJurorDoc/pdf", method = RequestMethod.POST,
      consumes = "application/x-www-form-urlencoded; charset=UTF-8")
  public String generatePdf(@RequestParam("html") String html, @RequestParam("type") String type,
      @RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response)
      throws MessageException {
    try {
      if (html != null) {

        // StringBuffer buf = new StringBuffer();
        // buf.append("<html><head>");
        // buf.append("<style type='text/css'>");
        // buf.append("@media screen{.jurordocument fieldset{font-size:100%}.jurordocument table tbody tr th{font-size:90%}.jurordocument table tbody tr td{font-size:90%}}@media print{.jurordocument fieldset{font-size:x-small;page-break-inside:avoid}.jurordocument table{float:none!important;page-break-before:avoid;overflow:visible!important;position:relative}.jurordocument table tr{page-break-inside:avoid}.jurordocument table th{font-size:x-small}.jurordocument table td{font-size:xx-small}* [type = text]{width:98%;height:15px;margin:2px;padding:0;background:1px #ccc}.jurordocument h3{font-size:xx-small}.jurordocument p{font-size:x-small}.jurordocument * [type = checkbox]{width:10px;height:10px;margin:2px;padding:0;background:1px #ccc}}.jurordocument * [type = text]{width:95%}.jurordocument fieldset{width:95%;border:1px solid #446bec}.embSpace{padding-left:25px}.noData{background:#d2d2d2}.jurordocument table{width:98%;border:1px groove;margin:0 auto;page-break-inside:avoid}.jurordocument table tr{border:1px groove}.jurordocument table th{border:1px groove}.jurordocument table td{border:1px groove;empty-cells:show}.jurordocument table thead{border:1px groove;background:#446bec;text-align:center;color:white}.jurordocument table[id = inspectionStatus] thead tr th:last-child{width:2%;color:black}.jurordocument table[id = inspectionStatus] thead tr th:nth-last-child(2){width:2%;color:black}.jurordocument table[id = inspectionStatus] thead tr th:nth-last-child(3){width:45%}.jurordocument table tbody tr th{text-align:center;background:#c6deff}.jurordocument table tbody tr td{text-align:left}.jurordocument table tbody tr td [type = text]{text-align:left;margin-left:1%}.jurordocument table caption{font-weight:bold;color:#0840f8}</style>");
        // buf.append("</style></head>");
        // buf.append("<body>");
        // buf.append(html);
        // buf.append("</body>");
        // buf.append("</html>");
        // html = buf.toString();
        html = HtmlUtil.htmlToXhtml(html);
        System.out.print(html);
        InputStream content = PdfGeneratorUtil.genereate(type, name, html);
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment;filename=" + type + ".pdf");
        FileCopyUtils.copy(content, response.getOutputStream());
      }
      throw new IllegalArgumentException("Invalid Path Provided");
    } catch (IOException | DocumentException e) {
      logger.debug("Failed to download the test package ");
      throw new TestCaseException("Cannot download the artifact " + e.getMessage());
    }

  }


}
