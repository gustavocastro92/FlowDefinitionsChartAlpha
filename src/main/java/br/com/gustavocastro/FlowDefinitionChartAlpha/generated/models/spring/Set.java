//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.29 at 06:58:45 PM BRT 
//


package br.com.gustavocastro.FlowDefinitionChartAlpha.generated.models.spring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.springframework.org/schema/beans}listOrSetType"&gt;
 *       &lt;attribute name="merge" type="{http://www.springframework.org/schema/beans}defaultable-boolean" default="default" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "set")
public class Set
    extends ListOrSetType
{

    @XmlAttribute(name = "merge")
    protected DefaultableBoolean merge;

    /**
     * Gets the value of the merge property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultableBoolean }
     *     
     */
    public DefaultableBoolean getMerge() {
        if (merge == null) {
            return DefaultableBoolean.DEFAULT;
        } else {
            return merge;
        }
    }

    /**
     * Sets the value of the merge property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultableBoolean }
     *     
     */
    public void setMerge(DefaultableBoolean value) {
        this.merge = value;
    }

}
