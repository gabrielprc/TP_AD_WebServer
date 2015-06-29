package svl.viajes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rmi.delegate.BusinessDelegate;
import svl.GenericHttpServlet;
import views.viajes.ViajeView;

@WebServlet("/mostrarParadas")
public class MostrarParadas extends GenericHttpServlet {
	private Integer idChofer;
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer idChofer = Integer.parseInt(request.getParameter("idChofer"));
		ViajeView viaje = null;
		
		try {
			 viaje = BusinessDelegate.getInstance().getInterfaz().obtenerViajeActivo(idChofer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("viaje", viaje);
		forwardJsp(request, response, "/jsp/Choferes/MisParadas.jsp");
	}

}
