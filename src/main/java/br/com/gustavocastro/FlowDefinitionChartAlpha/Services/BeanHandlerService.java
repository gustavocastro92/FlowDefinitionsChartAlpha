package br.com.gustavocastro.FlowDefinitionChartAlpha.Services;

import org.codehaus.plexus.util.dag.Vertex;
import org.w3c.dom.Node;

import com.mxgraph.io.mxCodec;
import com.mxgraph.model.mxGraphModel;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxGraph;

import br.com.gustavocastro.FlowDefinitionChartAlpha.generated.models.spring.*;
import br.com.gustavocastro.FlowDefinitionChartAlpha.models.inter.Router;

public class BeanHandlerService {

	private static final int ELIPSE_SIZE = 80;
	private static final int DEFAULT_NODE_WIDTH = 150;
	private static final int HEIGHT_ADD_VALUE = 150;
	
	private java.util.List<Bean> beanList;
	private mxGraphModel mx;
	private mxGraph mg;
	private int x = 200, y;
	private Object parent;
	Object lastMv;

	@SuppressWarnings("unchecked")
	public BeanHandlerService(Object beanList) {
		this.beanList = (java.util.List<Bean>) beanList;
	}

	private void initializeMx() {
		this.mx = new mxGraphModel();
		this.mg = new mxGraph(mx);
		this.y = 0;
		this.parent = mg.getDefaultParent();
	}

	public void printRootBeans() {
		for (Bean b : beanList) {

			initializeMx();

			mx.beginUpdate();

			try {
				addMxStartShape(b);
				printBeans(b, 1);
			} finally {
				mx.endUpdate();
			}

			mxCodec encoder = new mxCodec();
			Node node = encoder.encode(mg.getModel());
			System.out.println("--------------------");
			System.out.println(mxUtils.getPrettyXml(node));
		}
	}

	private void printBeans(Bean rootBean, int flow) {

		List l = getConstructorArgsList(rootBean);

		for (Object o : l.getBeanOrRefOrIdref()) {
			if (o instanceof Bean) {
				Bean b = (Bean) o;
				if (b.getClazz().equals(Router.class.toString())) {
//					TODO: terminar implementacao
					List listRef = getConstructorArgsList(b);
					int i = flow;
					for (Object o2 : listRef.getBeanOrRefOrIdref()) {
						Bean b2 = (Bean) o2;
						printBeans(b2, i);
						i++;
					}
				} else {
					Object currMv = addMxItemShape(b, flow);
					addEdge(currMv, this.lastMv);
					this.lastMv = currMv;
				}
			} else if (o instanceof Ref) {
				Ref r = (Ref) o;
				printBeans(getRootBeanById(r.getBean()), flow);
			}
		}
	}

	private List getConstructorArgsList(Bean rootBean) {
		ConstructorArg ca = (ConstructorArg) rootBean.getMetaOrConstructorArgOrProperty().get(0);
		List l = ca.getList();
		return l;
	}

	private Object addMxItemShape(Bean b, int flow) {
		incrementHeight();
		return this.mg.insertVertex(parent, b.getId(), b.getClazz(), x * flow, y, DEFAULT_NODE_WIDTH, 75);
	}

	private void addMxConditionShape(Bean b, int flow) {
		incrementHeight();
		this.lastMv = this.mg.insertVertex(parent, b.getId(), b.getId(), calculateCenter(ELIPSE_SIZE) * flow, y, ELIPSE_SIZE,
				ELIPSE_SIZE, mxConstants.SHAPE_HEXAGON);
	}
	
	private void addMxStartShape(Bean b) {
		incrementHeight();
		this.lastMv = this.mg.insertVertex(parent, b.getId(), b.getId(), calculateCenter(ELIPSE_SIZE), y, ELIPSE_SIZE,
				ELIPSE_SIZE, mxConstants.SHAPE_ELLIPSE);
	}
	

	private double calculateCenter(int wd) {
		return this.x + ((DEFAULT_NODE_WIDTH - 80) / 2);
	}

	private void addEdge(Object ini, Object end) {
		this.mg.insertEdge(parent, null, "", end, ini);
	}

	private void incrementHeight() {
		y += HEIGHT_ADD_VALUE;
	}

	private Bean getRootBeanById(String id) {

		return this.beanList.stream().filter(b -> id.equals(b.getId())).findFirst().orElseThrow(RuntimeException::new);

	}

}
