package edu.tum.cal;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import edu.tum.cal.client.AddClient;
import edu.tum.cal.client.ClientConfiguration;
import edu.tum.cal.client.DivClient;
import edu.tum.cal.client.MulClient;
import edu.tum.cal.client.SubClient;
import edu.tum.cal.client.wsdl.AddNumbersResponse;
import edu.tum.cal.client.wsdl.DivNumbersResponse;
import edu.tum.cal.client.wsdl.MulNumbersResponse;
import edu.tum.cal.client.wsdl.SubNumbersResponse;

public class Calculator extends HttpServlet {

	private enum VNAME {
		NUM1, NUM2, OPERATOR
	};

	private enum OPERATOR {
		ADD, SUB, DIV, MUL
	};

	private enum BTN {
		COMP
	};

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			double num1Val = 0, num2Val = 0, res = 0;
			
//			check if operator variables were send
			if (!"".equals(req.getParameter(VNAME.NUM1.toString()))
					&& req.getParameter(VNAME.NUM2.toString()) != null) {
				num1Val = Double.parseDouble(req.getParameter(VNAME.NUM1.toString()));
			}
			if (!"".equals(req.getParameter(VNAME.NUM2.toString()))
					&& req.getParameter(VNAME.NUM2.toString()) != null) {
				num2Val = Double.parseDouble(req.getParameter(VNAME.NUM2.toString()));
			}
			
//			compute the result based on operator
			if (!"".equals(req.getParameter(BTN.COMP.toString())) && req.getParameter(BTN.COMP.toString()) != null) {
				ClientConfiguration clientConfig = new ClientConfiguration();
				Jaxb2Marshaller m = clientConfig.marshaller();

				String op = (String) req.getParameter(VNAME.OPERATOR.toString());
				if (op != null && OPERATOR.ADD.toString().equals(op)) {
					AddClient adder = clientConfig.getAddClient(m);
					AddNumbersResponse r = adder.addNumbers((double) num1Val, (double) num2Val);
					res = Double.parseDouble(r.getN1());
				} else if (op != null && OPERATOR.SUB.toString().equals(op)) {
					SubClient client = clientConfig.getSubClient(m);
					SubNumbersResponse r = client.subNumbers((double) num1Val, (double) num2Val);
					res = Double.parseDouble(r.getN1());
				} else if (op != null && OPERATOR.MUL.toString().equals(op)) {
					MulClient client = clientConfig.getMulClient(m);
					MulNumbersResponse r = client.mulNumbers((double) num1Val, (double) num2Val);
					res = Double.parseDouble(r.getN1());
				} else if (op != null && OPERATOR.DIV.toString().equals(op)) {
					DivClient client = clientConfig.getDivClient(m);
					DivNumbersResponse r = client.divNumbers((double) num1Val, (double) num2Val);
					res = Double.parseDouble(r.getN1());
				}
			}

			resp.getWriter().write(this.generateGui(res, num1Val, num2Val).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
//		BTRN: Compute ADD 0.0
		String op = "ADD";
		
		if(op != null && OPERATOR.ADD.toString().equals(op)){
			System.out.println("ok");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		this.doGet(req, resp);
	}

	private StringBuilder generateGui(double r, double a, double b) {
		StringBuilder _return = new StringBuilder();
		_return.append("<html>");
		_return.append("<body>");
		_return.append("<form action='/' method='post'>");
		_return.append("Number 1: <input type='text' name='" + VNAME.NUM1.toString() + "' value='" + a + "' /><br/>");
		_return.append("Operator: <select name='" + VNAME.OPERATOR.toString() + "'><option value='"
				+ OPERATOR.ADD.toString() + "'>" + OPERATOR.ADD.toString() + "</option><option value='"
				+ OPERATOR.SUB.toString() + "'>" + OPERATOR.SUB.toString() + "</option><option value='"
				+ OPERATOR.MUL.toString() + "'>" + OPERATOR.MUL.toString() + "</option><option value='"
				+ OPERATOR.DIV.toString() + "'>" + OPERATOR.DIV.toString() + "</option></select><br/>");
		_return.append("Number 2: <input type='text' name='" + VNAME.NUM2.toString() + "' value='" + b + "' /><br/>");
		_return.append("<input type='submit' name='" + BTN.COMP.toString() + "' value='Compute'/><br/><br/>");
		_return.append("Result: <input type='text' name='result' value='" + r + "'/>");

		_return.append("</body>");
		_return.append("</html>");
		return _return;
	}

}
