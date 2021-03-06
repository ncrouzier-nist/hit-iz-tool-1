//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.11 at 09:14:57 PM EDT 
//


package gov.nist.hit.iz.domain.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageFailureV3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageFailureV3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Result" use="required" type="{http://www.nist.gov/healthcare/validation}AssertionResultConstants" />
 *       &lt;attribute name="Type" use="required" type="{http://www.nist.gov/healthcare/validation}AssertionTypeV3Constants" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageFailureV3", namespace = "http://www.nist.gov/healthcare/validation/message/hl7/v3/context")
public class MessageFailureV3 {

    @XmlAttribute(name = "Result", required = true)
    protected AssertionResultConstants result;
    @XmlAttribute(name = "Type", required = true)
    protected AssertionTypeV3Constants type;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link AssertionResultConstants }
     *     
     */
    public AssertionResultConstants getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssertionResultConstants }
     *     
     */
    public void setResult(AssertionResultConstants value) {
        this.result = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AssertionTypeV3Constants }
     *     
     */
    public AssertionTypeV3Constants getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssertionTypeV3Constants }
     *     
     */
    public void setType(AssertionTypeV3Constants value) {
        this.type = value;
    }

}
