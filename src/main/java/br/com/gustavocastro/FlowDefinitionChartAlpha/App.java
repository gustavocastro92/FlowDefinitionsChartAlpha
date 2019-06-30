package br.com.gustavocastro.FlowDefinitionChartAlpha;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.gustavocastro.FlowDefinitionChartAlpha.Services.BeanHandlerService;
import br.com.gustavocastro.FlowDefinitionChartAlpha.generated.models.spring.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {

			File file = new File(args[0]);
			JAXBContext jaxbContext = JAXBContext.newInstance(Beans.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Beans beans = (Beans) jaxbUnmarshaller.unmarshal(file);
			Bean bean = (Bean) beans.getImportOrAliasOrBean().get(0);
			
			BeanHandlerService bhs = new BeanHandlerService(beans.getImportOrAliasOrBean());
			bhs.printRootBeans();
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
