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

import gov.nist.hit.core.domain.Command;
import gov.nist.hit.core.domain.ConnectionType;
import gov.nist.hit.core.domain.Message;
import gov.nist.hit.core.domain.Stage;
import gov.nist.hit.core.domain.TestPlan;
import gov.nist.hit.core.domain.TestStep;
import gov.nist.hit.core.domain.TransactionCommand;
import gov.nist.hit.core.domain.util.XmlUtil;
import gov.nist.hit.core.repo.TestPlanRepository;
import gov.nist.hit.core.repo.TestStepRepository;
import gov.nist.hit.core.service.exception.TestCaseException;
import gov.nist.hit.core.transport.TransportClient;
import gov.nist.hit.core.transport.TransportClientException;
import gov.nist.hit.iz.service.util.ConnectivityUtil;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harold Affo (NIST)
 */
@RequestMapping("/isolated")
@RestController
public class IsolatedSystemTestingController extends TestingController {


  static final Logger logger = LoggerFactory.getLogger(IsolatedSystemTestingController.class);


  String SUMBIT_SINGLE_MESSAGE_TEMPLATE = null;

  @Autowired
  private TestPlanRepository testPlanRepository;


  @Autowired
  private TransportClient transportClient;

  public IsolatedSystemTestingController() throws IOException {
    SUMBIT_SINGLE_MESSAGE_TEMPLATE =
        IOUtils.toString(IsolatedSystemTestingController.class
            .getResourceAsStream("/templates/SubmitSingleMessage.xml"));
  }


  @Autowired
  private TestStepRepository testStepRepository;


  @RequestMapping(value = "/testcases", method = RequestMethod.GET)
  public List<TestPlan> testCases() {
    logger.info("Fetching all isolated system test cases...");
    List<TestPlan> testPlans = testPlanRepository.findAllByStage(Stage.ISOLATED);
    return testPlans;
  }


  @RequestMapping(value = "/soap/send", method = RequestMethod.POST)
  public Command sendRequest(@RequestBody TransactionCommand command)
      throws TransportClientException {
    logger.info("Sending ... " + command);
    try {
      Long testCaseId = command.getTestCaseId();
      TestStep testStep = testStepRepository.findOne(testCaseId);
      if (testStep == null)
        throw new TestCaseException("Unknown test step with id=" + testCaseId);
      String request = command.getContent();
      Message req = testStep.getTestContext().getMessage();
      if (testStep.getConnectionType().equals(ConnectionType.SUT_RESPONDER)) {
        request =
            ConnectivityUtil.updateSubmitSingleMessageRequest(SUMBIT_SINGLE_MESSAGE_TEMPLATE,
                req.getContent(), command.getU(), command.getP(), command.getFacilityId());
      }
      String response = transportClient.send(request, command.getEndpoint());
      String tmp = response;
      try {
        response = XmlUtil.prettyPrint(response);
      } catch (Exception e) {
        response = tmp;
      }
      return new TransactionCommand(request, response);
    } catch (Exception e1) {
      throw new TransportClientException("Failed to send the message." + e1.getMessage());
    }

  }

}
