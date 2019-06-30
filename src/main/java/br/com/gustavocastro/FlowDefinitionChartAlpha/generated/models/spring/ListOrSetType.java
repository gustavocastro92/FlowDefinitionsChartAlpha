//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.29 at 06:58:45 PM BRT 
//


package br.com.gustavocastro.FlowDefinitionChartAlpha.generated.models.spring;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listOrSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listOrSetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.springframework.org/schema/beans}collectionType"&gt;
 *       &lt;group ref="{http://www.springframework.org/schema/beans}collectionElements"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listOrSetType", propOrder = {
    "description",
    "beanOrRefOrIdref"
})
@XmlSeeAlso({
    Array.class,
    Set.class,
    br.com.gustavocastro.FlowDefinitionChartAlpha.generated.models.spring.List.class
})
public class ListOrSetType
    extends CollectionType
{

    protected Description description;
    @XmlElementRefs({
        @XmlElementRef(name = "bean", namespace = "http://www.springframework.org/schema/beans", type = Bean.class, required = false),
        @XmlElementRef(name = "ref", namespace = "http://www.springframework.org/schema/beans", type = Ref.class, required = false),
        @XmlElementRef(name = "idref", namespace = "http://www.springframework.org/schema/beans", type = Idref.class, required = false),
        @XmlElementRef(name = "value", namespace = "http://www.springframework.org/schema/beans", type = Value.class, required = false),
        @XmlElementRef(name = "null", namespace = "http://www.springframework.org/schema/beans", type = Null.class, required = false),
        @XmlElementRef(name = "array", namespace = "http://www.springframework.org/schema/beans", type = Array.class, required = false),
        @XmlElementRef(name = "list", namespace = "http://www.springframework.org/schema/beans", type = br.com.gustavocastro.FlowDefinitionChartAlpha.generated.models.spring.List.class, required = false),
        @XmlElementRef(name = "set", namespace = "http://www.springframework.org/schema/beans", type = Set.class, required = false),
        @XmlElementRef(name = "map", namespace = "http://www.springframework.org/schema/beans", type = Map.class, required = false),
        @XmlElementRef(name = "props", namespace = "http://www.springframework.org/schema/beans", type = Props.class, required = false)
    })
    @XmlAnyElement(lax = true)
    protected java.util.List<Object> beanOrRefOrIdref;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
    }

    /**
     * Gets the value of the beanOrRefOrIdref property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the beanOrRefOrIdref property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBeanOrRefOrIdref().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bean }
     * {@link Ref }
     * {@link Idref }
     * {@link Value }
     * {@link Null }
     * {@link Array }
     * {@link br.com.gustavocastro.FlowDefinitionChartAlpha.generated.models.spring.List }
     * {@link Set }
     * {@link Map }
     * {@link Props }
     * {@link Object }
     * 
     * 
     */
    public java.util.List<Object> getBeanOrRefOrIdref() {
        if (beanOrRefOrIdref == null) {
            beanOrRefOrIdref = new ArrayList<Object>();
        }
        return this.beanOrRefOrIdref;
    }

}
