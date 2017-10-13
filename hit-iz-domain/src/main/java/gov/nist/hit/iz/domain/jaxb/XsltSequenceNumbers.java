//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.11 at 09:15:53 PM EDT 
//


package gov.nist.hit.iz.domain.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="FieldElement">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="SegmentName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="FieldName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Position" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fieldElement"
})
@XmlRootElement(name = "XsltSequenceNumbers")
public class XsltSequenceNumbers {

    @XmlElement(name = "FieldElement", required = true)
    protected List<XsltSequenceNumbers.FieldElement> fieldElement;

    /**
     * Gets the value of the fieldElement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldElement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFieldElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XsltSequenceNumbers.FieldElement }
     * 
     * 
     */
    public List<XsltSequenceNumbers.FieldElement> getFieldElement() {
        if (fieldElement == null) {
            fieldElement = new ArrayList<XsltSequenceNumbers.FieldElement>();
        }
        return this.fieldElement;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="SegmentName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="FieldName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Position" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class FieldElement {

        @XmlAttribute(name = "SegmentName", required = true)
        protected String segmentName;
        @XmlAttribute(name = "FieldName", required = true)
        protected String fieldName;
        @XmlAttribute(name = "Position", required = true)
        protected int position;

        /**
         * Gets the value of the segmentName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSegmentName() {
            return segmentName;
        }

        /**
         * Sets the value of the segmentName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSegmentName(String value) {
            this.segmentName = value;
        }

        /**
         * Gets the value of the fieldName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFieldName() {
            return fieldName;
        }

        /**
         * Sets the value of the fieldName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFieldName(String value) {
            this.fieldName = value;
        }

        /**
         * Gets the value of the position property.
         * 
         */
        public int getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         * 
         */
        public void setPosition(int value) {
            this.position = value;
        }

    }

}